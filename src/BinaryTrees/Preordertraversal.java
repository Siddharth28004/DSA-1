package BinaryTrees;
// MAIN PART OF CODE IS FROM LINE 35!!!!!!!
public class Preordertraversal {


    public static class Node{// created a node class first to define the node
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }

    public static class BinaryTree{
        static int idx=-1; //made as -1 so as to traverse the whole length of the preorder array.
        public static Node BuildBinaryTree(int preorderarray[]){
            idx++; // so that we immdly land at 0th index
            if(preorderarray[idx]==-1){
                return null;
                //this was done so that if we have -1 then there will be neither left nor right node
            }

            Node newNode= new Node(preorderarray[idx]);
            newNode.left=BuildBinaryTree(preorderarray);
            newNode.right=BuildBinaryTree(preorderarray);
            return newNode;
            //this returns the root node and if everything is perfect it should return 1.
        }
    }


    //THIS IS THE MAIN PART OF THE CODE!!!!!!!!!!
    public static void preordertraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preordertraversal(root.left);
        preordertraversal(root.right);

    }

    public static void main(String[] args) {
        int preorderarray[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree= new BinaryTree(); //creating new object of the class

        Node root=tree.BuildBinaryTree(preorderarray);   //created a root object which points to this
        preordertraversal(root);


    }





}
