import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.StringJoiner;


/**
 * Brand new List implementation.
 *
 * @author Ertuğrul Çetin
 *         ertu.ctn@gmail.com
 */
public class GlueList<T> extends AbstractList<T> implements List<T>, Cloneable, Serializable {

    private transient Node<T> first;
    private transient Node<T> last;

    private int size;

    private int initialCapacity;

    private static final int DEFAULT_CAPACITY = 10;


    public GlueList() {

        Node<T> initNode = new Node<>(null, null, 0, DEFAULT_CAPACITY);

        first = initNode;
        last = initNode;
    }

    public GlueList(int initialCapacity) {

        this.initialCapacity = initialCapacity;

        Node<T> initNode = new Node<>(null, null, 0, initialCapacity);

        first = initNode;
        last = initNode;
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

        Node<T> node = getNode(index);

        if (node == last && node.elementData.length - node.elementDataPointer > 0) {

            int innerArrIndex = index - node.startingIndex;

            System.arraycopy(node.elementData, innerArrIndex, node.elementData, innerArrIndex + 1, node.elementData.length - innerArrIndex);

            node.elementData[index] = element;

            if (index > 0) {
                System.arraycopy(node.elementData, 0, node.elementData, index, index);
            }

            node.elementDataPointer++;
        } else {

            int newLen = node.elementData.length + 1;
            T[] newElementData = (T[]) new Object[newLen];

            int innerArrIndex = index - node.startingIndex;

            System.arraycopy(node.elementData, innerArrIndex, newElementData, innerArrIndex + 1, node.elementData.length - innerArrIndex);

            newElementData[index] = element;

            if (index > 0) {
                System.arraycopy(node.elementData, 0, newElementData, index, index);
            }

            node.elementData = newElementData;
            node.endingIndex++;
            node.elementDataPointer++;
        }

        updateNodesAfterAdd(node);

        modCount++;
        size++;
    }

    private void updateNodesAfterAdd(Node<T> nodeFrom) {

        for (Node<T> node = nodeFrom.next; node != null; node = node.next) {

            node.startingIndex++;
            node.endingIndex++;
        }
    }

    private void rangeCheckForAdd(int index) {

        if (index > size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
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
            }

            last.elementDataPointer += len;
            last.startingIndex = 0;
            last.endingIndex = len - 1;

            modCount++;
            size += len;

            return true;
        }

        T[] elementData = last.elementData;
        int elementDataLen = elementData.length;
        int elementSize = last.elementDataPointer;

        int remainedStorage = elementDataLen - elementSize;

        if (remainedStorage == 0) {

            Node<T> l = last;

            int newLen = (size >>> 1);
            int initialLen = (len > newLen) ? len : newLen;

            Node<T> newNode = new Node<>(l, null, size, initialLen);

            System.arraycopy(collection, 0, newNode.elementData, 0, len);

            newNode.startingIndex = size;
            newNode.endingIndex = size + len - 1;
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

            last.elementDataPointer += len;
            size += remainedStorage;

            int newLen = (size >>> 1);
            int remainedDataLen = len - remainedStorage;

            int initialLen = (newLen > remainedDataLen) ? newLen : remainedDataLen;

            Node<T> l = last;

            Node<T> newNode = new Node<>(l, null, size, initialLen);

            System.arraycopy(collection, 0, newNode.elementData, 0, remainedDataLen);

            newNode.startingIndex = size;
            newNode.endingIndex = size + remainedDataLen - 1;
            newNode.elementDataPointer += remainedDataLen;

            last = newNode;
            l.next = last;

            modCount++;
            size += len;
        }

