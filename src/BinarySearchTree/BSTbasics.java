package BinarySearchTree;

public class BSTbasics {

    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static Node insert(Node root, int key){
        //checking if the root is still null that is, we are starting the tree
        if(root==null) {
            root = new Node(key);
            return root; // since the root was null we created it

        }
        //building the Left Subtree
        if(key<root.data){
            root.left= insert(root.left,key);
            //it then goes on to recursively call it till all of the left subtree side is built
        }
        if(key>root.data){
            root.right=insert(root.right,key);
            // same as for left subtree
        }

        return root;


    }

    //Creating inorder traversal to check if the tree is correctly built or not
    public static void inOrderTraverse(Node root){
        //used a void type since we only need to internally arrange and get it
        if(root==null){
            return;
        }
        inOrderTraverse(root.left);
        System.out.print(root.data+" "); // IT IS VERY IMP TO USE "" and not '' which makes it a char type
        inOrderTraverse(root.right);
    }


    public static void main(String[] args) {
        int values[]={5,1,3,4,2,7};
        Node root=null; // optional to write as it is null by default
        for(int i=0;i<values.length;i++){
            //traversing the array to one by one use the values and place them in their respective places in tree
            root=insert(root,values[i]);
        }

        inOrderTraverse(root);
        System.out.println();

    }

}
