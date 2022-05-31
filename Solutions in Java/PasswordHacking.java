import java.util.*;
import java.io.*;

public class Password{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int dataSets = io.getInt();
        double sum = 0;
        ArrayList<Double> list = new ArrayList<Double>();
        for (int i=1; i<dataSets+1; i++){
            io.getWord();
            list.add(io.getDouble());
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int j=1; j<dataSets+1; j++){
            sum+=j*list.get(j-1);
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
