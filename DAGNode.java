import java.util.ArrayList;

public class DAGNode {
        int data;
        ArrayList<DAGNode> p, c;

        DAGNode(int value) {
            data = value;
            p = c = new ArrayList<DAGNode>();   //parent and child nodes
        }

    }