import javax.crypto.*;
import java.security.*;
import java.util.*;
public class SHA_1 {
    public static void main(String[] args) {
        String plaintext = "Dipmalya";

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashbytes = md.digest(plaintext.getBytes());
            String encryptText = Base64.getEncoder().encodeToString(hashbytes);
            System.out.println(encryptText);
        }
        
        catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
    }
}
