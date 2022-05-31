import java.util.*;
import java.io.*;

public class Work{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int researcherNum = io.getInt();
        int inactiveTime = io.getInt();
        PriorityQueue<Integer> enterTime = new PriorityQueue<Integer>();
        //Priority queue used to store all entry times of the researchers

        PriorityQueue<Integer> exitTime = new PriorityQueue<Integer>();
        //Priority queue used to store all exit times of the researchers

        int count = 0;
        //count variable used to count the number of unlocks saved

        for (int i=0; i<researcherNum; i++){
            int temp = io.getInt();
            enterTime.add(temp);
            exitTime.add(temp+io.getInt());
        }//for loop to collect input info which are the entry and exit times

        //while loop until one of the priority queues get exhausted
        while (enterTime.peek()!=null && exitTime.peek()!=null){
            while (enterTime.peek()<exitTime.peek()){
                enterTime.poll();
                if(enterTime.peek()==null){
                    break;
                }
                /*
                if exit time is bigger than entry time it means that the
                incoming researcher does not have an already unlocked room
                to use. So it is not going to help towards saving unlocks
                and we remove the entry time.
                */
            }
            if(enterTime.peek()==null){
                break;
            }
            while (enterTime.peek() - exitTime.peek() > inactiveTime){
                exitTime.poll();
                if(exitTime.peek()==null){
                    break;
                }
                /*
                if entry time is bigger than the exit time by a value
                larger than the inactive time, it means that the researcher
                is too late to use an unlocked room. So once again its not
                going to help towards saving unlocks and we remove the
                exit time
                */
            }
            if(exitTime.peek()==null){
                break;
            }
            if (enterTime.peek() - exitTime.peek() <= inactiveTime && 0<= enterTime.peek() - exitTime.peek()){
                enterTime.poll();
                exitTime.poll();
                count+=1;
                /*
                entry time and exit time within range so an unlock
                will be saved. We remove both entry and exit times
                and increase count by 1
                */
            }
        }
        io.println(count);
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
