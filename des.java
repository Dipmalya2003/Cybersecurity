import javax.crypto.*;


import java.util.*;

public class des {
    public static void main(String[] args) throws Exception{
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keygen.generateKey();
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        String plaintext = "Dipmalya Datta";
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptBytes = cipher.doFinal(plaintext.getBytes());
        String encrytText = Base64.getEncoder().encodeToString(encryptBytes);
        System.out.println(encrytText);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(encrytText));
        String decryptText = new String(decryptBytes);
        System.out.println(decryptText);

        
    }
}
