import java.util.*;

public class BinaryTreeAverageAtDepth {
    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode(4,
                new BinaryTreeNode(7,
                        new BinaryTreeNode(10, null, null),
                        new BinaryTreeNode(2, null,
                                new BinaryTreeNode(6,
                                        new BinaryTreeNode(2, null, null), null))),
                new BinaryTreeNode(9, null,
                        new BinaryTreeNode(6, null, null)));

        getAverageAtTreeDepth(tree);
        getAverageAtTreeDepthV2(tree);
        getAverageAtTreeDepthV3(tree);
    }

    private static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode left, right;

        public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }

    /**
     * Given a binary tree, get the average value at each level of the tree
     *
     * Input:
     *      4
     *     / \
     *    7  9
     *   /\   \
     *  10 2   6
     *     \
     *      6
     *     /
     *    2
     *
     * Output:
     * [4, 8, 6, 6, 2]
     *
     *
     * Good Questions to ask:
     * Will all the node values be integers? Null values?
     * Should the output be an integer (integer math vs. double)?
     */


    //
    // VERSION 1: Depth-first search
    //

    public static void getAverageAtTreeDepth(BinaryTreeNode tree) {
        System.out.println("\nDepth-first search");
        HashMap<Integer, List<Integer>> treeValues = traverseTree(tree, 0, new HashMap<>());

        List<Double> result = new ArrayList<>();
        for (List<Integer> list : treeValues.values()) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            result.add((double) sum / list.size());
        }

        System.out.println(result);
    }

    private static HashMap traverseTree(BinaryTreeNode tree, int level, HashMap<Integer, List<Integer>> treeValues) {
        // Left
        if (tree.getLeft() != null) {
            traverseTree(tree.getLeft(), level + 1, treeValues);
        }

        // Right
        if (tree.getRight() != null) {
            traverseTree(tree.getRight(), level + 1, treeValues);
        }

        // Create level if it doesn't exist
        // treeValues.computeIfAbsent(level, k -> new ArrayList<>());
        if (treeValues.get(level) == null) {
            treeValues.put(level, new ArrayList<>());
        }

        treeValues.get(level).add(tree.getValue());

        return treeValues;
    }

    //
    // VERSION 2: Depth-first search - Integer array
    //

    public static void getAverageAtTreeDepthV2(BinaryTreeNode tree) {
        System.out.println("\nDepth-first search - Integer array");

        List<Integer[]> treeValues = traverseTreeV2(tree, 0, new ArrayList<>());

        List<Double> result = new ArrayList<>();
        for (Integer[] values : treeValues) {
            result.add((double) values[0] / values[1]);
        }

        System.out.println(result);
    }

    private static List<Integer[]> traverseTreeV2(BinaryTreeNode tree, int level, List<Integer[]> treeValues) {
        Integer[] valuesAtLevel;
        try {
            valuesAtLevel = treeValues.get(level);
            valuesAtLevel[0] += tree.getValue();
            valuesAtLevel[1]++;
        }
        // Create level if it doesn't exist
        catch (IndexOutOfBoundsException ex) {
            // [ SUM, COUNT ]
            valuesAtLevel = new Integer[]{tree.getValue(), 1};
            treeValues.add(level, valuesAtLevel);
        }

        // Left
        if (tree.getLeft() != null) {
            traverseTreeV2(tree.getLeft(), level + 1, treeValues);
        }

        // Right
        if (tree.getRight() != null) {
            traverseTreeV2(tree.getRight(), level + 1, treeValues);
        }

        return treeValues;
    }

    //
    // VERSION 3: Breadth-first search - Queue
    //
    public static void getAverageAtTreeDepthV3(BinaryTreeNode tree) {
        System.out.println("\nBreadth-first search - Queue");

        Queue<QueueItem> queue = new LinkedList<>();
        queue.add(new QueueItem(tree, 0));
        int sum = 0;
        int count = 0;
        int level = 0;
        ArrayList<Double> avgValues = new ArrayList<>();
        while (!queue.isEmpty()) {
            QueueItem item = queue.poll();

            // Moved to a new level
            if (level != item.level) {
                avgValues.add((double) sum / count);
                sum = 0;
                count = 0;
                level = item.level;
            }

            if (item.node == null) {
                continue;
            }

            sum += item.node.value;
            count++;

            queue.add(new QueueItem(item.node.left, level + 1));
            queue.add(new QueueItem(item.node.right, level + 1));
        }

        System.out.println(avgValues);
    }

    public static class QueueItem {
        BinaryTreeNode node;
        int level;

        QueueItem(BinaryTreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

}
