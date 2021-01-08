package BinaryTree;

import java.util.*;

public class AllKNodesDistance {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.val = data;
		}
	}
	TreeNode root;
	
	public static void main(String[] args) {
		
		AllKNodesDistance tree = new AllKNodesDistance();

		/* Let us construct the tree shown in above diagram */
		tree.root = new TreeNode(20);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(22);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(12);
		tree.root.left.right.left = new TreeNode(10);
		tree.root.left.right.right = new TreeNode(14);
		TreeNode target = tree.root.left.right;
		
		List ls = tree.distanceK(tree.root, target, 1);
		System.out.println(ls);
	}

	    static Map<TreeNode, TreeNode> parent;
	    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	        parent = new HashMap();
	        dfs(root, null);

	        Queue<TreeNode> queue = new LinkedList();
	        queue.add(null);
	        queue.add(target);

	        Set<TreeNode> seen = new HashSet();
	        seen.add(target);
	        seen.add(null);

	        int dist = 0;
	        while (!queue.isEmpty()) {
	            TreeNode node = queue.poll();
	            if (node == null) {
	                if (dist == K) {
	                    List<Integer> ans = new ArrayList();
	                    for (TreeNode n: queue)
	                        ans.add(n.val);
	                    return ans;
	                }
	                queue.offer(null);
	                dist++;
	            } else {
	                if (!seen.contains(node.left)) {
	                    seen.add(node.left);
	                    queue.offer(node.left);
	                }
	                if (!seen.contains(node.right)) {
	                    seen.add(node.right);
	                    queue.offer(node.right);
	                }
	                TreeNode par = parent.get(node);
	                if (!seen.contains(par)) {
	                    seen.add(par);
	                    queue.offer(par);
	                }
	            }
	        }

	        return new ArrayList<Integer>();
	    }

	    public static void dfs(TreeNode node, TreeNode par) {
	        if (node != null) {
	            parent.put(node, par);
	            dfs(node.left, node);
	            dfs(node.right, node);
	        }
	    }
	    
	    public static TreeNode createBinaryTree() {

			TreeNode rootNode = new TreeNode(40);
			TreeNode node20 = new TreeNode(20);
			TreeNode node10 = new TreeNode(10);
			TreeNode node30 = new TreeNode(30);
			TreeNode node60 = new TreeNode(60);
			TreeNode node50 = new TreeNode(50);
			TreeNode node70 = new TreeNode(70);
			TreeNode node5 = new TreeNode(5);
			TreeNode node45 = new TreeNode(45);
			TreeNode node55 = new TreeNode(55);

			rootNode.left = node20;
			rootNode.right = node60;

			node20.left = node10;
			node20.right = node30;

			node60.left = node50;
			node60.right = node70;

			node10.right = node5;
			node5.right = node45;

			node50.right = node55;
			return rootNode;
		}
	}

