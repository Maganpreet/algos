package code;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {

    private static String testStr = "AACECAAAAB";

    private static String[] testArr = {"Aaaron","Adam","Camille","Erin","Camille","Adam","Aaaron","Ave","Ave"};

    public static void main (String[] args) {
        System.out.println(removeDup(testStr));
        String[] arr = removeDup(testArr);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }

    public static String removeDup (String str) {
        // space complexity: O(number of unique elements)
        // time complexity: O(n)
        int j = 0;
        StringBuilder sb = new StringBuilder(str);
        ArrayList<Character> visited = new ArrayList<>();
        visited.add(sb.charAt(0));
        for(int i=1; i<sb.length(); i++) {
            if(sb.charAt(j) != sb.charAt(i) && !visited.contains(sb.charAt(i))) {
                j++;
                sb.setCharAt(j,sb.charAt(i));
                visited.add(sb.charAt(j));
            }
        }

        return sb.toString().substring(0,j+1);
    }

    public static String[] removeDup (String[] arr) {
        // time complexity: O(n^2)
        int index = 0;
        for(int i=0; i< arr.length; i++){
            int j;
            for(j=0; j<i ; j++) {
                if( arr[i].equals(arr[j]) ) {
                    break;
                }
            }

            if ( j == i) {
                arr[index++] = arr[i];
            }
        }
        return Arrays.copyOf(arr,index);
    }
}
