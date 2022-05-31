import java.util.*;
import java.io.*;

public class Akcija{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int dataSets = io.getInt();
        ArrayList<Integer> books = new ArrayList<Integer>();
        for (int i=0; i<dataSets; i++){
            books.add(io.getInt());
        }
        Collections.sort(books);
        Collections.reverse(books);
        int sum = 0;
        for(int j=1; j<dataSets+1;j++){
            if (j%3==0);
            
            else{
                sum+=books.get(j-1);
            }
        }
        io.println(sum);
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
