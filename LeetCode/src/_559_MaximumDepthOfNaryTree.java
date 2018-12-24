import java.util.List;

/*
 *  https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */

public class _559_MaximumDepthOfNaryTree {

   // Definition for a Node.
   class Node {
       public int val;
       public List<Node> children;

       public Node() {}

       public Node(int _val, List<Node> _children) {
           val = _val;
           children = _children;
       }
   }

   class Solution {
      public int maxDepth(Node root) {
         if (root == null) {
            return 0;
         }

         List<Node> children = root.children;
         int maximumDepth = 0;
         for (int i = 0; i < children.size(); i++) {
            maximumDepth = Math.max(maximumDepth, maxDepth(children.get(i)));
         }

         return maximumDepth + 1;
      }
   }
}
