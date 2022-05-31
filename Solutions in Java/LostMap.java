import java.util.*;
import java.io.*;

public class LostMap{
    //adds all edges for that vertex into roadQueue
    public static void Prims(int index,int[][]inputMatrix,PriorityQueue<Village> roadQueue){
        for (int a=0;a<inputMatrix.length;a++){
            //if same village, exclude
            if(index==a);
            //else put it in roadQueue
            else{
                roadQueue.add(new Village(index,a,inputMatrix[index][a]));
            }
        }
    }

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int villageNum = io.getInt();

        //Priority Queue to store the connections between 2 villages sorted by distance
        PriorityQueue<Village> roadQueue = new PriorityQueue<Village>(new distanceComparator());
        //visitArr checks if the village has been previously visited
        int[]visitArr = new int[villageNum];
        //inputMatrix to collect input
        int[][] inputMatrix = new int[villageNum][villageNum];

        //for loop to collect input
        for(int i=0; i<villageNum; i++){
            for(int j=0; j<villageNum; j++){
                int dist = io.getInt();
                inputMatrix[i][j]=dist;
            }
        }
        int index = 0;
        //start prims at index 0
        for(int k=0; k<villageNum-1;k++){
            //add all connections of that index to roadQueue
            Prims(index, inputMatrix, roadQueue);
            Boolean flag = true;
            //until suitable connection is reached, keep looping
            while(flag){
                //chooses connection with shortest distance every time
                Village chosen = roadQueue.poll();
                //if both are already visited, a connection already exists
                if(visitArr[chosen.villOne]==1 && visitArr[chosen.villTwo]==1);
                //else print the connection, update index and visitArr
                else{
                    visitArr[chosen.villOne]=1;
                    visitArr[chosen.villTwo]=1;
                    io.print(chosen.villOne+1);
                    io.print(" ");
                    io.println(chosen.villTwo+1);
                    flag = false;
                    index = chosen.villTwo;
                }
            }
            
        }
        io.close();
    }
}
//village class stores all the road connection details between 2 villages
class Village{
    public int villOne;
    public int villTwo;
    public int distance;

    public Village(int villOne, int villTwo, int distance){
        this.villOne=villOne;
        this.villTwo=villTwo;
        this.distance=distance;
    }

    public int getDist() {return distance;}
}

class distanceComparator implements Comparator<Village> {
    public int compare(Village v1, Village v2) {
        //Returns -1 if v1 bigger than v2
        //Returns 1 if v2 bigger than v1
        //Else return 0
        if((v1.getDist() - v2.getDist())>0){
            return 1;
        }
        else if((v1.getDist() - v2.getDist())<0){
            return -1;
        }
        else{
            return 0;
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
