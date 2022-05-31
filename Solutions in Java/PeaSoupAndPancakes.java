import java.util.*;

public class peas{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int a=Integer.parseInt(sc.nextLine());
        boolean found = false;
        for (int i=0;i<a;i++){
            int b =Integer.parseInt(sc.nextLine());
            boolean ps=false;
            boolean pn=false;
            String c = sc.nextLine();
            for (int j=0;j<b;j++){
                String d =sc.nextLine();
                if (d.equals("pea soup")){
                    ps=true;
                }
                else if (d.equals("pancakes")){
                    pn=true;
                }
            }
            if (ps==true && pn==true){
                found=true;
                System.out.println(c);
                break;
            }
        }    
        if(!found){
            System.out.println("Anywhere is fine I guess");
        }
    }
}
