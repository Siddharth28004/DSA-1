package BinarySearchTree;
/*Following concepts are in this code file:-
1)Building a tree
2) Searching in a tree
3) Deleting a Node
 */
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

    // CONCEPT NUMBER 1: BUILDING A TREE
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


    //CONCEPT NUMBER 2: SEARCHING IN THE TREE:-
    public static boolean search(Node root, int key){
        if (root==null){
            return false; //if the root is null search no further revert to the lastn recursion and eliminates border case if empty.
        }
        //going to left subtree
        if(key<root.data){
             return search(root.left,key);
        }

        //going to right subtree
        if(key>root.data){
             return search(root.right,key);
        }
        //checking if that is exactly found
        if(root.data==key){
            return true;
        }
        // if none of these conditions apply mtlb it is not found at all, return as false
        return false;
    }


    //CONCEPT NUMBER 3: DELETING A NODE:-

    public static Node delete(Node root, int key){
        if(root==null){
            return null;
        }
        if(key>root.data){
            root.left=delete(root.left,key);
        }
        else if(key<root.data){
            root.right=delete(root.right,key);

        }
        else{ //when root.data=key
            //case 1: when both child are null
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2: when one child is null
            if(root.right==null){
                return root.left;
            }
            else if(root.left==null){
                return root.right;
            }

            //case 3: when both children are present
            Node successor= Inordersuccessor(root.right);
            root.data=successor.data;
            root.right= delete(root.right,successor.data);


        }
        return root;

    }
    public static Node Inordersuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
        System.out.println(search(root,6));
        delete(root,4);
        inOrderTraverse(root);

    }

}
