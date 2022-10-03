//Language JAVA
/*
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character, but a character may map to itself.
 */

/*
 *input 1:
 egg
 add
 *output 1:
 true

 *input 2:
 egg
 beb
 *output 2:
 false
*/

import java.util.*;

class IsomorphicStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Enter strings
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] mapping_dic_t = new int[256];
        Arrays.fill(mapping_dic_t, -1);
        int[] mapping_dic_s = new int[256];
        Arrays.fill(mapping_dic_s, -1);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapping_dic_t[c1] == -1 && mapping_dic_s[c2] == -1) {
                mapping_dic_t[c1] = c2;
                mapping_dic_s[c2] = c1;
            } else if (!(mapping_dic_t[c1] == c2 && mapping_dic_s[c2] == c1))
                return false;

        }
        return true;
    }
}