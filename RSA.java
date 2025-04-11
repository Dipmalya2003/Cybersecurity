import java.util.*;
import java.math.*;
public class RSA {
    static int gcd(int a,int b){
        while (b!= 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    static int modInv(int e,int phi){
        for(int d=1;d<phi;d++){
            if ((e*d)%phi == 1) return d;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();

        int n = p*q;
        int phi = (p-1)*(q-1);

        int e =3;
        while(gcd(e, phi) != 1){
            e++;
        }

        int d = modInv(e, phi);

        System.out.println("Public: "+e+" "+n);
        System.out.println("Private: "+d+" "+n);

        BigInteger n1 = BigInteger.valueOf((long)n);
        BigInteger e1 = BigInteger.valueOf((long)e);
        BigInteger d1 = BigInteger.valueOf((long)d);
        BigInteger msg = sc.nextBigInteger();

        BigInteger encryptdata = msg.modPow(e1, n1);
        BigInteger decryptdata = encryptdata.modPow(d1,n1);

        System.out.println(encryptdata);
        System.out.println(decryptdata);

        
    }
}
