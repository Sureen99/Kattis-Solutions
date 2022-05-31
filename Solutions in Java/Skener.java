import java.util.*;
import java.io.*;

public class Skener{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int inRows = io.getInt();
        int inColumns = io.getInt();
        int outRows = io.getInt();
        int outColumns = io.getInt();
        
        for (int i=0; i<inRows; i++){
            String inputWord = io.getWord();
            for (int j=0; j<outRows;j++){
                for(int k=0; k<inColumns;k++){
                    for(int l=0;l<outColumns;l++){
                        io.print(inputWord.charAt(k));
                    }
                }
                io.println();
            }
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
