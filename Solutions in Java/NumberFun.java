import java.util.*;

public class numbers{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int sc = s.nextInt();
        for (int i=0;i<sc;i++){
            int x = s.nextInt();
            int y = s.nextInt();
            int z = s.nextInt();
            if (x-y==z || y-x==z || x+y==z || x*y==z || (float)x/(float)y==(float)z || (float)y/(float)x==(float)z){
                System.out.println("Possible");
            }
            else{
                System.out.println("Impossible");
            }
        }
    }
}
