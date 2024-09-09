import java.util.*;
public class Tree_Traversal{
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data= data;
            this.left=this.right=null;
        }
    }
    static TreeNode root;
    public Tree_Traversal() {
        this.root = null;
    }
    public TreeNode insert(int data, TreeNode root) {
        if(root==null) {
            root = new TreeNode(data);
            return root;
        }
        if(root.data>data) {
            root.left = insert(data,root.left);
        }
        else {
            root.right = insert(data,root.right);
        }
        return root;
    }
    public void printBFS() {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if(tempNode.left!= null) {
                queue.add(tempNode.left);
            }
            if(tempNode.right!= null) {
                queue.add(tempNode.right);
            }
        }
    }
    public void printDFS(TreeNode root) {
        if(root==null) {
            return;
        }
        System.out.print(root.data+" ");
        printDFS(root.left);
        printDFS(root.right);
    }
    public void insertIntoTree(int dataToBeInserted) {
        root = insert(dataToBeInserted,root);
    }
    public void DFS() {
        printDFS(root);
    }
    public void BFS() {
        printBFS();
    }
    public static void main(String[] args) {
        Tree_Traversal bst = new Tree_Traversal();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        System.out.println("Enter the numbers : ");
        for(int i=0;i<n;i++) {
            int data = sc.nextInt();
            bst.insertIntoTree(data);
        }
        System.out.println("BFS : ");
        bst.BFS();
        System.out.println("DFS : ");
        bst.DFS();
    }
}