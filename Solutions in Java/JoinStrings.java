import java.util.*;
import java.io.*;

public class JoinStrings{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int stringNumber = io.getInt();
        
        //Accounting for edge case where there is only one word
        if(stringNumber==1){
            System.out.print(io.getWord());
        }
        
        else{
            //ArrayList of Strings to collect input Strings
            ArrayList <String> stringArr = new ArrayList<String>();
            for(int i=0; i<stringNumber; i++){
                stringArr.add(io.getWord());
            }

            //Creating an Array containing ArrayLists for each number index
            ArrayList[] listArr = new ArrayList[stringNumber];
            for(int k=0; k<stringNumber; k++){
                listArr[k] = new ArrayList<Integer>();
            }

            //For each index of the Array, a ArrayList exists to store
            //the index of the strings that are behind that particular index
            int latestNum = 0;
            for(int j=0; j<stringNumber-1; j++){
                int firstNum = io.getInt()-1;
                int secondNum = io.getInt()-1;
                //Insertion done to back of ArrayList so it will be O(1)
                listArr[firstNum].add(secondNum);
                latestNum = firstNum;
            }
            
            //Create an ordered array and add in the first string
            ArrayList <String> orderedArr = new ArrayList<String>();
            orderedArr.add(stringArr.get(latestNum));
            
            //Recursively order the Array in the right order
            ListRecursion(listArr, latestNum, stringArr, orderedArr);

            //Use a for loop to print out the String in order
            for(int l=0;l<orderedArr.size();l++){
                io.print(orderedArr.get(l));
            }

            io.close();
        }
    }

    //Method to recursively order the strings based on ordered index in the Array of ArrayLists
    public static void ListRecursion(ArrayList[] arr, int index, ArrayList stringArr, ArrayList orderedArr){
        for(int i=0; i<arr[index].size(); i++){
            int num = (Integer)arr[index].get(i);
            //string gets added to array in correct sequence
            orderedArr.add(stringArr.get(num));
            //calls next index in the ArrayList
            ListRecursion(arr, num, stringArr,orderedArr);
        }
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
