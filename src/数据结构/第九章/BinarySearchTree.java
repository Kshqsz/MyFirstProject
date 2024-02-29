package 数据结构.第九章;

class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int value) {
        data = value;
        left = right = null;
    }
}

public class BinarySearchTree {
    BSTNode root;

    BinarySearchTree() {
        root = null;
    }

    // 二叉排序树的查找
    BSTNode search(BSTNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (root.data > key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // 二叉排序树的插入
    BSTNode insert(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 8);

        BSTNode result = tree.search(tree.root, 6);
        if (result != null) {
            System.out.println("查找到该元素: " + result.data);
        } else {
            System.out.println("该元素未被查找到");
        }
    }
}
