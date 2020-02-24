package homework1;

public interface Tree {
    void insert(TreeNode elem);
    boolean remove(TreeNode elem);
    boolean contains(TreeNode elem);
    void printAll();
    void printAllByLevels();
}
