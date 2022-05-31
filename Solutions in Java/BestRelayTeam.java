import java.util.*;
import java.io.*;

public class BestRelayTeam{
    
    public static void main(String[] args){
        Kattio io = new Kattio(System.in, System.out);
        int testCaseNumber = io.getInt();
        List <Runner> runnerArr = new ArrayList<Runner>();
        
        //Collecting input in the form of ArrayList
        //Containing Runner objects of (name, leg1, leg2) 
        for (int i=0; i<testCaseNumber; i++){
            String name = io.getWord();
            double leg1 = io.getDouble();
            double leg2 = io.getDouble();
            runnerArr.add(new Runner(name, leg1, leg2));
        }

        //sorting ArrayList based on comparator
        Collections.sort(runnerArr, new Leg2Comparator());
        
        //Creating ArrayList for best team
        List <String> dreamTeam = new ArrayList<String>();
        //Initialising dream time as a large upper bound time
        double dreamTime = 1000.0;
        
        for (int j=0; j<testCaseNumber; j++){
            //ArrayList for test team
            List <String> currentTeam = new ArrayList<String>();
            
            //Pick 1st runner then find best possible team for him
            //Then loop through to change 1st runner
            currentTeam.add(runnerArr.get(j).name);
            double currentTime = runnerArr.get(j).leg1;
            for (int k=0; currentTeam.size()<4; k++){
                if (currentTeam.contains(runnerArr.get(k).name)){
                    continue;
                }
                else{
                    currentTeam.add(runnerArr.get(k).name);
                    currentTime+=runnerArr.get(k).leg2;
                }
            }
            //Check if currentTeam's time better than prev dreamTeam
            //If it is currentTeam becomes dreamTeam
            if (currentTime<dreamTime){
                dreamTime = currentTime;
                dreamTeam = currentTeam;
            }
        }
        
        io.println(dreamTime);
        io.println(dreamTeam.get(0));
        io.println(dreamTeam.get(1));
        io.println(dreamTeam.get(2));
        io.println(dreamTeam.get(3));
        io.close();
    }
}
//Implementation of Runner class
class Runner {
    public String name;
    public double leg1;
    public double leg2;

    public Runner(String name, double leg1, double leg2){
        this.name = name;
        this.leg1 = leg1;
        this.leg2 = leg2;
    }

    public String getName() {return name;}
    public double getleg1() {return leg1;}
    public double getleg2() {return leg2;}
}
//Implementation of comparator
class Leg2Comparator implements Comparator<Runner> {
    public int compare(Runner r1, Runner r2) {
        //Returns 1 if result (+)ve r1 slower than r2
        //Returns -1 if result (-)ve r2 slower than r1
        //Else return 0
        if((r1.getleg2() - r2.getleg2())>0){
            return 1;
        }
        else if((r1.getleg2() - r2.getleg2())<0){
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
