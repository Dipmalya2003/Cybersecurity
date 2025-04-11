package input;

public class hill_cipher3x3 {
    static int[][] key={ {6, 24, 1},{13, 16, 10},{20, 17, 15}};
    static int detarminent(int[][] m){
        int det = m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
                -m[0][1] * (m[1][0]*m[2][2] - m[1][2]*m[2][0])
                +m[0][2] *(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
        return ((det%26)+26)%26;
    }
    static int modInv(int n){
        n = n%26;
        for(int i=1;i<26;i++){
            if ((n*i)%26 == 1) return i;
        }
        throw new ArithmeticException("No");
    }
    static int[][] inverseM(int[][] m){
        int det = detarminent(m);
        int detinv = modInv(det);

        int[][] inverse = new int[3][3];

        inverse[0][0] = m[1][1]*m[2][2] - m[1][2]*m[2][1];
        inverse[0][1] =-(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        inverse[0][2] = m[1][0]*m[2][1] - m[1][1]*m[2][0];
        inverse[1][0] = - (m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        inverse[1][1] = m[0][0]*m[2][2] - m[0][2]*m[2][0];
        inverse[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);
        inverse[2][0] = m[0][1]*m[1][2] - m[0][2]*m[1][1];
        inverse[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        inverse[2][2] = m[0][0]*m[1][1] - m[0][1]*m[1][0];

        int[][] adj = new int[3][3];
        for(int i=0 ;i<3;i++){
            for(int j=0;j<3;j++){
                adj[i][j] = (inverse[j][i] * detinv) % 26;
                if (adj[i][j] < 0) adj[i][j] += 26;
            }
        }
        return adj;
    }
    static int charToint(char ch){
        return ch-'a';
    }
    static char intTochar(int i){
        return (char)(i+'a');
    }
    static String applyMatrix(char a,char b,char c,int[][] m){
        int [] vec = {charToint(a),charToint(b),charToint(c)};
        StringBuilder sb = new StringBuilder();
        for(int i=0 ;i<3;i++){
            int val = 0;
            for(int j=0;j<3;j++){
                val += m[i][j] *vec[j];
            }
            sb.append(intTochar(val%26));
        }
        return sb.toString();
    }
    static String process(String text,int[][] key){
        text = text.toLowerCase().replaceAll("[^a-z]", "");
        if (text.length()%3 != 0) text+="x";
        StringBuilder result = new StringBuilder();
        for(int i=0 ;i<text.length();i+=3){
            result.append(applyMatrix(text.charAt(i), text.charAt(i+1), text.charAt(i+2), key));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String text = "hellohillcipher";
        System.out.println(process(text, key));
        
        
    }

}
