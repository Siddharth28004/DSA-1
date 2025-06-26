package BinaryTrees;
import java.util.*;
//imported packages to get Linked List and Queues which we shall use
// MAIN CODE STARTS FROM LINE 42

public class LevelOrderTraversal {

    public class BinaryTreePreorder {
        public static class Node{// created a node class first to define the node
            int data;
            BinaryTrees.BinaryTreePreorder.Node left;
            BinaryTrees.BinaryTreePreorder.Node right;
            Node(int data){
                this.data=data;
                right=null;
                left=null;
            }
        }

        public static class BinaryTree{
            static int idx=-1; //made as -1 so as to traverse the whole length of the preorder array.
            public static BinaryTrees.BinaryTreePreorder.Node BuildBinaryTree(int preorderarray[]){
                idx++; // so that we immdly land at 0th index
                if(preorderarray[idx]==-1){
                    return null;
                    //this was done so that if we have -1 then there will be neither left nor right node
                }
                BinaryTrees.BinaryTreePreorder.Node newNode= new BinaryTrees.BinaryTreePreorder.Node(preorderarray[idx]);
                newNode.left=BuildBinaryTree(preorderarray);
                newNode.right=BuildBinaryTree(preorderarray);
            /* these two statements have made it a recursive function where we build the
             left and right subtree of the tree until and unless we run into -1,
             in which case the recursion switches over to the building the other node.
             */
                return newNode;
                //this returns the root node and if everything is perfect it should return 1.
            }
        }

    }

    public static void LevelOrder(BinaryTreePreorder.Node root){
        Queue<BinaryTreePreorder.Node> q= new LinkedList<>();// we have created queue as linked list because we cannot create for queue
        q.add(root); //added the root and
        q.add(null);// then added the null to get something like [1,null] in queue
        while(!q.isEmpty()){ // traversing till our queue is not empty
            BinaryTreePreorder.Node currnode=q.remove(); //removed the first element as fifo order
            if(currnode==null){   // checked if the element being removed is null
                System.out.println();  // because if we just removed a null, it is an indicator to print a new line
                if(q.isEmpty()){  //after removal of our null, if the queue becomes cpmpletely empty, we have reached the end
                    break;
                }
                else{ // else we will add the null back
                    q.add(null);
                }
            }
            else{ // this is if our current node is not null
                System.out.println(currnode.data+' '); // so in that case we are printing the data of node, e.g-1
                if(currnode.left!=null){ //now check if the left child is null or not
                    q.add(currnode.left); //if it is not null, add it to queue
                }
                if(currnode.right!=null){ //check and add same for right child
                    q.add(currnode.right);
                }



            }
        }

    }

        public static void main(String[] args) {
            int preorderarray[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTrees.BinaryTreePreorder.BinaryTree tree= new BinaryTrees.BinaryTreePreorder.BinaryTree(); //creating new object of the class
            BinaryTrees.BinaryTreePreorder.Node root=tree.BuildBinaryTree(preorderarray);
            LevelOrder(root);




        }




}
