//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1519 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);
        int height = 1 + Math.max(lHeight, rHeight);
        return height;
    }

    // 层序遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                root = queue.remove();
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
    }
}