import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonAncestor3 {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     

    boolean terminate = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        List<TreeNode> traceA = new ArrayList<TreeNode>();
        List<TreeNode> traceB = new ArrayList<TreeNode>();
        find(root, A, traceA);
        //∫‹÷ÿ“™
        terminate = false;
        find(root, B, traceB);
        
        if(traceB.size() == 0 || traceA.size() == 0) {
            return null;
        }
        Set<TreeNode> bSet = new HashSet<TreeNode>();
        bSet.addAll(traceB);
        for(int i = traceA.size() - 1; i >= 0; i--) {
            TreeNode ele = traceA.get(i);
            if(bSet.contains(ele)) {
                return ele;
            }
        }
        return null;
    }
    
    public void find(TreeNode temp, TreeNode node, List<TreeNode> trace) {
        if(terminate) {
            return;
        }
        trace.add(temp);
        if(node == temp) {
            terminate = true;
            return;
        }
        find(temp.left, node, trace);
        find(temp.right, node, trace);

        if(trace.size() > 0) {
            trace.remove(trace.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode A = root;
        TreeNode B = root;
        CommonAncestor3 obj = new CommonAncestor3();
        System.out.print(obj.lowestCommonAncestor3(root, A, B).val);
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}