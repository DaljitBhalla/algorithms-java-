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
public class Morristraversal {
   

    static void reverseNode(Node l, Node r)
    {
        if(l==r)
            return;
        Node x = l , y = l.right , z;
        while(true)
        {
            z=y.right;
            y.right=x;
            x=y;
            y=z;
            if(x==r)
                break;
        }
        
    }
    static void printReverse(Node l ,Node r)
    {
        //utility function to print the node of tree in reverse order..
        // from l node to r node print the reverse ... 
        reverseNode(l,r);
        Node nd= r;
        while(true)
        {
            System.out.print(" "+ nd.key+" ");
            if(nd==l)
                break;
            nd= nd.right;
        }
        reverseNode(r,l);
        
    }
     static void morrisPostOrder(Node root)
     {
         Node dump= new Node(0);
         dump.left= root;
         Node pre= null;
         root= dump;
          while(root!=null)
          {
              
              if(root.left==null)
                   root= root.right;
              else
              {
                  pre = root.left;
                  while( pre.right!=null && pre . right !=root)
                       pre = pre .right;
                  if(pre.right==null)
                  {
                      pre.right=root;
                      root=root.left;
                  }
                  else
                  {
                  printReverse(root.left,pre);
                  pre.right=null;
                  root=root.right;
                     }
              }
               
          }
     }
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
        Node root;
       root = new Node(1);
        root.left = new Node(2);
       root.right = new Node(3);
        root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
      root.right.right = new Node(7);
        root.left.left.left = new Node(8);
      root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
      root.left.right.right = new Node(11);
  
       morrispreorder(root);
       System.out.println(" \n Now the morris post order traversal .. ");
       morrisPostOrder(root);
        
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
