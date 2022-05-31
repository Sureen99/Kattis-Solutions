import java.util.*;
import java.io.*;

public class Islands{

    //DFS method to help us DFS through the matrix and find islands
    public static void DFS(Character[][] planetMatrix, int[][]visitMatrix, int rowNum, int columnNum){
        //if already visited, do nothing and skip
        if(visitMatrix[rowNum][columnNum]==1);

        //If the location contains Water, just update visitMatrix and don't do anything else
        else if(planetMatrix[rowNum][columnNum]=='W'){
            visitMatrix[rowNum][columnNum]=1;
        }

        //Else update visitmatrix and DFS on all its neighbours
        else{
            visitMatrix[rowNum][columnNum]=1;
            //if matrix only 1 element do nothing
            if(planetMatrix.length==1 && planetMatrix[0].length==1);

            //if matrix only has 1 row just need to dfs through all the elements in that row
            else if(planetMatrix.length==1){
                if (columnNum==0){
                    DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
                }
                else if(columnNum==planetMatrix[0].length-1){
                    DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
                }
                else{
                    DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
                    DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
                }
            }
            //if matrix only has 1 column just need to dfs through all the elements in that column
            else if(planetMatrix[0].length==1){
                if (rowNum==0){
                    DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                }
                else if(rowNum==planetMatrix.length-1){
                    DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                }
                else{
                    DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                    DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                }
            }

            //If top left corner, DFS right and bottom
            else if(rowNum==0 && columnNum==0){
                DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
            }
            //If top right corner, DFS left and bottom
            else if(rowNum==0 && columnNum==planetMatrix[0].length-1){
                DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
            }
            //if bottom left corner, DFS top and right
            else if(rowNum==planetMatrix.length-1 && columnNum==0){
                DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
            }
            //if bottom right corner, DFS top and left
            else if(rowNum==planetMatrix.length-1 && columnNum==planetMatrix[0].length-1){
                DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
            }
            //else if on the top row, DFS left, right and bottom
            else if(rowNum==0){
                DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
            }
            //else if on the bottom row, DFS top, left and right
            else if(rowNum==planetMatrix.length-1){
                DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
            }
            //else if on leftmost column, DFS top, bottom and right
            else if(columnNum==0){
                DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
            }
            //else if on rightmost column, DFS top, bottom and left
            else if(columnNum==planetMatrix[0].length-1){
                DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
                DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
            }
            //else DFS top,right,left and bottom
            else{
                DFS(planetMatrix, visitMatrix, rowNum+1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum-1, columnNum);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum+1);
                DFS(planetMatrix, visitMatrix, rowNum, columnNum-1);
            }
        }
    }

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int rows = io.getInt();
        int columns = io.getInt();
        //planetMatrix to store the matrix and visitMatrix to check if a particular
        //location has been visited
        Character[][] planetMatrix = new Character[rows][columns];
        int[][] visitMatrix = new int[rows][columns];
        //input values into the planetMatrix
        for(int i=0; i<rows; i++){
            String inputString = io.getWord();
            for(int j=0; j<columns; j++){
                planetMatrix[i][j]=inputString.charAt(j);
            }
        }
        //count to keep track of number of islands
        int count = 0;
        for(int a=0; a<rows; a++){
            for(int b=0;b<columns;b++){
                //If a land is found and not visited yet, DFS that land and increment count
                if (planetMatrix[a][b]=='L' && visitMatrix[a][b]==0){
                    count+=1;
                    DFS(planetMatrix, visitMatrix, a, b);
                }
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
