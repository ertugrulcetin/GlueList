import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;


/**
 * Brand new List implementation.
 *
 * @author Ertuğrul Çetin
 *         ertu.ctn@gmail.com
 */
public class GlueList<T> extends AbstractList<T> implements List<T>, Cloneable, Serializable {

    transient Node<T> first;
    transient Node<T> last;

    private int size;

    int initialCapacity;

    private static final int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public GlueList() {

        Node<T> initNode = new Node<>(null, null, 0, DEFAULT_CAPACITY);

        first = initNode;
        last = initNode;
    }

    public GlueList(int initialCapacity) {

        this.initialCapacity = (initialCapacity > MAX_ARRAY_SIZE) ? MAX_ARRAY_SIZE : initialCapacity;

        Node<T> initNode = new Node<>(null, null, 0, initialCapacity);

        first = initNode;
        last = initNode;
    }

    public GlueList(Collection<? extends T> c) {

        Objects.requireNonNull(c);

        Object[] arr = c.toArray();

        int len = arr.length;

        if (len != 0) {

            Node<T> initNode = new Node<>(null, null, 0, len);

            first = initNode;
            last = initNode;

            System.arraycopy(arr, 0, last.elementData, 0, len);

            last.elementDataPointer += len;
        } else {

            Node<T> initNode = new Node<>(null, null, 0, DEFAULT_CAPACITY);

            first = initNode;
            last = initNode;
        }

        modCount++;
        size += len;
    }

    @Override
    public boolean add(T element) {

        Node<T> l = last;

        if (l.isAddable()) {
            l.add(element);
        } else {
            Node<T> newNode = new Node<>(l, null, size);
            newNode.add(element);
            last = newNode;
            l.next = last;
        }

        modCount++;
        size++;

        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, T element) {

        rangeCheckForAdd(index);

        Node<T> node = getNodeForAdd(index);

        if (node == null) {

            Node<T> l = last;

            Node<T> newNode = new Node<>(l, null, size);

            last = newNode;

            l.next = last;

            node = newNode;
        }

        //if it is last and has extra space for element...
        if (node == last && node.elementData.length - node.elementDataPointer > 0) {

            int nodeArrIndex = index - node.startingIndex;

            System.arraycopy(node.elementData, nodeArrIndex, node.elementData, nodeArrIndex + 1, node.elementDataPointer - nodeArrIndex);

            node.elementData[nodeArrIndex] = element;

            if (nodeArrIndex > 0) {
                System.arraycopy(node.elementData, 0, node.elementData, 0, nodeArrIndex);
            }

            node.elementDataPointer++;
        } else {

            int newLen = node.elementData.length + 1;
            T[] newElementData = (T[]) new Object[newLen];

            int nodeArrIndex = index - node.startingIndex;

            System.arraycopy(node.elementData, nodeArrIndex, newElementData, nodeArrIndex + 1, node.elementDataPointer - nodeArrIndex);

            newElementData[nodeArrIndex] = element;

            if (nodeArrIndex > 0) {
                System.arraycopy(node.elementData, 0, newElementData, 0, nodeArrIndex);
            }

            node.elementData = newElementData;
            node.endingIndex++;
            node.elementDataPointer++;
        }

        updateNodesAfterAdd(node);

        modCount++;
        size++;
    }

