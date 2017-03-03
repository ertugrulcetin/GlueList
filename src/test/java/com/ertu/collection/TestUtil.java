package com.ertu.collection;

import com.ertu.collection.GlueList;

public class TestUtil {

    private TestUtil() {
    }

    public static <T> void printNodesStartingAndEndingIndexes(final GlueList<T> glueList) {

        int totalNodesCreated = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (GlueList.Node<T> node = glueList.getFirst(); node != null; node = node.getNext()) {
            stringBuilder.append("[").append(node.getStartingIndex()).append(",").append(node.getEndingIndex()).append("] ");
            totalNodesCreated++;
        }
        String result = stringBuilder.toString();

        if (result.length() == 0) {
            System.out.println("[]");
            System.out.println("Total Nodes: " + totalNodesCreated);
        } else {
            System.out.println(result);
            System.out.println("Total Nodes: " + totalNodesCreated);
        }
    }

    public static <T> void printNodesInfo(final GlueList<T> glueList) {

        int totalNodesCreated = 0;

        for (GlueList.Node<T> node = glueList.getFirst(); node != null; node = node.getNext()) {
            System.out.println(node);
            totalNodesCreated++;
        }

        System.out.println("Total Nodes: " + totalNodesCreated);
        System.out.println();
    }

    public static <T> boolean isNodesStartingAndEndingIndexesAreTrue(final GlueList<T> glueList) {

        for (GlueList.Node<T> node = glueList.getFirst(); node != null; node = node.getNext()) {

            GlueList.Node<T> nodeNext = node.getNext();
            if (nodeNext == null) {
                continue;
            }

            if (node.getEndingIndex() + 1 != nodeNext.getStartingIndex()) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isNodesElementDataPointerSameWithNodeArrayLength(final GlueList<T> glueList) {

        //goes until last.Because last may not been loaded
        for (GlueList.Node<T> node = glueList.getFirst(); node != glueList.getLast(); node = node.getNext()) {

            if (node.getElementDataPointer() != node.getElementData().length) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isItCorrectAfterAllDataDeleted(final GlueList<T> glueList) {

        if (glueList.size() != 0) {
            return false;
        }

        if (glueList.getFirst() != glueList.getLast()) {
            return false;
        }

        if (glueList.getLast().getElementDataPointer() != 0) {
            return false;
        }

        if (glueList.getLast().getElementData().length < 2) {
            return false;
        }

        if (glueList.getLast().getStartingIndex() > glueList.getLast().getEndingIndex()) {
            return false;
        }

        return true;
    }

    public static <T> boolean isFirstAndLastNodesAreEqual(final GlueList<T> glueList) {
        return glueList.getFirst() == glueList.getLast();
    }
}
