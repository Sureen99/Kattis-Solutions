import java.util.*;
import java.io.*;

public class CardTrading{
    
    public static void main(String[] args){
        Kattio io = new Kattio(System.in,System.out);
        int cardNumber = io.getInt();
        int cardTypes = io.getInt();
        int comboNumber = io.getInt();
        
        //Initialising a list to keep track of all the cards in deck
        List <Integer> cardsInDeck = new ArrayList<Integer>();
        for (int i=0; i<cardNumber; i++){
            cardsInDeck.add(io.getInt());
        }

        //Sorting cardsInDeck so that counting will be O(nlogn)
        Collections.sort(cardsInDeck);
        
        //Loop to take in the card data as an ArrayList
        List <Card> cardDetails = new ArrayList<Card>();

        //Defining index outside of loop as it will become a loop break condition for the innermost loop
        int index = 0;
        for (int j=1; j<cardTypes+1;j++){
            int count = 0;
            //only need inner loop to loop 2 times max as max count of a card is 2
            for (int l=0;l<2;l++){
                //important to have this step to prevent index out of bounds error
                if(index==cardNumber){
                    break;
                }
                //if item at index is bigger than j, count is done as the list is sorted
                else if(j<cardsInDeck.get(index)){
                    break;
                }
                //counting statement
                else if(j==cardsInDeck.get(index)){
                    count+=1;
                    index+=1;
                }
            }
            long buy = io.getLong();
            long sell = io.getLong();
            long oppCost = (2-count)*buy + sell*count;
            //Opp cost computed by the money to be potentially gained by selling card/cards + cost of buying card/cards to get a combo
            cardDetails.add(new Card(count, buy, sell, oppCost));
        }

        //Sorting list based on comparator
        Collections.sort(cardDetails,new OppCostComparator());

        //Calculating total cost
        long cost = 0;
        for (int k=0; k<cardDetails.size();k++){
            if(k<comboNumber){
                cost-=(2-cardDetails.get(k).getCount())*cardDetails.get(k).getBuy();
            }//Buy the first comboNumber cards as they have the lowest oppCost
            else{
                cost+=cardDetails.get(k).getCount()*cardDetails.get(k).getSell();
            }//Sell the rest
        }
        io.println(cost);
        io.close();
    }
}
//Implementing Card class
class Card {
    public int count;
    public long buy;
    public long sell;
    public long oppCost;

    public Card(int count, long buy, long sell, long oppCost){
        this.count = count;
        this.buy = buy;
        this.sell = sell;
        this.oppCost = oppCost;
    }
    public long getCount() {return count;}
    public long getBuy() {return buy;}
    public long getSell() {return sell;}
}
//Implementing comparator
class OppCostComparator implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        //Comparing Opp cost of including a certain card in the deck
        if(c1.oppCost > c2.oppCost){
            return 1;
        }
        else if(c1.oppCost < c2.oppCost){
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
