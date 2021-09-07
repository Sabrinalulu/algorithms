// Given a string and find the length of the longest substring without repeating characters.
// "abcabcbb"=>3; "bbbbb"=>1; "pwwkew"=>3
import java.util.HashMap;
public class longestSubstring_{

    public static void main(String args[]){
        String s = "pwwkew";
        longestSubstring_ output = new longestSubstring_();
        System.out.println(output.lengthOfLSS(s));
    }

    public int lengthOfLSS(String s){
        // character: charAt; integer: length of substring
        HashMap<Character, Integer> m = new HashMap<>();
        int ans = 0;
        
        for(int i=0, j=0; j<s.length(); j++){
            if(m.containsKey(s.charAt(j))){
                i = Math.max(m.get(s.charAt(j)),i);
            }
            ans = Math.max(j-i+1,ans);
            m.put(s.charAt(j),j+1);
        }

        return ans;
    }

}
