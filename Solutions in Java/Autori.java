import java.util.*;

public class Autori {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String sc = s.nextLine();
        String ans=String.valueOf(sc.charAt(0));
        for (int i=0; i<sc.length();i++){
            if (sc.charAt(i)=='-'){
                ans+=String.valueOf(sc.charAt(i+1));
            }
        }
    
        System.out.println(ans);
    }
}
