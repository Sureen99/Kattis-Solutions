import java.util.*;
import java.io.*;

public class Million{
    //PriorityQueue used to order the coordinates inputted to sort by min weight
    public static PriorityQueue<Coordinate> weightQueue = new PriorityQueue<Coordinate>(new weightComparator());

    //function to add new coordinates into the priorityQueue
    public static void updateQ(int[][] coinMatrix, int currRow, int currColumn, int nextRow, int nextColumn){
        //The weight of a path is coin stack of next position - coin stack of current position
        int weight = coinMatrix[nextRow][nextColumn] - coinMatrix[currRow][currColumn];
        //If coin stack of current position is bigger, duck can just drop down so weight is 0
        if (weight<0){
            weight = 0;
        }
        //adding the coordinate to the priorityqueue
        Coordinate temp = new Coordinate(nextRow, nextColumn, weight);
        weightQueue.add(temp);
    }

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int rows = io.getInt();
        int columns = io.getInt();
        //matrix containing the heights of the coin stacks
        int[][] coinMatrix = new int[rows][columns];
        //matrix to check if a certain vertex has been visited or not
        int[][] visitMatrix = new int[rows][columns];

        //for loop to fill up coin Matrix
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                coinMatrix[i][j]=io.getInt();
            }
        }
        
        //ladderSize used to keep track of minimum ladder size required
        int ladderSize = 0;
        //Initialising start coordinates to do Prim's
        int currRow = 0;
        int currColumn = 0;
        visitMatrix[0][0] = 1;
        //move array to contain all possible coordinate moves from current coordinate
        int[][] move = {{-1,0},{0,1}, {1,0}, {0,-1}};
        //flag to break while loop once end coordinate is reached
        Boolean flag = true;
        while(flag){
            //if there is only one coin stack in entire matrix, its the end coin stack so just exit
            if(coinMatrix.length==1 && coinMatrix[0].length==1){
                flag = false;
            }
            else{
                //Add all neighbours of the current coordinate to the priority queue accounting for all
                //possible locations of current coordinate
                for(int i=0; i<4;i++){
                    //move function with similar implementation as the lab 10 slides
                    int nextRow = currRow + move[i][0];
                    int nextColumn = currColumn + move[i][1];
                    //accounting for border restrictions
                    if(nextRow<0 || nextColumn<0);
                    else if(nextRow>=visitMatrix.length || nextColumn>=visitMatrix[0].length);
                    else{
                        updateQ(coinMatrix, currRow, currColumn, nextRow, nextColumn);
                    }
                }
                //boolean variable used to continue the loop until an unvisited coordinate is found
                //this is done as visited coordinates already have all their neighbours inside PQ
                Boolean visit = true;
                while(visit){
                    Coordinate nextCoordinate = weightQueue.poll();
                    currRow=nextCoordinate.rowNum;
                    currColumn=nextCoordinate.columnNum;
                    if(visitMatrix[currRow][currColumn]==0){
                        visitMatrix[currRow][currColumn]=1;
                        //if weight of path to next coordinate is bigger than laddersize, update laddersize
                        if(nextCoordinate.getWeight()>ladderSize){
                            ladderSize=nextCoordinate.getWeight();
                        }
                        visit = false;
                    }
                }
                //once end point is reached, update flag to end loop
                if(visitMatrix[visitMatrix.length-1][visitMatrix[0].length-1]==1){
                    flag = false;
                }
            }
        }
        io.println(ladderSize);
        io.close();
    }
}
//Coordinate class stores details of coordinate such as rownum columnnum and weight
//weight is weight of path from prev position to current position
class Coordinate{
    public int rowNum;
    public int columnNum;
    public int weight;

    public Coordinate(int rowNum, int columnNum, int weight){
        this.rowNum=rowNum;
        this.columnNum=columnNum;
        this.weight=weight;
    }

    public int getWeight() {return weight;}
}

class weightComparator implements Comparator<Coordinate> {
    public int compare(Coordinate c1, Coordinate c2) {
        //Returns -1 if c1 bigger than c2
        //Returns 1 if c2 bigger than c1
        //Else return 0
        if((c1.getWeight() - c2.getWeight())>0){
            return 1;
        }
        else if((c1.getWeight() - c2.getWeight())<0){
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
