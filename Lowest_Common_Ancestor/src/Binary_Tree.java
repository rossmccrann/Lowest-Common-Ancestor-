
public class Binary_Tree {
	//Root of the Binary Tree 
    Node root; 
  
    Node findLCA(int n1, int n2) 
    { 
        return findLCA(root, n1, n2); 
    } 
    

    Node findLCA(Node node, int n1, int n2) 
    { 
        // Base case 
        if (node == null) 
            return null; 
  
        /*
         If either n1 or n2 matches with the root's key,  
         then return the root as an indicator that there is no Lowest Common Ancestor 
         */
        if (node.data == n1 || node.data == n2) 
            return node; 
  
        // Look for keys in left and right subtrees 
        Node left_lca = findLCA(node.left, n1, n2); 
        Node right_lca = findLCA(node.right, n1, n2); 
  
        /* 
         If left_lca and right_lca don't return NULL, then a key is present in both subtrees/
         This node is the Lowest Common Ancestor
         */
        if (left_lca!=null && right_lca!=null) 
            return node; 
  
        // check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
    } 
    

	public static void main(String[] args) {
		 Binary_Tree tree = new Binary_Tree(); 
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(6); 
	        tree.root.right.right = new Node(7); 
	  
	        Node lca = tree.findLCA(4, 5); 
	        
	        if (lca != null) 
	            System.out.println("LCA(4, 5) = " + lca.data); 
	        else
	            System.out.println("Keys are not present"); 
	  
	        lca = tree.findLCA(4, 10); 
	        
	        if (lca != null) 
	            System.out.println("LCA(4, 10) = " + lca.data); 
	        else
	            System.out.println("Keys are not present"); 
	}
	
}
