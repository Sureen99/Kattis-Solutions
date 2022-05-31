import java.util.*;
import java.io.*;

public class Kattis{

    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        TreeMap<Integer, PriorityQueue> energyMap = new TreeMap<Integer, PriorityQueue>();
        /*
        TreeMap to store all incoming energy as keys and all incoming reward as elements 
        added to the priorityqueue that corresponds to the key value
        */ 

        int operationNum = io.getInt();
        //For loop to collect input and execute all operations
        for (int i=0; i<operationNum; i++){
            String operationName = io.getWord();

            //if operation is "add" collect the 2 values for energy and reward for the task
            if (operationName.equals("add")){
                int energy = io.getInt();
                int reward = io.getInt();

                //if key already present in TreeMap, add reward to the PQ at value
                if(energyMap.containsKey(energy)){
                    PriorityQueue<Integer> temp = energyMap.get(energy);
                    temp.add(reward);
                    energyMap.put(energy,temp);
                }

                //else if key not present, create a PQ, add reward then set PQ as value for the key
                else{
                    //PQ is initialised in reverseorder as we want it to be a maxheap not minheap
                    PriorityQueue<Integer> temp = new PriorityQueue<Integer>(Collections.reverseOrder());
                    temp.add(reward);
                    energyMap.put(energy,temp);
                }
            }

            //else if operation is query, collect the value for energy for session and a create a
            //variable to store reward
            else{
                int sessionEnergy = io.getInt();
                long totalReward = 0;

                //While loop to find suitable quests for the kattis cat until not possible
                while (sessionEnergy>=0){

                    //if not suitable task left, print the reward for the session
                    if(energyMap.floorKey(sessionEnergy)==null){
                        io.println(totalReward);
                        break;
                    }

                    //If a suitable task is found, update the TreeMap and PriorityQueues and add to reward
                    else{
                        int closestKey = energyMap.floorKey(sessionEnergy);
                        sessionEnergy -= closestKey;
                        PriorityQueue<Integer> temp = energyMap.get(closestKey);
                        totalReward += temp.poll();
                        energyMap.put(closestKey,temp);

                        //if PQ is empty, delete the key value pairing to avoid errors
                        if (energyMap.get(closestKey).peek() == null){
                            energyMap.remove(closestKey);
                        }
                    }
                }
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
