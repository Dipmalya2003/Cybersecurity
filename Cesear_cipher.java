public class Cesear_cipher{
    static String encrypt(String plaintext,int shift){
        StringBuilder result = new StringBuilder();
        for(char ch : plaintext.toCharArray()){
            if (Character.isUpperCase(ch)){
                char c = (char)(((ch-'A'+shift)%26)+'A');
                result.append(c);
            }
            else if(Character.isLowerCase(ch)){
                char c = (char)(((ch-'a'+shift)%26)+'a');
                result.append(c);
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }
    static String decrypt(String plaintext,int shift){
        return encrypt(plaintext, (26-shift)%26);
    }
    public static void main(String[] args) {
        String plaintext = "Dipmalya Datta";
        int shift = 3;
        System.out.println(encrypt(plaintext, shift));
        System.out.println(decrypt(encrypt(plaintext, shift), shift));
        
    }
}