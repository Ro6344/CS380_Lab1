class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
		   //base casse 
         if(root == null){
            return; 
         }
         //current node 
         System.out.println(root.value + " ");
         
         //recursively travel left subtree
         preOrderTraversal(root.left);
         
         //recursively travel right subtree
         preOrderTraversal(root.right);		   
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
	      //base case 
         if(root == null){
            return; 
         }
         //recursively travel left subtree
         inOrderTraversal(root.left);
         
         //current node 
         System.out.println(root.value + " ");
         
         //recursively travel right subtree
         inOrderTraversal(root.right);
         
	   }
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
	   public void postOrderTraversal(Node root){
         //base case
         if (root == null){
            return;
         }
         //recursively travel left subtree 
         postOrderTraversal(root.left);
         
         //recursively travel right subtree 
         postOrderTraversal(root.right);
         
         //current node 
         System.out.println(root.value + " "); 
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key){
		   //base case 
         if (root == null){
            return false; 
         }
         //if the current node's value matches the key return true
         if (root.value == key){
            return true; 
         }
         //recursively search in the left and right subtree
         return find(root.left, key) || find(root.right, key);
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
         //implement in here
	      
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
         //implement in here
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
