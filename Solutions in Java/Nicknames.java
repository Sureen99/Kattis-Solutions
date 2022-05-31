import java.util.*;
import java.io.*;

public class Nicknames{
    public static Node root;
    //reference pointing to the root node of the tree

    public static void updateHeight(Node n){
        //function that updates the height of a node in the tree

        if(n.left==null && n.right==null){
            //if both left and right children are null, height
            //is just (-1)+1 = 0
            n.height = 0;
        }
        //if one is null but other isn't you just take height
        //of the filled one and plus 1
        else if(n.left==null && n.right!=null){
            n.height = n.right.height + 1;
        }
        else if(n.left!=null && n.right==null){
            n.height = n.left.height + 1;
        }
        //same as lecture implementation
        else{
            n.height = Math.max(n.left.height,n.right.height)+1;
        }
    }


    //function to check if a node is balanced on both sides
    //returns the value of the balancing factor
    public static int checkBalance(Node n){
        int heightLeft = -1;
        int heightRight = -1;
        if(n.left!=null){
            heightLeft = n.left.height;
        }
        if(n.right!=null){
            heightRight = n.right.height;
        }
        return heightLeft-heightRight;
    }

    //rotates node n and the right child of node n to the left
    //making the right child of node n the new parent of n
    public static void rotateLeft(Node n){
        Node w = n.right;
        //updates root if root is changed
        if(n.parent==null){
            root = w;
        }
        //updates the parent node
        else if(n.parent.left==n){
            n.parent.left=w;
        }
        else{
            n.parent.right=w;
        }
        //rotation occurs
        w.parent = n.parent;
        n.parent = w;
        n.right = w.left;
        if(w.left!=null){
            w.left.parent = n;
        }
        w.left = n;
        //updates details of the three nodes involved
        updateHeight(n);
        updateHeight(w);
        if(w.parent!=null){
            updateHeight(w.parent);
        }
    }

    //rotates node n and the left child of node n to the right
    //making the left child of node n the new parent of n
    public static void rotateRight(Node n){
        Node w = n.left;
        //updates root if root is changed
        if(n.parent==null){
            root = w;
        }
        //updates the parent node
        else if(n.parent.left==n){
            n.parent.left = w;
        }
        else{
            n.parent.right = w;
        }
        //rotation occurs
        w.parent = n.parent;
        n.parent = w;
        n.left = w.right;
        if(w.right!=null){
            w.right.parent = n;
        }
        w.right = n;
        //updates details of the three nodes involved
        updateHeight(n);
        updateHeight(w);
        if(w.parent!=null){
            updateHeight(w.parent);
        }
    }

    //function to insert a new node in the tree
    public static void insertNode(String i, Node n){

        //if i is bigger than n.key check right
        if(i.compareTo(n.key)>0){
            //if n.right is null, insert to right
            if (n.right==null){
                n.right = new Node(n,null,null,i,0);
                n.right.parent = n;
                updateHeight(n);
                Node checking = n;
                //loop recursively checks for balance up the tree
                Boolean flag = true;
                while(flag){
                    if (checkBalance(checking)<=1 && checkBalance(checking)>=-1){
                        if(checking.parent==null){
                            flag = false;
                        }
                        checking = checking.parent;
                    }
                    else if(checkBalance(checking)>1){
                        rotateRight(checking);
                        if(checking.parent.parent==null){
                            flag = false;
                        }
                        checking = checking.parent.parent;
                        
                    }
                    else{
                        rotateLeft(checking);
                        if(checking.parent.parent==null){
                            flag = false;
                        }
                        checking = checking.parent.parent;
                    }
                }
            }
            //if n.right is occupied call the function again on n.right
            else{
                insertNode(i, n.right);
            }
        }

        //else check left
        else{
            //if n.left is null, insert to left
            if(n.left==null){
                n.left = new Node(n,null,null,i,0);
                n.left.parent = n;
                updateHeight(n);
                Node checking = n;
                //loop checks balance up the tree recursively
                Boolean flag = true;
                while(flag){
                    if (checkBalance(checking)<=1 && checkBalance(checking)>=-1){
                        if(checking.parent==null){
                            flag=false;
                        }
                        checking = checking.parent;
                    }
                    else if(checkBalance(checking)>1){
                        rotateRight(checking);
                        if(checking.parent.parent==null){
                            flag = false;
                        }
                        checking = checking.parent.parent;
                    }
                    else{
                        rotateLeft(checking);
                        if(checking.parent.parent==null){
                            flag = false;
                        }
                        checking = checking.parent.parent;
                    }
                }
            }
            //if n.left is occupied call the function again on n.left
            else{
                insertNode(i, n.left);
            }
        }
    }
    
    

    //function to recursively count the number of matches in the tree for a nickname
    public static int query(Node n, String nickname){
        //if nickname matches need to check both sides if available
        //else check the available sides
        if (n.key.startsWith(nickname)){
            if(n.left!=null && n.right!=null){
                return 1 + query(n.left,nickname) + query(n.right, nickname);
            }
            else if(n.left==null && n.right!=null){
                return 1 + query(n.right,nickname);
            }
            else if(n.right==null && n.left!=null){
                return 1 + query(n.left,nickname);
            }
            else{
                return 1;
            }
        }
        //if not you can compare with key to see if name is bigger or smaller than nickname
        //if name is bigger, then names that start with nickname can't exist in right of tree
        //so check left side
        else if(n.key.compareTo(nickname)>0){
            if(n.left!=null){
                return query(n.left, nickname);
            }
            else{
                return 0;
            }
        }
        //if name is smaller, then names that start with nickname can't exist in left of tree
        //so check right side
        else {
            if(n.right!=null){
                return query(n.right,nickname);
            }
            else{
                return 0;
            }
        }
    }

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int inputName = io.getInt();
        String name = io.getWord();

        //initialise the first word as the root of the tree
        root = new Node(null,null,null,name,0);
        
        //for loop to insert all the words into the tree
        for (int i=0; i<inputName-1;i++){
            name = io.getWord();
            insertNode(name, root);
        }
        //Hashmap to store values of previously queried nicknames so for
        //future repeated queries, it will be O(1)
        HashMap<String, Long> map = new HashMap<String, Long>();
        int inputNickname = io.getInt();
        
        //for loop to query all the nicknames and print the count
        for (int j=0; j<inputNickname; j++){
            String nickname = io.getWord();
            long count = 0;
            //if nickname is repeated, just get the count value previously queried
            if(map.containsKey(nickname)){
                count = map.get(nickname);
            }
            //if not need to query in AVL tree and add it to the hashmap
            else{
                count = query(root,nickname);
                map.put(nickname, count);
            }
            io.println(count);
        }
        
        io.close();
    }
}

//Node class with attributes parent, left, right, key, height
class Node{
    public Node parent;
    public Node left;
    public Node right;
    public String key;
    public int height;

    public Node(Node parent, Node left, Node right, String key, int height){
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.key = key;
        this.height = height;
    }

}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
