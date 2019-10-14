import org.junit.Test;

import static org.junit.Assert.*;

public class Binary_Tree_Test {

    @Test
    public void t1() {
    	Binary_Tree tree = new Binary_Tree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        /*

        SEARCH TREE VISUALISATION

        	  1
			/   \
		   2     3
		  / \   / \
		 4   5 6   7

         */

        assertEquals( 2,tree.findLCA(4, 5));
        assertEquals( 2,tree.findLCA(5, 4));
        assertEquals( 1,tree.findLCA(4, 6));
        assertEquals( 1,tree.findLCA(2, 3));
        assertEquals( 3,tree.findLCA(6, 7));
    }

    @Test
    public void t2() {
		Binary_Tree tree = new Binary_Tree(); 
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left  = new Node(4);
        tree.root.right.right  = new Node(5);
        tree.root.right.left.left   = new Node(6);
        tree.root.right.left .right  = new Node(7);
        tree.root.right.right.left  = new Node(8);
        tree.root.right.right.right  = new Node(9);

        /*

        SEARCH TREE VISUALISATION

        	 1
		   /   \
		  2     3
		      /   \
		     4      5
			/ \    / \
		   6   7  8   9

         */

        assertEquals( 3,tree.findLCA(4, 5));
        assertEquals( 4,tree.findLCA(4, 6));
        assertEquals( 1,tree.findLCA(2, 3));
        assertEquals( 4,tree.findLCA(6, 7));
        assertEquals( 1,tree.findLCA(6, 2));
    }

    @Test
    public void t3() {
		Binary_Tree tree = new Binary_Tree(); 
        tree.root = new Node(1); tree.root.right = new Node(2);
        tree.root.left = new Node(3); tree.root.left.left  = new Node(4);
        tree.root.left.right  = new Node(5); tree.root.left.left.left   = new Node(6);
        tree.root.left.left .right  = new Node(7); tree.root.left.right.left  = new Node(8);
        tree.root.left.right.right  = new Node(9);

        /*

        SEARCH TREE VISUALISATION

        	       1
		         /   \
		        3     2
		      /   \
		     4      5
			/ \    / \
		   6   7  8   9

         */

        assertEquals( 3,tree.findLCA(4, 5));
        assertEquals( 4,tree.findLCA(4, 6));
        assertEquals( 1,tree.findLCA(2, 3));
        assertEquals( 4,tree.findLCA(6, 7));
        assertEquals( 1,tree.findLCA(6, 2));
    }


    @Test
    public void testOneNode() {
		Binary_Tree tree = new Binary_Tree(); 
        tree.root = new Node(1); tree.root.left = new Node(2);
        assertEquals( 1,tree.findLCA(1, 2));
    }
    }