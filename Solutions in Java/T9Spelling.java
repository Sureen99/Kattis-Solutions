import java.util.*;

public class CharactersToDigits{
    
    public static void main(String[] args){
        String keypadArr[] = {"2","22","222",
        "3","33","333","4","44","444",
        "5","55","555","6","66","666",
        "7","77","777","7777",
        "8","88","888","9","99","999","9999"};
        //Array of the buttons on a T9 keypad
        
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        
        for (int i=0; i<testCases; i++){
            String inputString = sc.nextLine();
            StringBuilder keyPressSequence = new StringBuilder("");
            
            //Initialising the first char of keyPressSequence to allow for comparison with newPressSequence later in the code
            if (inputString.charAt(0)==' '){
                keyPressSequence.append('0');
            }
            else{
                keyPressSequence.append(keypadArr[(int)inputString.charAt(0)-(int)'a']);
            }
            
            for (int j=1; j<inputString.length();j++){
                //newPressSequence is used to compare with keyPressSequence for repeated use of same button
                String newPressSequence = new String("");
                
                if (inputString.charAt(j)==' '){
                    newPressSequence="0";
                }
                else{
                    newPressSequence=keypadArr[(int)inputString.charAt(j)-(int)'a'];
                }
                
                if (keyPressSequence.charAt(keyPressSequence.length()-1)==newPressSequence.charAt(0)){
                    keyPressSequence.append(" "+newPressSequence);
                }
                else{
                    keyPressSequence.append(newPressSequence);
                }
            }
            
            System.out.println("Case #"+ Integer.toString(i+1) + ": " +keyPressSequence);
            
        }
    }
}
