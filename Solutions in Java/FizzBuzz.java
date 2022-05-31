import java.util.*;
import java.io.*;

public class FizzBuzz{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int X = io.getInt();
        int Y = io.getInt();
        int N = io.getInt();
        for (int i=1; i<N+1; i++){
            if (i%X==0 && i%Y==0){
                io.println("FizzBuzz");
            }
            
            else if (i%X==0){
                io.println("Fizz");
            }
            
            else if (i%Y==0){
                io.println("Buzz");
            }
            else{
                io.println(i);
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
