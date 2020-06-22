
import java.io.*;
import edu.duke.*;
import java.lang.*;

public class CaesarCipher{
    private String alphabet;
    private String shiftedAlphabet;
    private int mainkey;
    public CaesarCipher(int key){
       mainkey=key;
       alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       shiftedAlphabet=alphabet.substring(key)+
        alphabet.substring(0,key);
    }
    
    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        //String shiftedAlphabet = alphabet.substring(key)+
        //alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar;
            if(Character.isLetter(encrypted.charAt(i)))
               currChar = Character.toUpperCase(encrypted.charAt(i));
            else
               currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            //System.out.println(currChar);
            int idx = alphabet.indexOf(currChar);
            //System.out.println(currChar+" "+idx);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                //System.out.println(currChar+" "+idx+" "+);
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
        CaesarCipher cc = new CaesarCipher(26 - mainkey);
        return cc.encrypt(input);
    }
    
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
         CaesarCipher cc = new CaesarCipher(7);
         System.out.println(cc);
       // String encrypted = encrypt(message, key);
        //System.out.println(encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
       // System.out.println(decrypted);
    }
}

