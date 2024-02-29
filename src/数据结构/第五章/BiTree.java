package 数据结构.第五章;

import java.util.LinkedList;
import java.util.Queue;

public class BiTree {
    BiTreeNode root; // 根节点
    public BiTree() {
        this.root = null;
    }
    public BiTree(BiTreeNode root) {
        this.root = root;
    }
    public void preRootTraverse(BiTreeNode T) { //先序遍历
        if (T != null) {
            System.out.print(T.data);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);
        }
    }
    public void inRootTraverse(BiTreeNode T) { //中序遍历
        if (T != null) {
            inRootTraverse(T.lchild);
            System.out.print(T.data);
            inRootTraverse(T.rchild);
        }
    }
    public void postRootTraverse(BiTreeNode T) { //后序遍历
        if (T != null) {
            postRootTraverse(T.lchild);
            postRootTraverse(T.rchild);
            System.out.print(T.data);
        }
    }
    public int Deep(BiTreeNode T) {
        if (T == null) {
            return 0;
        }
        return Math.max(Deep(T.lchild), Deep(T.rchild)) + 1; // 获得左右子树的最大深度并 + 1
    }
    public int cnt_leaves(BiTreeNode T) {
        int cnt = 0;
        Queue<BiTreeNode> q = new LinkedList<>(); //使用队列
        q.offer(T); // 根结点入队

        while (!q.isEmpty()) {
            BiTreeNode u = q.poll();
            if (u.lchild == null && u.rchild == null) { // 判断是否为叶子结点
                cnt++;
            }
            if (u.lchild != null) {
                q.offer(u.lchild);
            }
            if (u.rchild != null) {
                q.offer(u.rchild);
            }
        }
        return cnt;
    }

    public void leaveTraverse(BiTreeNode T) {
        Queue<BiTreeNode> q = new LinkedList<>();// 使用队列
        q.offer(T);// 根结点入队
        while (!q.isEmpty()) {
            BiTreeNode u = q.poll();
            System.out.print(u.data); //输出当前值
            if (u.lchild != null) {
                q.offer(u.lchild);
            }
            if (u.rchild != null) {
                q.offer(u.rchild);
            }
        }
    }
}
