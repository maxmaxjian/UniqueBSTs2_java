import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int input;
    private List<List<Integer>> expected;
    private Solution soln = new Solution1();

    public SolutionTest(int input, List<List<Integer>> output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {3, Arrays.asList(
                        Arrays.asList(1,2,3), Arrays.asList(1,3,2), Arrays.asList(2,1,3),
                        Arrays.asList(3,1,2), Arrays.asList(3,2,1)
                )}
        });
    }

    @Test
    public void test() {
        List<List<Integer>> actual = new ArrayList<>();
        List<TreeNode> result = soln.generateTrees(input);
        for (TreeNode root : result) {
            List<Integer> temp = preorder(root);
            actual.add(temp);
        }
        assertEquals(expected, actual);
    }

    private boolean checkEquals(List<Integer> expected, List<TreeNode> actual) {
        if (expected.size() != actual.size()) {
            return false;
        } else {
            for (int i = 0; i < expected.size(); i++) {
                if (expected.get(i) != actual.get(i).val) {
                    return false;
                }
            }
            return true;
        }
    }

    private List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
}