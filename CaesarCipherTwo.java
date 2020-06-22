 
import java.util.*;
import java.io.*;
import edu.duke.*;
import java.lang.*;

/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author Anirudh Maheshwari 
 * @version 1.0
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainkey1,mainkey2;
    public CaesarCipherTwo(int key1,int key2){
       mainkey1=key1;
       mainkey2=key2;
       alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       shiftedAlphabet1=alphabet.substring(key1)+
        alphabet.substring(0,key1);
       shiftedAlphabet2=alphabet.substring(key2)+
        alphabet.substring(0,key2); 
    }

    public String encrypt(String input){
       StringBuilder encrypted = new StringBuilder(input);
        
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar;
            if(Character.isLetter(encrypted.charAt(i)))
               currChar = Character.toUpperCase(encrypted.charAt(i));
            else
               currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar;
                if(i%2==0)
                    newChar = shiftedAlphabet1.charAt(idx);
                else 
                    newChar = shiftedAlphabet2.charAt(idx);
                //Replace the ith character of encrypted with newChar
                if(Character.isLowerCase(encrypted.charAt(i)))
                    newChar=Character.toLowerCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        System.out.println(encrypted.toString());
        return encrypted.toString();     
    }
    
    public String decrypt(String input){
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainkey1,26-mainkey2);
        return cc.encrypt(input);
    }
}
