//ARGUMENT GUIDE:
//can be any number of strings of any length
// eg. args = {"a@'a)(  ---===23da ", "apple", "8245215378126"}

public class RunLengthEncoding {
    public static String RLEString(String str)
    {
        String s ="";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            s+=str.charAt(i);
            s+=count;
        }
        return s;
    }
    public static void main(String[] args){
        String words[] = {"AAAABBBBCCCCAABBCC", "AAAAA", "AABBABABA", "ABCABCABC"};
        if(args.length>0)
        {
            words = args;
        }
        for (int i = 0; i < words.length ; i++) {
            System.out.print(words[i]+" was compressed to ");
            System.out.println(RLEString(words[i]));
        }
    }
}
