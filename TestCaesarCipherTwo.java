
import java.io.*;
import edu.duke.*;
import java.lang.*;


/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author Anirduh Maheshwari
 * @version 1
 */
public class TestCaesarCipherTwo {
    public int maxIndex(int[] count){
        int max=0;
        int im=0;
        for(int i=0;i<count.length;i++){
            if(max<count[i])
               {max=count[i];
                 im=i;
                }
         }
       return im;
    }
    
    public int[] countLetters(String encrypted){
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] count=new int[26];
        for(int i=0;i<encrypted.length();i++)
          { char ch = Character.toUpperCase(encrypted.charAt(i));
            int idx = alpha.indexOf(ch);
            if(idx!=-1){
               count[idx]++;
            }
            
        }     
        return count;
    }
    
    public String halfOfString(String message,int start){
       StringBuilder s = new StringBuilder("");
       for(int i=0;i<message.length();i++){
          if(i%2==start)
           s.append(message.charAt(i));
       }
       return s.toString();
    }
    
    public void simpleTests(){
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        String decrypted = cc.decrypt(message);
        System.out.println(decrypted);
        breakCaesarCipher(encrypted);
    }
    
    public void breakCaesarCipher(String input){
         CaesarBreaker cb = new CaesarBreaker();
        // int key=cb.getKey(input);
        // System.out.println("key :"+key);
         String decrypted=cb.decryptTwoKeys(input);
         System.out.println(decrypted);
    }
}
