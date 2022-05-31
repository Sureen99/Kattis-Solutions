import java.util.*;
import java.io.*;

public class WeakVertices{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int verticeNum = io.getInt();
        //keep accepting inputs until -1 is inputted
        while(verticeNum!=-1){
            //create and fill up adjMatrix and adjList
            int[][] adjMatrix = new int[verticeNum][verticeNum];
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(verticeNum);
            for (int a=0; a<verticeNum;a++){
                adjList.add(new ArrayList<Integer>(verticeNum));
            }
            for(int i=0 ; i < verticeNum; i++){
                for(int j=0; j< verticeNum; j++){
                    adjMatrix[i][j]=io.getInt();
                    if(adjMatrix[i][j]==1){
                        adjList.get(i).add(j);
                    }
                }
            }

            
            Boolean flag = false;
            for(int k=0;k<verticeNum;k++){
                //for each element, loop through its adjList to find possible middleNums
                for(int l=0; l<adjList.get(k).size(); l++){
                    int middleNum = adjList.get(k).get(l);
                    //for each middleNum, loop adjList to find possible finalNums
                    for(int m=0; m<adjList.get(middleNum).size();m++){
                        int finalNum = adjList.get(middleNum).get(m);
                        //ensure that k, middleNum and finalNum all unique
                        if(middleNum==k){
                            continue;
                        } 
                        else if(finalNum==k || finalNum==middleNum){
                            continue;
                        }
                        //if they are use loop break condition to break out of inner loops
                        else if(adjMatrix[finalNum][k]==1){
                            flag = true;
                        }
                        if(flag){
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                //if no suitable middleNum and finalNum found, print the first num
                if(flag==false){
                    io.print(k);
                    io.print(" ");
                }
                else{
                    flag = false;
                }
            }
            io.println("");
            verticeNum = io.getInt();
        }
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
