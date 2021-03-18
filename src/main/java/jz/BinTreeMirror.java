package jz;

import jz.struct.TreeNode;

public class BinTreeMirror {
    public static TreeNode Mirror(TreeNode pRoot){
        if(pRoot ==null)
            return null;
        TreeNode tLeft = pRoot.left;
        TreeNode tRight = pRoot.right;
        pRoot.left=tRight;
        pRoot.right=tLeft;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
