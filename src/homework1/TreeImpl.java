package homework1;

import java.util.*;

public class TreeImpl implements Tree, Iterable {

    @Override
    public MyIterator getIterator(String string) {
        switch (string) {
            case "BFS":
                return new IteratorBFS();
            case "DFS":
                return new IteratorDFS();
            case "BFSP":
                return new IteratorBFSP();
            // по умолчанию
            default: return new IteratorBFS();
        }
    }

    class IteratorBFS implements MyIterator {
        TreeNode position;
        Deque<TreeNode> deque;

        private IteratorBFS() {
            position = root;
            deque = new ArrayDeque<>();
            deque.push(root);
        }

        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }

        @Override
        public TreeNode next() {
            position = deque.pop();
            if (!position.children.isEmpty()) {
                position.children.forEach(o -> deque.addLast(o));
            }
            return position;
        }
    }

    class IteratorDFS implements MyIterator {
        TreeNode position;
        Deque<TreeNode> deque;

        private IteratorDFS() {
            position = root;
            deque = new ArrayDeque<>();
            deque.push(position);
        }

        @Override
        public TreeNode next() {
            position = deque.pop();
            if (!position.children.isEmpty()) {
                position.children.forEach(o -> deque.push(o));
            }
            return position;
        }

        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }

    class IteratorBFSP implements MyIterator {
        TreeNode position;
        Deque<TreeNode> deque;

        Comparator<TreeNode> comparator = (o1, o2) -> o2.priority - o1.priority;

        private IteratorBFSP() {
            position = root;
            deque = new ArrayDeque<>();
            deque.push(position);
        }

        @Override
        public TreeNode next() {
            position = deque.pop();
            if (!position.children.isEmpty()) {
                position.children.stream().sorted(comparator).forEachOrdered(o -> deque.addLast(o));
            }
            return position;
        }

        @Override
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }


    private TreeNode root;

    public TreeImpl(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void attachParents() {
        attachParents(root);
    }

    private void attachParents(TreeNode node) {
        if (!node.children.isEmpty()) {
            for (TreeNode child : node.children) {
                child.parent = node;
                attachParents(child);
            }
        }
    }

    @Override
    public void insert(TreeNode elem) {

    }

    @Override
    public boolean remove(TreeNode elem) {
        return false;
    }

    @Override
    public boolean contains(TreeNode elem) {
        return false;
    }

    @Override
    public void printAll() {

    }

    @Override
    public void printAllByLevels() {

    }
}
