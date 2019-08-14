import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 implements Solution {
    @Override
    public List<TreeNode> generateTrees(int n) {

        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        if (start > end) {
            return Collections.EMPTY_LIST;
        } else if (start == end) {
            return Arrays.asList(new TreeNode(start));
        } else {
            List<TreeNode> result = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (i == start) {
                    List<TreeNode> rightTrees = genTrees(i + 1, end);
                    for (TreeNode right : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.right = right;
                        result.add(root);
                    }
                } else if (i == end) {
                    List<TreeNode> leftTrees = genTrees(start, i-1);
                    for (TreeNode left : leftTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        result.add(root);
                    }
                } else {
                    List<TreeNode> leftTrees = genTrees(start, i - 1);
                    List<TreeNode> rightTrees = genTrees(i + 1, end);
                    for (TreeNode left : leftTrees) {
                        for (TreeNode right : rightTrees) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            result.add(root);
                        }
                    }
                }
            }
            return result;
        }
    }
}
