package 数据结构.第五章;

public class DebugBiTree {
    public BiTree createBiTree() {
        BiTreeNode d = new BiTreeNode('D');
        BiTreeNode g = new BiTreeNode('G');
        BiTreeNode h = new BiTreeNode('H');
        BiTreeNode e = new BiTreeNode('E', g, null);
        BiTreeNode b = new BiTreeNode('B', d, e);
        BiTreeNode f = new BiTreeNode('F', null, h);
        BiTreeNode c = new BiTreeNode('C', f, null);
        BiTreeNode a = new BiTreeNode('A', b, c);
        return new BiTree(a);
    }
    public static void main(String[] args) {
        DebugBiTree debugBiTree = new DebugBiTree();
        BiTree biTree = debugBiTree.createBiTree();
        BiTreeNode root = biTree.root;

//        System.out.print("先序遍历的序列为:");
//        biTree.preRootTraverse(root);
//        System.out.print("\n");
//
//        System.out.print("中序遍历的序列为:");
//        biTree.inRootTraverse(root);
//        System.out.print("\n");
//
//        System.out.print("后序遍历的序列为:");
//        biTree.postRootTraverse(root);
//        System.out.print("\n");

//        System.out.print("二叉树的最大深度为:" + biTree.Deep(root) + "\n");
//
//
//        System.out.print("二叉树中叶子结点个数:" + biTree.cnt_leaves(root) + "\n");
//
        System.out.print("二叉树的层次遍历为:");
        biTree.leaveTraverse(biTree.root);
        System.out.print("\n");
    }
}
