import java.util.*;

public class digit {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        
        for (int j=0; j<b; j++){
            int sc = a.nextInt();
            int sum = 1;
            for (int i=1;i<(sc+1);i++){
                sum=sum*i;
            }    
            System.out.println(sum%10);
        }    
    }
}
