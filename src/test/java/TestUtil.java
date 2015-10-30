public class TestUtil {

    public static <T> void printNodesStartingAndEndingIndexes(GlueList.Node<T> from) {

        int totalNodesCreated = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (GlueList.Node<T> node = from; node != null; node = node.next) {
            stringBuilder.append("[").append(node.startingIndex).append(",").append(node.endingIndex).append("] ");
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

    public static <T> boolean isNodesStartingAndEndingIndexesAreTrue(GlueList<T> glueList) {

        for (GlueList.Node<T> node = glueList.first; node != null; node = node.next) {

            GlueList.Node<T> nodeNext = node.next;
            if (nodeNext == null) {
                continue;
            }

            if (node.endingIndex + 1 != nodeNext.startingIndex) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isNodesElementDataPointerSameWithNodeArrayLength(GlueList<T> glueList) {

        //goes until last.Because last may not been loaded
        for (GlueList.Node<T> node = glueList.first; node != glueList.last; node = node.next) {

            if (node.elementDataPointer != node.elementData.length) {
                return false;
            }
        }

        return true;
    }
}