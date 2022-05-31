import java.util.*;
import java.io.*;

public class Conformity{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int froshNumber = io.getInt();

        //Initialising HashMap to accept input keys in the form of ArrayLists and values in Intger
        HashMap<ArrayList,Integer> popularityMap = new HashMap<ArrayList,Integer>();

        //Loop to collect input keys
        for(int i=0; i<froshNumber;i++){
            ArrayList<Integer> courseCombi = new ArrayList<Integer>();
            for(int j=0; j<5; j++){
                courseCombi.add(io.getInt());
            }
            
            //Input lists need to be sorted to ensure that same combinations are ordered in the same way
            Collections.sort(courseCombi);

            //if the hashmap already contains this particular array list just increase value by 1
            if(popularityMap.containsKey(courseCombi)){
                int oldValue = popularityMap.get(courseCombi);
                popularityMap.put(courseCombi,oldValue+1); 
            }

            //if not create an entry and set value to 1
            else{
                popularityMap.put(courseCombi,1);
            }
        }
        //Convert the collection of values to arraylist form
        Collection<Integer> temp = popularityMap.values();
        ArrayList<Integer> numStudents = new ArrayList<Integer>(temp);

        //Reverse sort it to find biggest number
        Collections.sort(numStudents);
        Collections.reverse(numStudents);
        int maxNumber = numStudents.get(0);

        /*
        Find out how many times that number appears and multiply to get 
        total number of students with same combi
        */
        int totalNumber = maxNumber * Collections.frequency(numStudents, maxNumber);

        io.println(totalNumber);
        io.close();
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

