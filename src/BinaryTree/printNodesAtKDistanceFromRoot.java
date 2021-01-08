package BinaryTree;


public class printNodesAtKDistanceFromRoot {
	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	static void Trace(TreeNode p, int k) {
		if (p == null) {
			return;
		}
		if (k == 0) {
			System.out.println(p.data); 
		} else {
			Trace(p.left, k - 1);
			Trace(p.right, k - 1);
		}
	}

}