        return false;
    }

    @Override
    public T set(int index, T element) {

        rangeCheck(index);

        Node<T> node = getNode(index);

        int innerArrIndex = index - node.startingIndex;

        T oldValue = node.elementData[innerArrIndex];

        node.elementData[innerArrIndex] = element;

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

        if (o == null) {

            int index = 0;
            for (Node<T> node = first; node != null; node = node.next) {
                for (int i = 0; i < node.elementData.length; i++) {
                    if (node.elementData[i] == null) {
                        return index;
                    }
                    index++;
                }
            }
        } else {

            int index = 0;
            for (Node<T> node = first; node != null; node = node.next) {
                for (int i = 0; i < node.elementData.length; i++) {
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

        if (o == null) {
            int index = 0;
            for (Node<T> node = last; node != null; node = node.pre) {
                for (int i = node.elementDataPointer - 1; i >= 0; i--) {
                    if (node.elementData[i] == null) {
                        return index;
                    }
                    index++;
                }
            }
        } else {

            int index = 0;
            for (Node<T> node = last; node != null; node = node.pre) {
                for (int i = node.elementDataPointer - 1; i >= 0; i--) {
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
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public T remove(int index) {

        rangeCheck(index);

        Node<T> node = getNode(index);

        T[] elementData = node.elementData;

        int elementSize = node.elementDataPointer;

        int innerArrIndex = index - node.startingIndex;

        T oldValue = elementData[innerArrIndex];

        int numMoved = elementSize - innerArrIndex - 1;

        if (numMoved > 0) {
            System.arraycopy(node.elementData, innerArrIndex + 1, node.elementData, innerArrIndex, numMoved);
        }
        node.elementData = Arrays.copyOf(node.elementData, elementSize - 1);

        node.elementDataPointer--;

        int newEndingIndex = node.endingIndex - 1;
        node.endingIndex = (newEndingIndex < 0) ? 0 : newEndingIndex;

        updateNodesAfterRemove(node);

        if (node.elementDataPointer == 0) {

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

        for (Object o : arr) {
            remove(o);
        }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        Objects.requireNonNull(c);

        Object[] arr = c.toArray();
        if (arr.length == 0) {
            return false;
        }

        boolean modified = false;

        for (Node<T> node = first; node != null; node = node.next) {

            int i;
            for (i = 0; i < node.elementDataPointer; ) {

                T element = node.elementData[i];

                if (!c.contains(element)) {

                    remove(element);

                    i = node.startingIndex;

                    modified = true;
                } else {
                    i++;
                }
            }
        }

        return modified;
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

            int newStartingIndex = node.startingIndex - 1;
            int newEndingIndex = node.endingIndex - 1;

            node.startingIndex = (newStartingIndex < 0) ? 0 : newStartingIndex;
            node.endingIndex = (newEndingIndex < 0) ? 0 : newEndingIndex;
        }
    }

    private Node<T> getNode(int index) {

        rangeCheck(index);

        Node<T> node = first;
        do {

            if (node.startingIndex <= index && index <= node.endingIndex) {
                return node;
            }

            node = node.next;
        } while (true);
    }

    private void rangeCheck(int index) {

        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void clear() {

        for (Node<T> node = first; node != null; node = node.next) {

            T[] data = node.elementData;

            for (int i = 0; i < node.elementDataPointer; i++) {
                data[i] = null;
            }

            node.elementDataPointer = 0;
        }

        modCount++;
        size = 0;
    }

    public void clearAll() {

        for (Node<T> node = first; node != null; ) {

            Node<T> next = node.next;

            node.next = null;
            node.pre = null;
            node.elementData = null;

            node = next;
        }

        int capacity = (initialCapacity > 1) ? initialCapacity : DEFAULT_CAPACITY;

        Node<T> initNode = new Node<>(null, null, 0, capacity);

        first = initNode;
        last = initNode;

        modCount++;
        size = 0;
    }

    public void trimToSize() {

        int pointer = last.elementDataPointer;
        int arrLen = last.elementData.length;
        if (pointer < arrLen) {
            if (pointer != 0) {
                last.elementData = Arrays.copyOf(last.elementData, pointer);
            }
        }
    }

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

            System.arraycopy(node.elementData, 0, objects, i, len);

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
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {

        try {
            GlueList<T> clone = (GlueList<T>) super.clone();

            clone.first = clone.last = null;
            clone.size = 0;
            clone.modCount = 0;

            for (Node<T> node = first; node != null; node = node.next) {

                for (int i = 0; i < node.elementDataPointer; i++) {
                    clone.add(node.elementData[i]);
                }
            }

            return clone;

        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public String toString() {

        StringJoiner sc = new StringJoiner(",", "[", "]");
        for (Node<T> node = first; node != null; node = node.next) {

            T[] elementData = node.elementData;
            for (int i = 0; i < elementData.length; i++) {
                sc.add(String.valueOf(elementData[i]));
            }
        }

        return sc.toString();
    }

    private static class Node<T> {

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
    }
}