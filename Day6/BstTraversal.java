package Day6;

public class BstTraversal {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int v){
            this.value=v;
            this.right= this.left=null;
        }

        public static void Inorder(Node root){
            if(root !=null){
                Inorder(root.left);
                System.out.print(root.value+" ");
                Inorder(root.right);
            }
        }

        public static void preorder(Node root){
            if(root !=null){
                
                System.out.print(root.value+" ");
                Inorder(root.left);
                Inorder(root.right);
            }
        }

        public static void postorder(Node root){
            if(root !=null){   
                Inorder(root.left);
                Inorder(root.right);
                System.out.print(root.value+" ");
            }
        }
        

        public static void main(String args[]){
            Node root = new Node(1);
            root.left= new Node(2);
            root.right = new Node(3);
            root.left.left= new Node(4);
            root.left.right = new Node(5);

            System.out.println("Inorder Traversal");
            Inorder(root);

            System.out.println("prerder Traversal");
            preorder(root);

            System.out.println("postorder Traversal");
            postorder(root);

        }
    }
}
