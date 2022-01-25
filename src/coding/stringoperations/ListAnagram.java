package coding.stringoperations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAnagram {
    public static void main(String[] args) {
        String[] ars = {"eat","tea","tan","ate","nat","bat"};
        Map<Integer, List<String>> outputMap = new HashMap<>();

        int count = 0;
        int[] visited = new int[ars.length];
        for(int i = 0; i < ars.length;i++) {
            if(visited[i]!=0) {
                continue;
            }
            List<String> out = new ArrayList<>();
            out.add(ars[i]);

            for(int j = i+1; j < ars.length;j++) {
                if(checkAnagram(ars[i],ars[j])) {
                    out.add(ars[j]);
                    visited[j]++;
                }
            }
            outputMap.put(count++,out);
        }
        System.out.println(outputMap.values());
    }

    public static boolean checkAnagram(String s1, String s2) {
        int[] a = new int[26];
        int[] b = new int[26];
        if(s1.length() != s2.length())
            return false;

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            a[c-'a']++;
        }
        for(int i = 0; i< s2.length(); i++) {
            char c = s2.charAt(i);
            b[c-'a']++;
        }
        boolean flag = true;
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
