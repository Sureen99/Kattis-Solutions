import java.util.*;
import java.io.*;

public class AlmostUnionFind{
    
    //function to find which set an element belongs to 
    public static long findSet(long i, long[] l) {
        //where i is the element and l is the locationArr

        //If number at index i of the locationArr is same as the number, set found
        if (l[(int)i] == i){
            return i;
        }

        //If it is not the same, then set is not found and there is a need to do a
        //recursive call to find the set
        else{
            l[(int)i] = findSet(l[(int)i], l);
            return l[(int)i];
        }
    }
    
    //function to check if 2 elements belong in same set
    //returns true if they do, else returns false
    public static Boolean isSameSet(long i, long j, long[] l){
        //i and j are elements, l is locationArr
        return (findSet(i, l) == findSet(j, l));
    }
    
    
    //function to union 2 sets together
    public static void unionSet(long i, long j, long[] l, NumberSet[] a){
        //i and j are elements, l is locationArr and a is setArr

        // finds the set containing i and j and stores them as x and y
        long x = findSet(i, l);
        long y = findSet(j, l);
        
        //if set x is bigger than y, add y to x update count and sum for x
        if(a[(int)x].getCount() >= a[(int)y].getCount()){
            l[(int)y] = x;
            a[(int)x].count += a[(int)y].count;
            a[(int)x].sum += a[(int)y].sum;
        }

        //else add x to y update count and sum for y
        else{
            l[(int)x] = y;
            a[(int)y].count += a[(int)x].count;
            a[(int)y].sum += a[(int)x].sum;
        }
    }
    
    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);

        try{
            //while loop to continue accepting inputs until EOF is reached
            for(int k=0; k<20; k++){
                int numIntegers = io.getInt();
                int numCommands = io.getInt();

                //locationArr stores both the set location of an element
                //and the representative node of the element
                long[] locationArr = new long[numIntegers*3+1];

                //setArr will be a delayed set storing all the NumberSet classes
                //which contain sum and count of the sets
                NumberSet[] setArr = new NumberSet[numIntegers*3+1];

                /*
                for loop to fill up locationArr and setArr. For locationArr,
                the first numInteger elements are the representative nodes
                while the next numInteger elements are the set locations
                For setArr, every NumberSet object starts with count of 1
                and sum will just be the number itself as each set only contains
                one number which is itself. The indexes all represent the
                set locations for that NumberSet
                */
                for(long i=1, j = numIntegers + i; i<numIntegers+1; i++,j++){
                    locationArr[(int)i] = j;
                    locationArr[(int)j] = j;
                    setArr[(int)j] = new NumberSet(1,i);
                }

                //for loop to accept the commands
                for(int i=0; i<numCommands; i++){
                    int command = io.getInt();

                    //command 1 is union set between the sets containing p and q
                    if(command == 1){
                        long p = io.getLong();
                        long q = io.getLong();
                        //if p and q are in same set, do nothing
                        if (isSameSet(p , q, locationArr)){
                            continue;
                        }
                        //else union the sets containing them
                        else{
                            unionSet(p, q, locationArr, setArr);
                        }
                    }

                    //command 2 is move p to set containing q
                    else if(command == 2){
                        long p = io.getLong();
                        long q = io.getLong();
                        //if p and q are in same set, do nothing
                        if (isSameSet(p,q,locationArr)){
                            continue;
                        }
                        //else move p to the set containing q and update the details
                        //of sets containing p and q.
                        else{
                            long rootNodeOfP = findSet(p,locationArr);
                            long rootNodeOfQ = findSet(q,locationArr);
                            setArr[(int)rootNodeOfP].count-=1;
                            setArr[(int)rootNodeOfP].sum-=p;
                            locationArr[(int)p]=rootNodeOfQ;
                            setArr[(int)rootNodeOfQ].count+=1;
                            setArr[(int)rootNodeOfQ].sum+=p;
                        }
                    }
                
                    //if command is 3 simply print out the count and sum of the NumberSet
                    //containing p
                    else{
                        long p = io.getLong();
                        long rootNodeOfP = findSet(p, locationArr);
                        io.print(setArr[(int)rootNodeOfP].count);
                        io.print(" ");
                        io.println(setArr[(int)rootNodeOfP].sum);
                    }
                }
            }
        } 
        catch (Exception endOfFileException){
            io.close();
        }
        finally{
            io.close();
        }
    }
}


/*
NumberSet is the class we use to store the details of the sets
count refers to number of elements in the set
sum refers to sum of all elements in the set
*/
class NumberSet{
    public long count;
    public long sum;

    public NumberSet(long count, long sum){
        this.count = count;
        this.sum = sum;
    }
    //Methods to return count, sum and setLocation
    public long getCount() {return count;}
    public long getSum() {return sum;}
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
