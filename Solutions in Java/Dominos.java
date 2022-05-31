import java.util.*;
import java.io.*;

public class Dominos{

    //DFS based topoSort function
    public static void topoSorting(int a,ArrayList<Integer> tempArr, int[] visitArr, ArrayList<ArrayList<Integer>> adjList){
        //update visitArr
        visitArr[a]=1;
        //loop through neighbours
        for(int i=0; i<adjList.get(a).size(); i++){
            //if neighbour not visited yet call topoSort on him
            if(visitArr[adjList.get(a).get(i)]==0){
                topoSorting(adjList.get(a).get(i), tempArr, visitArr, adjList);
            }
        }
        //add element to tempArr. This function will give a reverse topoSort list as the
        //parent vectors will be added last
        tempArr.add(a);
    }

    //DFS function used to update visitorArr so that counting components function will be accurate
    public static void DFS(ArrayList<ArrayList<Integer>> adjList, int[] visitorArr, int number){

        //if vertex has no neighbours, just update visitorArr
        if(adjList.get(number).size()==0){
            visitorArr[number]=1;
        }
        
        //if it has neighbours update visitorArr and check each neighbour with DFS
        else{
            visitorArr[number]=1;
            for(int i=0; i<adjList.get(number).size(); i++){
                //if neighbour unvisited, DFS neighbour
                if(visitorArr[adjList.get(number).get(i)]==0){
                    DFS(adjList, visitorArr, adjList.get(number).get(i));
                }
            }
        }
    }

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int testCaseNum = io.getInt();

        //for loop to accept every test case
        for(int i=0; i< testCaseNum; i++){
            int verticeNum = io.getInt();
            int lineNum = io.getInt();

            //create an adjList of all neighbours of the vertex at each index
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(verticeNum);
            
            for (int a=0; a<verticeNum;a++){
                adjList.add(new ArrayList<Integer>());
            }

            //fill up the adjList using the inputs
            for (int b=0; b<lineNum; b++){
                int firstNum = io.getInt()-1;
                int secondNum = io.getInt()-1;
                adjList.get(firstNum).add(secondNum);
            }
            //visitArr to check for previously visited nodes for topoSort function
            int[] visitArr = new int[verticeNum];

            //tempArr to maintain a reverse topoSorted arrayList of nodes
            ArrayList<Integer> tempArr = new ArrayList<Integer>();
            
            //topoSort the vertices
            for (int j=0; j<verticeNum;j++){
                if(visitArr[j]==0){
                    topoSorting(j,tempArr, visitArr, adjList);
                }
            }

            //Reversing the array manually cos for some unknown reason collections.reverse() 
            //keeps giving me issues with the output
            Stack<Integer> stack = new Stack<Integer>();
            for (int k=0; k<verticeNum;k++){
                stack.push(tempArr.get(k));
            }

            //topoSortArr to contain the topoSorted elements
            ArrayList<Integer> topoSortArr = new ArrayList<Integer>();
            for (int l=0; l<verticeNum;l++){
                topoSortArr.add(stack.pop());
            }

            /*
            Count to count number of connected components and visitorArr to track if
            a certain vertex has been previously visited by the DFS function
            */
            int count = 0;
            int[] visitorArr = new int[verticeNum];

            for(int c=0; c<verticeNum; c++){
                //for each vertex if unvisited, increment count and DFS the vertex
                if (visitorArr[topoSortArr.get(c)]==0){
                    count+=1;
                    DFS(adjList, visitorArr, topoSortArr.get(c));
                }

            }
            io.println(count);
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
