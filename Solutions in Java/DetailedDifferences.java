import java.util.*;

public class diff {
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        int b = Integer.parseInt(a.nextLine());
        for (int i=0; i<b;i++) {
            String c = a.nextLine();
            String d = a.nextLine();
            String e = new String("");
            for (int j=0;j<c.length();j++){
                if (c.charAt(j)==d.charAt(j)){
                    e+='.';
                }
                else{
                    e+='*';
                }
            }
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
            System.out.println(' ');
        }
    }
}
