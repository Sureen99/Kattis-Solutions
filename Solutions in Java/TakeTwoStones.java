import java.util.*;

public class stones {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int sc = s.nextInt();
        if (sc%2==0) {
            System.out.println("Bob");
        }
        else {
            System.out.println("Alice");
        }
    }
}