    private void rangeCheckForAdd(int index) {

        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    private void updateNodesAfterAdd(Node<T> nodeFrom) {

        for (Node<T> node = nodeFrom.next; node != null; node = node.next) {

            node.startingIndex++;
            node.endingIndex++;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(Collection<? extends T> c) {

        Objects.requireNonNull(c);

        Object[] collection = c.toArray();

        int len = collection.length;

        if (len == 0) {
            return false;
        }

        if (size == 0) {

            if (initialCapacity >= len) {
                System.arraycopy(collection, 0, last.elementData, 0, len);
            } else {
                last.elementData = Arrays.copyOf((T[]) collection, len);
                last.endingIndex = len - 1;
            }

            last.elementDataPointer += len;

            modCount++;
            size += len;

            return true;
        }

        //TODO elementSize name refactor -> last.elementDataPointer ?
        int elementDataLen = last.elementData.length;
        int elementSize = last.elementDataPointer;

        int remainedStorage = elementDataLen - elementSize;

        if (remainedStorage == 0) {

            Node<T> l = last;

            int newLen = (size >>> 1);
            int initialLen = (len > newLen) ? len : newLen;

            Node<T> newNode = new Node<>(l, null, size, initialLen);

            System.arraycopy(collection, 0, newNode.elementData, 0, len);

            newNode.elementDataPointer += len;

            last = newNode;
            l.next = last;

            modCount++;
            size += len;

            return true;
        }

        if (len <= remainedStorage) {

            System.arraycopy(collection, 0, last.elementData, elementSize, len);

            last.elementDataPointer += len;

            modCount++;
            size += len;

            return true;
        }

        if (len > remainedStorage) {

            System.arraycopy(collection, 0, last.elementData, elementSize, remainedStorage);

            last.elementDataPointer += remainedStorage;
            size += remainedStorage;

            int newLen = (size >>> 1);
            int remainedDataLen = len - remainedStorage;

            int initialLen = (newLen > remainedDataLen) ? newLen : remainedDataLen;

            Node<T> l = last;

            Node<T> newNode = new Node<>(l, null, size, initialLen);

            System.arraycopy(collection, remainedStorage, newNode.elementData, 0, remainedDataLen);

            newNode.elementDataPointer += remainedDataLen;

            last = newNode;
            l.next = last;

            modCount++;
            size += remainedDataLen;
        }

        return false;
    }

    @Override
    public T set(int index, T element) {

        rangeCheck(index);

        Node<T> node = getNode(index);

        int nodeArrIndex = index - node.startingIndex;

        T oldValue = node.elementData[nodeArrIndex];

        node.elementData[nodeArrIndex] = element;

        return oldValue;
    }

    @Override
    public T get(int index) {

        rangeCheck(index);

        Node<T> node = getNode(index);

        return node.elementData[index - node.startingIndex];
    }

    @Override
    public int indexOf(Object o) {

        int index = 0;

        if (o == null) {

            for (Node<T> node = first; node != null; node = node.next) {
                for (int i = 0; i < node.elementDataPointer; i++) {
                    if (node.elementData[i] == null) {
                        return index;
                    }
                    index++;
                }
            }
        } else {

            for (Node<T> node = first; node != null; node = node.next) {
                for (int i = 0; i < node.elementDataPointer; i++) {
                    if (o.equals(node.elementData[i])) {
                        return index;
                    }
                    index++;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = size - 1;

        if (o == null) {
            for (Node<T> node = last; node != null; node = node.pre) {
                for (int i = node.elementDataPointer - 1; i >= 0; i--) {
                    if (node.elementData[i] == null) {
                        return index;
                    }
                    index--;
                }
            }
        } else {

            for (Node<T> node = last; node != null; node = node.pre) {
                for (int i = node.elementDataPointer - 1; i >= 0; i--) {
                    if (o.equals(node.elementData[i])) {
                        return index;
                    }
                    index--;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {

        rangeCheck(index);

        Node<T> node;

        if (size == 2 && first != last) {

            Node<T> newNode = new Node<>(null, null, 0, 2);
            newNode.add(first.elementData[0]);
            newNode.add(last.elementData[0]);

            node = first = last = newNode;
        } else {
            node = getNode(index);
        }

        T[] elementData = node.elementData;

        int elementSize = node.elementDataPointer;

        int nodeArrIndex = index - node.startingIndex;

        T oldValue = elementData[nodeArrIndex];

        int numMoved = elementSize - nodeArrIndex - 1;

        if (numMoved > 0) {
            System.arraycopy(node.elementData, nodeArrIndex + 1, node.elementData, nodeArrIndex, numMoved);
        }

        if (first == last || node == last) {
            node.elementData[elementSize - 1] = null;
        } else {
            node.elementData = Arrays.copyOf(node.elementData, elementSize - 1);
            node.endingIndex = (--node.endingIndex < 0) ? 0 : node.endingIndex;
        }

        node.elementDataPointer--;

        updateNodesAfterRemove(node);

        if (node.elementDataPointer == 0 && first != last) {

            Node<T> next = node.next;
            Node<T> prev = node.pre;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                node.pre = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.pre = prev;
                node.next = null;
            }

            node.elementData = null;
        }

        size--;
        modCount++;

        return oldValue;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        Objects.requireNonNull(c);

        Object[] arr = c.toArray();
        if (arr.length == 0) {
            return false;
        }

        boolean isModified = false;

        for (Object o : arr) {
            isModified |= remove(o);
        }

        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        Objects.requireNonNull(c);

        Object[] arr = c.toArray();
        if (arr.length == 0) {
            return false;
        }

        boolean isModified = false;

        Object[] elements = toArray();

        for (Object element : elements) {

            if (!c.contains(element)) {
                isModified |= remove(element);
            }
        }

        return isModified;
    }

    @Override
    public boolean remove(Object o) {

        int index = indexOf(o);

        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    private void updateNodesAfterRemove(Node<T> fromNode) {

        for (Node<T> node = fromNode.next; node != null; node = node.next) {

            node.startingIndex = (--node.startingIndex < 0) ? 0 : node.startingIndex;
            node.endingIndex = (--node.endingIndex < 0) ? 0 : node.endingIndex;
        }
    }

    private Node<T> getNode(int index) {

        int firstStartingIndex = first.startingIndex;
        int firstEndingIndex = first.endingIndex;

        int firstMinDistance = min(abs(index - firstStartingIndex), abs(index - firstEndingIndex));

        int lastStartingIndex = last.startingIndex;
        int lastEndingIndex = last.endingIndex;

        int lastMinDistance = min(abs(index - lastStartingIndex), abs(index - lastEndingIndex));

        if (firstMinDistance <= lastMinDistance) {

            Node<T> node = first;
            do {

                if (node.startingIndex <= index && index <= node.endingIndex) {
                    return node;
                }

                node = node.next;
            } while (true);
        } else {

            Node<T> node = last;
            do {

                if (node.startingIndex <= index && index <= node.endingIndex) {
                    return node;
                }

                node = node.pre;
            } while (true);
        }
    }

    private Node<T> getNodeForAdd(int index) {

        if (index == size && !(last.startingIndex <= index && index <= last.endingIndex)) {
            return null;
        }

        return getNode(index);
    }

    private void rangeCheck(int index) {

        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    @Override
    public void clear() {

        for (Node<T> node = first; node != null; ) {

            Node<T> next = node.next;

            node.next = null;
            node.pre = null;
            node.elementData = null;

            node = next;
        }

        first = last = null;

        int capacity = min(MAX_ARRAY_SIZE, max(size, max(initialCapacity, DEFAULT_CAPACITY)));

        Node<T> initNode = new Node<>(null, null, 0, capacity);

        initialCapacity = capacity;

        first = initNode;
        last = initNode;

        modCount++;
        size = 0;
    }

    public void trimToSize() {

        int pointer = last.elementDataPointer;
        int arrLen = last.elementData.length;

        if (pointer < arrLen && arrLen > 2) {

            if (pointer < 2) {
                last.elementData = Arrays.copyOf(last.elementData, 2);
                last.endingIndex -= arrLen - 2;
            } else {
                last.elementData = Arrays.copyOf(last.elementData, pointer);
                last.endingIndex -= arrLen - pointer;
            }
        }
    }

    //TODO testit !!
    @Override
    public List<T> subList(int fromIndex, int toIndex) {

        subListRangeCheck(fromIndex, toIndex, size);

        int initialSize = toIndex - fromIndex;
        if (initialSize == 0) {
            return new GlueList<>();
        }

        GlueList<T> list = new GlueList<>(initialSize);

        int i = 0;
        for (Node<T> node = first; node != null; node = node.next) {

            for (int j = 0; j < node.elementDataPointer; j++) {

                if (fromIndex <= i && i < toIndex) {
                    list.add(node.elementData[j]);
                }

                i++;
            }
        }

        return list;
    }

    private void subListRangeCheck(int fromIndex, int toIndex, int size) {

        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }

        if (toIndex > size) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }

        if (fromIndex > toIndex) {
            throw new ArrayIndexOutOfBoundsException("From Index: " + fromIndex + " - To Index: " + toIndex);
        }
    }

    @Override
    public Object[] toArray() {

        Object[] objects = new Object[size];

        int i = 0;
        for (Node<T> node = first; node != null; node = node.next) {

            int len = node.elementDataPointer;

            if (len > 0) {
                System.arraycopy(node.elementData, 0, objects, i, len);
            }

            i += len;
        }

        return objects;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        Node<T> node = first;

        int i = 0;//inner-array index
        int j = 0;//total index -> cursor

        int lastReturn = -1;

        int expectedModCount = modCount;
        int elementDataPointer = node.elementDataPointer;

        @Override
        public boolean hasNext() {
            return j != size;
        }

        @Override
        public T next() {

            checkForComodification();

            if (j >= size) {
                throw new NoSuchElementException();
            }

            if (j >= last.endingIndex + 1) {
                throw new ConcurrentModificationException();
            }

            if (j == 0) {// it's for listIterator.when node becomes null.
                node = first;
                elementDataPointer = node.elementDataPointer;
                i = 0;
            }

            T val = node.elementData[i++];

            if (i >= elementDataPointer) {
                node = node.next;
                i = 0;
                elementDataPointer = (node != null) ? node.elementDataPointer : 0;
            }

            lastReturn = j++;

            return val;
        }

        @Override
        public void remove() {

            if (lastReturn < 0) {
                throw new IllegalStateException();
            }

            checkForComodification();

            try {
                GlueList.this.remove(lastReturn);

                j = lastReturn;

                lastReturn = -1;

                i = (--i < 0) ? 0 : i;

                elementDataPointer = (node != null) ? node.elementDataPointer : 0;

                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public ListIterator<T> listIterator(int index) {

        checkPositionIndex(index);

        return new ListItr(index);
    }

    private void checkPositionIndex(int index) {

        if (!(index >= 0 && index <= size)) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListItr(0);
    }

    private class ListItr extends Itr implements ListIterator<T> {

        //TODO check , be sure about i's value
        public ListItr(int index) {
           /* node = (index == size) ? last : getNode(index);
            j = index;
//            i = index - node.startingIndex;*/
        }

        @Override
        public boolean hasPrevious() {
            return j != 0;
        }

        @Override
        public T previous() {

            checkForComodification();

            if (j <= 0) {
                throw new NoSuchElementException();
            }

            if (j - 1 >= last.endingIndex + 1) {
                throw new ConcurrentModificationException();
            }

            if (j == size) {

                node = last;

                elementDataPointer = node.elementDataPointer;

                i = elementDataPointer;
            }

            int index = j - node.startingIndex;
            if (index == 0) {

                node = node.pre;

                elementDataPointer = node.elementDataPointer;

                i = elementDataPointer;
            }

            T val = node.elementData[--i];

            if (i < 0) {
                node = node.pre;
                i = (node != null) ? node.elementDataPointer : 0;
            }

            lastReturn = j--;

            return val;
        }

        @Override
        public int nextIndex() {
            return j;
        }

        @Override
        public int previousIndex() {
            return j - 1;
        }

        @Override
        public void set(T t) {

            if (lastReturn < 0) {
                throw new IllegalStateException();
            }

            checkForComodification();

            try {
                GlueList.this.set(lastReturn, t);
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        //TODO check i . is it work correctly ? Check add(int,element) ?
        @Override
        public void add(T t) {

            checkForComodification();

            try {
                int temp = j;

                GlueList.this.add(temp, t);

                j = temp + 1;

                lastReturn = -1;

                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {

        try {
            GlueList<T> clone = (GlueList<T>) super.clone();

            clone.first = clone.last = null;

            int capacity = min(MAX_ARRAY_SIZE, max(clone.size, max(clone.initialCapacity, DEFAULT_CAPACITY)));

            Node<T> initNode = new Node<>(null, null, 0, capacity);

            clone.initialCapacity = capacity;

            clone.first = clone.last = initNode;

            clone.modCount = 0;
            clone.size = 0;

            for (Node<T> node = first; node != null; node = node.next) {

                for (int i = 0; i < node.elementDataPointer; i++) {
                    clone.add(node.elementData[i]);
                }
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {

        int expectedModCount = modCount;

        s.defaultWriteObject();

        s.writeInt(size);

        for (Node<T> node = first; node != null; node = node.next) {
            for (int i = 0; i < node.elementDataPointer; i++) {
                s.writeObject(node.elementData[i]);
            }
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }


    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {

        clear();

        s.defaultReadObject();

        int size = s.readInt();

        for (int i = 0; i < size; i++) {
            last.add((T) s.readObject());
        }
    }

    //TODO for test
    void printClustered() {

        StringBuilder str = new StringBuilder();

        for (Node<T> node = first; node != null; node = node.next) {

            StringBuilder s = new StringBuilder("[");

            if (node.elementDataPointer > 0) {
                s.append(node.elementData[0]);
            }

            for (int i = 1; i < node.elementDataPointer; i++) {
                s.append(",").append(node.elementData[i]);
            }
            s.append("]");

            str.append(s);
        }

        System.out.println(str);
    }

    String printValuesClustered() {

        StringBuilder str = new StringBuilder();

        for (Node<T> node = first; node != null; node = node.next) {

            StringBuilder s = new StringBuilder("[");

            if (node.elementDataPointer > 0) {
                s.append(node.elementData[0]);
            }

            for (int i = 1; i < node.elementDataPointer; i++) {
                s.append(",").append(node.elementData[i]);
            }
            s.append("]");

            str.append(s);
        }

        return str.toString();
    }

    void printClusteredWithAllocations() {

        StringBuilder str = new StringBuilder();

        for (Node<T> node = first; node != null; node = node.next) {

            StringBuilder s = new StringBuilder("[");
            //TODO not sure about >= ?? maybe it has to be >
            if (node.elementDataPointer >= 0) {
                s.append(node.elementData[0]);
            }

            for (int i = 1; i < node.elementData.length; i++) {
                s.append(",").append(node.elementData[i]);
            }
            s.append("]");

            str.append(s);
        }

        System.out.println(str);
    }

    String printValuesClusteredWithAllocations() {

        StringBuilder str = new StringBuilder();

        for (Node<T> node = first; node != null; node = node.next) {

            StringBuilder s = new StringBuilder("[");
            //TODO not sure about >= ?? maybe it has to be >
            if (node.elementDataPointer >= 0) {
                s.append(node.elementData[0]);
            }

            for (int i = 1; i < node.elementData.length; i++) {
                s.append(",").append(node.elementData[i]);
            }
            s.append("]");

            str.append(s);
        }

        return str.toString();
    }

    static class Node<T> {

        Node<T> pre;
        Node<T> next;

        int listSize;

        int startingIndex;
        int endingIndex;

        T[] elementData;
        int elementDataPointer;

        @SuppressWarnings("unchecked")
        Node(Node<T> pre, Node<T> next, int listSize) {
            this.pre = pre;
            this.next = next;
            this.listSize = listSize;
            this.elementData = (T[]) new Object[listSize >>> 1];
            this.startingIndex = listSize;
            this.endingIndex = listSize + elementData.length - 1;
        }

        Node(Node<T> pre, Node<T> next, int listSize, int initialCapacity) {
            this.pre = pre;
            this.next = next;
            this.listSize = listSize;
            this.elementData = createElementData(initialCapacity);
            this.startingIndex = listSize;
            this.endingIndex = listSize + elementData.length - 1;
        }

        @SuppressWarnings("unchecked")
        T[] createElementData(int capacity) {

            if (capacity == 0 || capacity == 1) {
                return (T[]) new Object[DEFAULT_CAPACITY];
            } else if (capacity > 1) {
                return (T[]) new Object[capacity];
            } else {
                throw new IllegalArgumentException("Illegal Capacity: " + capacity);
            }
        }

        boolean isAddable() {
            return elementDataPointer < elementData.length;
        }

        void add(T element) {
            elementData[elementDataPointer++] = element;
        }

        // Getters for tests
        int getElementDataLength() {
            return elementData.length;
        }

        public int getStartingIndex() {
            return startingIndex;
        }

        public int getEndingIndex() {
            return endingIndex;
        }

        public T[] getElementData() {
            return elementData;
        }

        public int getElementDataPointer() {
            return elementDataPointer;
        }

        @Override
        public String toString() {
            return String.format("[sIndex: %d - eIndex: %d | elementDataPointer: %d | elementDataLength: %d]", startingIndex, endingIndex, elementDataPointer, elementData.length);
        }
    }
}