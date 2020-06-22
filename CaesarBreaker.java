
import java.io.*;
import edu.duke.*;
import java.lang.*;

/**
 * Write a description of CaesarBreaker here.
 * 
 * @author Anirudh Maheshwari 
 * @version 1.0
 */
public class CaesarBreaker {
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
    
    public String decrypt(String encrypted){
         
         int[] freqs  = countLetters(encrypted);
         int maxDex  = maxIndex(freqs);
         //System.out.println(maxDex);
         //position of 'e' most frequent
         int dkey = maxDex-4;
         if (maxDex< 4){
            dkey = 26 - (4-maxDex);
            }
         CaesarCipher cc = new CaesarCipher(26-dkey);   
         //System.out.println(cc.encrypt(encrypted));   
         return cc.encrypt(encrypted);
    }
    
    public String halfOfString(String message,int start){
       StringBuilder s = new StringBuilder("");
       for(int i=0;i<message.length();i++){
          if(i%2==start)
           s.append(message.charAt(i));
       }
       return s.toString();
    }
    
    public int getKey(String s){
       int[] freqs  = countLetters(s);
       //for(int i=0;i<26;i++)
         //    System.out.println(i+" : "+freqs[i]);
       int maxDex  = maxIndex(freqs);
       //System.out.println(maxDex);
       int dkey = maxDex-4;
       if (maxDex< 4){
            dkey = 26 - (4-maxDex);
        }
       return dkey;
    }
    
    public String decryptTwoKeys(String encrypted){
      String s1=halfOfString(encrypted,0);
      String s2=halfOfString(encrypted,1);
      int key1=getKey(s1);
      int key2=getKey(s2);
      System.out.println("Key1 : "+key1+" and key2 : "+key2);
      CaesarCipherTwo cc = new CaesarCipherTwo(26-key1,26-key2);
      System.out.println(cc.encrypt(encrypted));
      return cc.encrypt(encrypted);//cc.encryptTwoKeys(encrypted,26-key1,26-key2);
    }
}    
