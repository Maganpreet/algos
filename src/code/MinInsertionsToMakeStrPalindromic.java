package code;

public class MinInsertionsToMakeStrPalindromic {

    private static String[] tests = {"ABC", "AACECAAAA"};

    public static void main(String[] args) {
        for(String test : tests) {
            StringBuilder rev = new StringBuilder();
            rev.append(test);
            String fi = test+"$"+rev.reverse();
            int [] lps = KmpSubstringSearch.longSuffPre(fi, fi.length());

            System.out.println(test.length() - lps[fi.length()-1]);
            
        }
    }
    
}
