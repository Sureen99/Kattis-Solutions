import java.util.*;
import java.io.*;

public class Teque{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int operationNumber = io.getInt();

        //Two Teque arrays are used to ensure that the push_middle operation will be O(1)
        //as push_middle will essentially be either insertion at back of frontTeque or front of backTeque
        TequeArr frontTeque = new TequeArr(operationNumber*2);
        TequeArr backTeque = new TequeArr(operationNumber*2);
        //Size initialisation is large in order to avoid resizing the arrays later
        


        //loop to collect input operations then resolve operations
        for(int i=0; i<operationNumber;i++){
            String operationName = io.getWord();
            int inputNumber = io.getInt();
            
            if(operationName.equals("push_back")){
                //inserting to back of back array
                backTeque.offerBack(inputNumber);

                //if back array too big, balance front and back arrays
                //this is done so insert middle operation will be accurate
                while (backTeque.getCapacity() > frontTeque.getCapacity()+1){
                    frontTeque.offerBack(backTeque.pollFront());
                }
            }

            else if(operationName.equals("push_front")){
                //inserting to front of front array
                frontTeque.offerFront(inputNumber);

                //if front array too big, balance front and back arrays
                //this is done so insert middle operation will be accurate
                while (frontTeque.getCapacity() > backTeque.getCapacity()+1){
                    backTeque.offerFront(frontTeque.pollBack());
                }
            }

            else if(operationName.equals("push_middle")){
                //if front array bigger than or equal to back array, add to front of back array
                if (frontTeque.getCapacity()>=backTeque.getCapacity()){
                    
                    //inserting to front of back array
                    backTeque.offerFront(inputNumber);

                    //no need for balancing as front and back arrays roughly equal
                }


                //if back array bigger than front array make front array 1 bigger or equal to back array
                //which will be same as previous case and then add to front of back array
                //this fixes cases where back is one bigger than front as simply adding to front of back array
                //in those cases won't be actual insert middle
                
                else{
                    //shifting element from front of back array to back of front array
                    frontTeque.offerBack(backTeque.pollFront());

                    //inserting to front of back array
                    backTeque.offerFront(inputNumber);
                        
                    //no need for balancing as front and back arrays roughly equal
                }
            }

            else if(operationName.equals("get")){
                if(inputNumber+1>frontTeque.getCapacity()){
                    //if index + 1 is bigger than number of elements in front array
                    //get element from back array
                    io.println(backTeque.getValueAtIndex(inputNumber-frontTeque.getCapacity()));
                }
                else{
                    //if not get element from front array
                    io.println(frontTeque.getValueAtIndex(inputNumber));
                }
            }
        }
        io.close();
    }
}

class TequeArr{
    public int front, back;
    public int capacity = 0;
    public int[] arr;
    //Teque implemented using Array as it is the only way to achieve O(1) get operation 
    //while allowing O(1) push_front and push_back operations

    public TequeArr(int initSize){
        arr = new int[initSize];
        front = initSize/2;
        back = (initSize/2)+1;
        //front and back indexes initialised in middle of array to allow
        //O(1) front insertion and middle insertion
    }

    public void offerFront(int value){
        arr[front] = value;
        front-=1;
        capacity+=1;
        //adds a value to front of array
    }

    public void offerBack(int value){
        arr[back] = value;
        back+=1;
        capacity+=1;
        //adds a value to back of array
    }

    public int pollFront(){
        int temp = arr[front+1];
        arr[front+1]=0;
        front+=1;
        capacity-=1;
        return temp;
        //removes and returns value from front of array
    }

    public int pollBack(){
        int temp = arr[back-1];
        arr[back-1]=0;
        back-=1;
        capacity-=1;
        return temp;
        //removes and returns value from back of array
    }

    public int getCapacity(){
        return capacity;
        //returns number of elements in array
    }

    public int getValueAtIndex(int value){
        return arr[front + value + 1];
        //returns element at index in array
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
