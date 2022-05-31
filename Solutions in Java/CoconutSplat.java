import java.util.*;
import java.io.*;

public class CoconutSplat{
    
    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int rhymeNumber = io.getInt();
        int playerNumber = io.getInt();

        //Creating a list of Players to collect input
        ArrayList <int[]> inGame = new ArrayList<int[]>();
        for(int i=0; i<playerNumber; i++){
            //Arr in the form {number of player, status}
            //2 refers to folded hands
            //1 refers to fist
            //0 refers to palm down
            //All hands initialise as 2 as they start folded
            int tempArr[] = {i+1,2};
            inGame.add(tempArr);
        }

        //Initialising an index so as to easily track the player getting hit for the purposes of starting a new round
        int index = 0;
        
        //While loop until there is only 1 player left
        while (inGame.size()>1){
            //Moving the index to the index of the person getting hit
            //Initialises the start player of next round
            //The -1 is necessary to ensure that it counts from index 0 instead of index 1
            index = (index + rhymeNumber-1) % inGame.size();
            
            //If the hands are still folded decrement life of hands
            //Split the hands into two fists by adding another hand with same name and status = 1 at index
            if (inGame.get(index)[1]==2){
                inGame.get(index)[1]-=1;
                int tempArr[] = {inGame.get(index)[0],1};
                inGame.add(index, tempArr);
            }
            
            //If the hand is fist decrement life of hand
            //Increase index by 1 to move start location to next hand
            else if (inGame.get(index)[1]==1){
                inGame.get(index)[1]-=1;
                index+=1;
            }
            
            //If the hand is palm down remove hand from game
            else if (inGame.get(index)[1]==0){
                inGame.remove(index);
            }
        }
        io.println(inGame.get(0)[0]);
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
