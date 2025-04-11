import java.util.*;
import java.math.*;
public class deffihellman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        BigInteger p = sc.nextBigInteger();
        BigInteger q = sc.nextBigInteger();

        BigInteger a = new BigInteger(p.bitLength()-1,rand);
        BigInteger b = new BigInteger(p.bitLength()-1,rand);

        BigInteger A = q.modPow(a, p);
        BigInteger B = q.modPow(b, p);

        BigInteger secretA = B.modPow(a, p);
        BigInteger secretB = A.modPow(b, p);

        System.out.println(secretA);
        System.out.println(secretB);
    }
}
