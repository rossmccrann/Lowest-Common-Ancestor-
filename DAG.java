import java.util.ArrayList;

public class DAG {

DAGNode root;
		
public static DAGNode dagFindLCA(DAGNode root, DAGNode left_lca, DAGNode right_lca){
        if (root == null) return null;
        if (root == left_lca ||root == right_lca) return root;
        if(left_lca.data==right_lca.data)        return left_lca;

        ArrayList <DAGNode> lca = new ArrayList<DAGNode>();
        if( left_lca.p.size()==0 || right_lca.p.size() == 0) return null;
        for(int i=0; i < left_lca.p.size();i++){
            for(int j=0;j < right_lca.p.size();j++){
                if(left_lca.p.get(i).data == right_lca.p.get(j).data){
                    lca.add(left_lca.p.get(i));
                }
            }

        }

        if(lca.size() == 0){
            if (left_lca.data > right_lca.data) lca.add(dagFindLCA(root,left_lca.p.get(0), right_lca));
            else lca.add(dagFindLCA(root,left_lca,right_lca.p.get(0)));
        }


            DAGNode maxTemp = lca.get(0);

            for (int i = 0; i < lca.size(); i++) {
                if (lca.get(i).data > maxTemp.data) maxTemp = lca.get(i);
            }
            return maxTemp;

    }
	
}
