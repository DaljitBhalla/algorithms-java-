/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

/**
 *
 * @author Daljit Bhalla
 */
public class Morrispreoder {
   
   static void morrispreorder(Node root){
       //runs if write permissions for the class Node object 
       Node pre;
       while(root!=null)
        {
            //System.out.println(" "+root.key+" ");
           
           
            if(root.left!=null)
            {
                pre =root;
              
           //now find the rightmost node of the left subtree
               root=root.left;
                while(root.right!=null && root.right!=pre)
                    root=root.right;
            if(root.right==null)
            {
              
               root.bthread=true;
                root.right=pre;
              
                root=pre.left;  
             System.out.print(" " +pre.key+ "  ");
            }
            else if(root.right==pre)
            {
               
             root.right= null;
            root.bthread=false;
             root=pre.right; }
            }
            else {
                System.out.print(" "+ root.key+"  ");
            
                root=root.right;
            }
            
           }
    }
  
   
    public static void main(String args[])
    {
        
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
       root.right.left=new Node(6);
       root.right.right=new Node(13);
        morrispreorder(root);
        
    }

static class Node{
    
    int key;
    Node left, right;
    boolean bthread;
    public Node(){}
    public Node(int x)
    {
        this.key=x;
        left=right=null;
        bthread=false;
    }
      
    
}

    
}
