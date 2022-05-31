import java.util.*;
import java.io.*;

public class SortOfSorting{
    
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int inputInt = io.getInt();
        
        //Keeps taking input as long as intInput is not 0
        while (inputInt!=0){
            List <String> stringList = new ArrayList<String>();
            
            //Collects all the input words into a list
            for(int i=0;i<inputInt;i++){
                stringList.add(io.getWord());
            }

            //Sorting List based on implemented comparator
            Collections.sort(stringList, new StringComparator());
            for(int j=0;j<inputInt;j++){
                io.println(stringList.get(j));
            }
            
            //Taking in next int input to check loop condition
            inputInt=io.getInt();
            
            //To make sure that last para won't end with a blank line
            if (inputInt!=0){
                io.println(" ");
            }
        }
        io.close();
    }
}

class StringComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        //Sorts based on first letter
        //If first letter same for both words then sort based on second letter
        //If still same words will remain in same positions
        if(s1.charAt(0) > s2.charAt(0)){
            return 1;
        }
        else if(s1.charAt(0) < s2.charAt(0)){
            return -1;
        }
        else{
            if(s1.charAt(1) > s2.charAt(1)){
                return 1;
            }
            else if (s1.charAt(1) < s2.charAt(1)){
                return -1;
            }
            else{
                return 0;
            }
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
