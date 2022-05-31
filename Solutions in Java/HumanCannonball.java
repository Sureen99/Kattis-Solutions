import java.util.*;
import java.io.*;
import java.lang.*;

public class Cannon{
    //method used to relax edges
    public static void updateTime(HashMap<Vertex,Float> timeMap, PriorityQueue<Coordinate> timeQueue, Vertex start, Vertex end){
        //find distance between the 2 vertexes
        float distance = (float) Math.sqrt(Math.pow(end.x - start.x,2) + Math.pow(end.y - start.y,2));
        //first way to calculate time will be to just walk
        float time1 = distance/5;
        //second way is to use cannon
        float time2 = 2 + (Math.abs(distance-50)/5);
        //new time is min of the 2 + time to get from start vertex to this vertex
        float newTime = Math.min(time1,time2) + timeMap.get(start);
        float oldTime = timeMap.get(end);
        //if new time is lower than old time, update timeMap and add new coordinate to timeQueue
        if(newTime<oldTime){
            timeMap.put(end, newTime);
            timeQueue.add(new Coordinate(newTime, start, end));
        }
    }

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        //timeQueue to pick edges with the shortest time taken between them
        PriorityQueue<Coordinate> timeQueue = new PriorityQueue<Coordinate>(new timeComparator());
        //timeMap to keep track of time taken to get from start to a particular vertex
        HashMap<Vertex, Float> timeMap = new HashMap<Vertex,Float>();
        //visitMap to check if a vertex has been added to dijkstras set or not
        HashMap<Vertex, Integer> visitMap = new HashMap<Vertex,Integer>();
        //vertexList to keep track of all the vertexes for the purposes of looping
        ArrayList<Vertex> vertexList = new ArrayList<Vertex>();

        //Initialise start vertex and add it to all the above data structures
        //Time always taken from start vertex
        float startX = io.getFloat();
        float startY = io.getFloat();
        Vertex startVertex = new Vertex(startX,startY);
        float time = 0;
        timeQueue.add(new Coordinate(time, startVertex, startVertex));
        timeMap.put(startVertex, time);
        visitMap.put(startVertex,1);
        vertexList.add(startVertex);

        //Initialise end vertex and add it to all the above data structures
        //Time always taken from start vertex
        float endX = io.getFloat();
        float endY = io.getFloat();
        float dist = (float) Math.sqrt(Math.pow(endX-startX,2) + Math.pow(endY-startY,2));
        time = dist/5;
        Vertex endVertex = new Vertex(endX, endY);
        timeQueue.add(new Coordinate(time, startVertex, endVertex));
        timeMap.put(endVertex, time);
        visitMap.put(endVertex,0);
        vertexList.add(endVertex);

        int numCoords = io.getInt();
        //Loop through to initialise all the other vertexes. As usual time taken from start vertex
        for(int i=0; i<numCoords; i++){
            float newX = io.getFloat();
            float newY = io.getFloat();
            Vertex nextVertex = new Vertex(newX, newY);
            dist = (float) Math.sqrt(Math.pow(newX-startX,2) + Math.pow(newY-startY,2));
            time = dist/5;
            timeQueue.add(new Coordinate(time, startVertex, nextVertex));
            timeMap.put(nextVertex, time);
            visitMap.put(nextVertex,0);
            vertexList.add(nextVertex);
        }

        //Dijkstra's modified slightly
        //until endVertex is visited, keep looping
        while (visitMap.get(endVertex)==0){
            //poll the coordinate with the smallest distance from start vertex
            Coordinate nextCoordinate = timeQueue.poll();
            //if coordinate already visited, keep polling until you find unvisited coordinate
            while(visitMap.get(nextCoordinate.v2)==1){
                nextCoordinate = timeQueue.poll();
            }
            //update visitMap
            visitMap.put(nextCoordinate.v2,1);
            //Relax all other edges that are not in the visitMap
            for(int j=0; j<vertexList.size(); j++){
                Vertex relaxVertex = vertexList.get(j);
                //if in visitMap do nothing
                if(visitMap.get(relaxVertex)==1);
                //else relax edge
                else{
                    updateTime(timeMap, timeQueue, nextCoordinate.v2, relaxVertex);
                }
            }
        }

        io.println(timeMap.get(endVertex));
        io.close();
    }
}
class Vertex{
    public float x;
    public float y;

    public Vertex(float x, float y){
        this.x = x;
        this.y = y;
    }
}
class Coordinate{
    public float time;
    public Vertex v1;
    public Vertex v2;

    public Coordinate(float time, Vertex v1, Vertex v2){
        this.time = time;
        this.v1 = v1;
        this.v2 = v2;
    }

    public float getTime() {return time;}
}

class timeComparator implements Comparator<Coordinate> {
    public int compare(Coordinate c1, Coordinate c2) {
        //Returns -1 if c1 bigger than c2
        //Returns 1 if c2 bigger than c1
        //Else return 0
        if((c1.getTime() - c2.getTime())>0){
            return 1;
        }
        else if((c1.getTime() - c2.getTime())<0){
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

    public float getFloat() {
        return Float.parseFloat(nextToken());
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
