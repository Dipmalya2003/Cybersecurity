import javax.crypto.*;
import java.security.*;
import java.util.*;
public class MD5 {
    public static void main(String[] args) {
        String plainText = "dipmalya";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashbyte = md.digest(plainText.getBytes());
            String encrypttext = Base64.getEncoder().encodeToString(hashbyte);
            
            System.out.println(encrypttext);
        }
        catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
        

        
    }
}
