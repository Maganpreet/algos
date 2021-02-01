package code;
public class KmpSubstringSearch {

    KmpSubstringSearch(){

    }
    public static int[] longSuffPre(String pattern, int patternSize){
        int[] lps = new int[patternSize];
        int i=0,j=1;
        while( j < pattern.length()){
            //System.out.println(pattern.charAt(i) +" "+ pattern.charAt(j));
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[j] = i + 1;
                i++;
            }else {
                if(i != 0) {
                    i = lps[i - 1];
                    j--;
                }
            }
            j++;
        }
        return lps;
    }
    public static void main(String[] args){
        String[] texts = {"abcxabcdabxabcdabcdabcy","adsgwadsxdsgwadsgz"};
        String[] pats = {"abcdabcy","dsgwadsgz"/*"aabaabaaa"*/};
        int i = 0;
        for(String text : texts){
            String pattern = pats[i++];
            //System.out.println(pattern);
            int[] lps = longSuffPre(pattern,pattern.length());
            System.out.println(pattern +" exists in "+text+" at index "+substringSearch(text,pattern,lps));
        }
        //System.out.println("working");
    }

    private static int substringSearch(String text, String pattern, int[] lps){
        int index = -1;
        int flag = 0;
        int i,j;
        for(i=0,j=0;i<text.length();){
            //System.out.println(text.charAt(i)+" "+ pattern.charAt(j));
            if( text.charAt(i) != pattern.charAt(j) ){
                //System.out.println(text.charAt(i)+" "+ pattern.charAt(j));
                if( j != 0 ) {
                    j = lps[j-1];
                    flag = 0;
                }else if(flag == 0){
                    i++;
                }
            }
            if ( text.charAt(i) == pattern.charAt(j) ) {
                flag = 1;
                index = i - j;
                i++;
                j++;
            }
        }


        return j==pattern.length() ? index : -1;
    }

    private static boolean prefixExists(int[] lps, int index) {
        if( index != 0 && lps[index-1] != 0 ) {
            return true;
        }
        return false;
    }
}
