package main.graph;

import java.util.*;
/*

At each node:
    Check if you found p or q in left subtree
    Check if you found p or q in right subtree
    Check if current node is p or q
If at least 2 of these are true → This node is the lowest common ancestor (LCA).


 */
public class LongestCommonAncestor {

     static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Deque<TreeNode> stack=new ArrayDeque<>();
        Map<TreeNode,TreeNode> parent=new HashMap<>();

        stack.push(root);
        parent.put(root, null);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node=stack.pop();

            if(node.left!=null){
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if(node.right!=null){
                parent.put(node.right,node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestor=new HashSet<>();
        while(p!=null){
            ancestor.add(p);
            p=parent.get(p);
        }

        while(!ancestor.contains(q)){
            q=parent.get(q);
        }
        return q;
    }
    TreeNode ans;

    TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorRecursionUtil(root,p,q);
        return  ans;
    }

    boolean lowestCommonAncestorRecursionUtil(TreeNode current, TreeNode p, TreeNode q){
        if(current==null)return false;

        int left=lowestCommonAncestorRecursionUtil(current.left,p,q)?1:0;
        int right=lowestCommonAncestorRecursionUtil(current.right,p,q)?1:0;
        int mid=(current==p || current==q)?1:0;
        if((left+mid+right)>=2)ans=current;

        return (left+mid+right)>0;

    }

}
