import javax.crypto.*;
import java.security.*;
import java.util.*;
public class DSA {

    public static void main(String[] args) throws Exception {
        try{
            KeyPairGenerator keygen  = KeyPairGenerator.getInstance("DSA");
            keygen.initialize(1024);
            KeyPair pair = keygen.generateKeyPair();
            
            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey =pair.getPrivate();
            
            String msg = "this is the secret massege";

            Signature sign = Signature.getInstance("SHA1withDSA");
            sign.initSign(privateKey);
            sign.update(msg.getBytes());
            byte[] signatureBytes = sign.sign();
            String encrypt = Base64.getEncoder().encodeToString(signatureBytes);
            System.out.println(encrypt);

            Signature verify = Signature.getInstance("SHA1withDSA");
            verify.initVerify(publicKey);
            verify.update(msg.getBytes());
            System.out.println(verify.verify(signatureBytes));


        }
        catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
        
    }
}