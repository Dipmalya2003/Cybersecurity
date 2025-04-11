package input;

public class hill_Cipher {
    static int[][] key={{3,3},{2,5}};
    static int determinent(int [][] matrix){
        return (matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0])%26;
    }
    static int modInv(int n){
        n = n% 26;
        for(int i=1;i<26;i++){
            if((n*i)%26 == 1) return i;
        }
        throw new ArithmeticException("no");
    }
    static int[][] inverseM(int[][] matrix){
        int det = determinent(matrix);
        int invdet = modInv(det);

        int[][] inverse = new int[2][2];

        inverse[0][0] = matrix[1][1];
        inverse[0][1] = - matrix[0][1];
        inverse[1][0] = - matrix[1][0];
        inverse[1][1] = matrix[0][0];

        for(int i =0 ;i<2;i++){
            for(int j=0;j<2;j++){
                inverse[i][j] = (inverse[i][j]*invdet)%26;
                if (inverse[i][j] < 0) inverse[i][j] += 26;
            }
        }
        return inverse;
    }
    static int charToint(char ch){
        return ch-'a';
    }
    static char intTochar(int i){
        return (char)(i+'a');
    }
    static String applyMatrix(char a,char b,int[][] matrix){
        int x = charToint(a);
        int y = charToint(b);

        int c1 = (matrix[0][0]*x + matrix[0][1]*y)%26;
        int c2 = (matrix[1][0]*x + matrix[1][1]*y)%26;

        return ""+intTochar(c1)+intTochar(c2);
    } 
    static String process(String text, int [][] key){
        text = text.toLowerCase().replaceAll("[^a-z]", "");
        if (text.length()%2 != 0) text+="x";
        StringBuilder result = new StringBuilder();
        for(int i=0 ;i<text.length();i+=2){
            result.append(applyMatrix(text.charAt(i), text.charAt(i+1), key));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String text = "hello";
        String encrypted = process(text, key);
        String decrypted = process(encrypted, key);
        System.out.println("Original: "+text);
        System.out.println("Encrypted: "+encrypted);
        System.out.println("Decrypted: "+decrypted);
        
    }
}