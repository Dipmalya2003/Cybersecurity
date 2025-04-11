public class viginer {
    static String encrypt(String plaintext,String key){
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int idx =0;
        for(char ch : plaintext.toCharArray()){
            int shift = key.charAt(idx%key.length())-'a';
            if(Character.isUpperCase(ch)){
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

    static String decrypt(String plaintext,String key){
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int idx =0;
        for(char ch : plaintext.toCharArray()){
            int shift = key.charAt(idx%key.length())-'a';
            if(Character.isUpperCase(ch)){
                char c = (char)(((ch-'A'-shift+26)%26)+'A');
                result.append(c);
            }
            else if(Character.isLowerCase(ch)){
                char c = (char)(((ch-'a'-shift+26)%26)+'a');
                result.append(c);
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();

    }


    public static void main(String[] args) {
        String plaintext = "Dipmalya Datta";
        String key = "hello";
        System.out.println(encrypt(plaintext, key));
        System.out.println(decrypt(encrypt(plaintext, key), key));
    }
}
