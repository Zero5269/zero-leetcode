package cn.zero.leetcode.all.easy;//package cn.zero.all.easy;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 *  
 * <p>
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class All_589_Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)    return res;
        Stack<Node>  stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node cur = stack.pop();
            res.add(cur.val);
            for(int i = cur.children.size()-1; i >= 0; i--)
                stack.push(cur.children.get(i));
        }
        return res;
    }

//    @Test
//    public void test() {
//        int[] nums = new int[]{-1, -2, -3, -4, -5};
//        int target = -8;
//        int[] ints = twoSum(nums, target);
//        Assert.assertArrayEquals(ints, new int[]{2, 4});
//        System.out.println(Arrays.toString(ints));
//    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}


;
