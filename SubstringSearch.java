//ARGUMENT GUIDE
//takes two strings of any length as an array
//the 0th index is the text it will search, the 1st is the pattern it will search for
//eg. args={"THIS IS WHAT I SHALL SEARCH", "SEA"}

public class SubstringSearch {
    public static void main(String[] args){
        String txt = "HELLO THIS IS A SENTENCE";
        String pat = "THIS";
        if(args.length==2)
        {
            txt = args[0];
            pat = args[1];
        }
        System.out.println("Text is: "+txt);
        long startTime = System.nanoTime();
        int bf = BruteForce(pat, txt);
        long endTime = System.nanoTime();
        long TimeTaken = endTime - startTime;
        if (bf==-1)
        {
            System.out.println("Brute Force did not find the pattern. Time: "+TimeTaken);
        }
        else{
            System.out.println("Brute Force found '"+pat+"' at index "+bf+". Time: "+TimeTaken);
        }
        startTime = System.nanoTime();
        int kmp = KMPSearch(pat, txt);
        endTime = System.nanoTime();
        TimeTaken = endTime - startTime;
        if (kmp==-1)
        {
            System.out.println("KMPSearch did not find the pattern. Time: "+TimeTaken);
        }
        else{
            System.out.println("KMPSearch found '"+pat+"' at index "+kmp+". Time: "+TimeTaken);
        }
    }

    public static int BruteForce(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        for (int pos = 0; pos < n - m + 1; pos++) {
            if (CharSequence.compare(txt.substring(pos, pos+m), pat)==0)
            {
                return pos;
            }
        }
        return -1;
    }

    public static int KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0; // index for pat[]
        computeLPSArray(pat, M, lps);
        int i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return i - j;
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0){
                    j = lps[j - 1];
                }
                else{
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    public static void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}