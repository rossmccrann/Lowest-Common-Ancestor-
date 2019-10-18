import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DAGTest {
	

    //uni-nodal tree
    @Test
    public void tUniNodeTree(){
        DAGNode root = new DAGNode(1);
        DAGNode left = new DAGNode(1);
        DAGNode right = new DAGNode(1);
        assertEquals(1, DAG.dagFindLCA(root,left,right).data, "uni nodal tree");
    }

    @Test
    public void tNullRootDAGLG(){
        DAGNode testNode = null;
        DAGNode left = new DAGNode(8);
        DAGNode right = new DAGNode(7);
        assertNull(DAG.dagFindLCA(testNode,left,right));

    }
    
    @Test
    public void tNullRootDAGRG(){
        DAGNode testNode = new DAGNode(10);
        DAGNode left = new DAGNode(8);
        DAGNode right = new DAGNode(7);
        DAG.dagFindLCA(testNode, right, left);
        assertNull(DAG.dagFindLCA(testNode,left,right));

    }
    
    
    
    //null node
    @Test
    public void tNullNodeDAG(){
        DAGNode tNode = null;
        assertNull(tNode);

    }
    @Test
    public void createDAG() {
        
        DAGNode rootDAG = new DAGNode(1);
        DAGNode node2 = new DAGNode(2);
        DAGNode node3 = new DAGNode(3);
        DAGNode node4 = new DAGNode(4);
        DAGNode node5 = new DAGNode(5);
        DAGNode node6 = new DAGNode(6);

        //ADD Nodes
        
        rootDAG.c.add(node2); rootDAG.c.add(node3);rootDAG.c.add(node4);rootDAG.c.add(node5);rootDAG.c.add(node6);node2.c.add(node4);
        node2.p.add(rootDAG);node3.c.add(node4);node3.c.add(node5);node3.p.add(rootDAG);node4.c.add(node5); node4.p.add(node2);
        node4.p.add(node3);node4.p.add(rootDAG);node5.p.add(node3);node5.p.add(node4);node5.p.add(rootDAG);node6.p.add(node4);

        //Test standard
        assertEquals(1, DAG.dagFindLCA(rootDAG, rootDAG, node4).data);
        
        /* 
        test lnode & rnode
        */

        assertEquals(4, DAG.dagFindLCA(rootDAG, node4, node6).data);

        assertEquals(6, DAG.dagFindLCA(rootDAG, node6, node6).data);
        
        
        /*
        test null inputs
        */


        assertNull(DAG.dagFindLCA(null,null,null),"null expected");
        

        //node not in tree
        assertNull( DAG.dagFindLCA(rootDAG, new DAGNode(15),new DAGNode(10)));



    }

}
