import java.util.*;
import java.lang.*;
public class pot {
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        int sum = 0;
        for (int i=0;i<b;i++) {
            int c = a.nextInt();
            int d = c/10;
            int e = c%10;
            int f = (int)Math.pow(d,e);
            sum+=f;
        }
        System.out.println(sum);
    }
}
