package 数据结构.第五章;

public class BiTreeNode {
    public Object data;
    public BiTreeNode lchild, rchild;
    public BiTreeNode() {
        this(null);
    }
    public BiTreeNode(Object data) {
        this(data, null, null);
    }
    public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

}
