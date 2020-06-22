
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author Anirudh Mahehswari 
 * @version 1
 */
import java.io.*;
import edu.duke.*;
import java.lang.*;

public class TestCaesarCipher {
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
    
    public void simpleTests(){
        CaesarCipher cc = new CaesarCipher(18);
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        String decrypted = cc.decrypt(message);
        System.out.println(decrypted);
    }
    
    public void breakCaesarCipher(String input){
         CaesarBreaker cb = new CaesarBreaker();
         int key=cb.getKey(input);
         System.out.println("key :"+key);
         String decrypted=cb.decrypt(input);
         System.out.println(decrypted);
    }
}
