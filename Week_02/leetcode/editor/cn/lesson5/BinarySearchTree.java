package leetcode.editor.cn.lesson5;

public class BinarySearchTree {

    class Node {
        int data;
        int count;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            this.count = 1;
            right = null;
            left = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", count=" + count +
                    '}';
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(int data) {
        root = _insert(root, data);
    }

    private Node _insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data == root.data) root.count++;
        if (data < root.data) root.left = _insert(root.left, data);
        if (data > root.data) root.right = _insert(root.right, data);
        return root;
    }

    public void inorder(Node root) {
        helper(root);
        System.out.println();
    }

    private void helper(Node root) {
        if (root != null) {
            if (root.left != null) helper(root.left);
            System.out.print(root.data + " ");
            if (root.right != null) helper(root.right);
        }
    }

    public Node search(int data) {
        return _search(root, data);
    }

    private Node _search(Node node, int data) {
        return node == null || node.data == data
                ? node
                : _search(data < node.data ? node.left : node.right, data);
    }

    public void delete(int data) {
        root = _delete(root, data);
    }

    private Node _delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = _delete(node.left, data);
        } else if (data > node.data) {
            node.right = _delete(node.right, data);
        } else {
            if (node.count == 1) {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;

                Node minNode = _minRightNode(node.right);
                node.data = minNode.data;
                node.right = _delete(node.right, minNode.data);
            } else {
                node.count--;
            }
        }
        return node;
    }

    private Node _minRightNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(90);
        binarySearchTree.insert(90);
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(88);
        binarySearchTree.insert(66);
        binarySearchTree.insert(77);
        binarySearchTree.inorder(binarySearchTree.getRoot());
        System.out.println(binarySearchTree.search(90));
        binarySearchTree.delete(90);
        binarySearchTree.inorder(binarySearchTree.getRoot());
        System.out.println(binarySearchTree.search(90));
        binarySearchTree.delete(66);
        binarySearchTree.inorder(binarySearchTree.getRoot());
        System.out.println(binarySearchTree.search(66));
    }

}
