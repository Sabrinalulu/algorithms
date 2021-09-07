// For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)
// Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
// Input: str1 = "ABCABC", str2 = "ABC" Output: "ABC"
// Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB"
// Input: str1 = "ABCDEF", str2 = "ABC" Output: ""

public class greatest_common_divisor_of_strings {
    public static void divide(String s1, String s2){
        int index1 = 0;
        int index2 = 0;
        int short_len = 0;
        int short_ele = 0;
        if(s1.length()<s2.length()){
            short_len = s1.length();
            short_ele = 1;
        }else{
            short_len = s2.length();
            short_ele = 2;
        }

        for(int i=0; i<short_len; i++){
            if(short_ele==2){
                if(s2.charAt(i) == s1.charAt(i)){
                    index2 = check(i,i,s1,s2);
                }

            }else{
                if(s2.charAt(i) == s1.charAt(i)){
                    index1 = check(i,i,s1,s2);
                }
            }

        }
       
        if(short_ele==2) System.out.println(s2.substring(0,index2)); 
        if(short_ele==1) System.out.println(s1.substring(0,index1)); 
    }

    public static int check(int num1, int num2, String s1, String s2){
        int length = Math.min(s1.length(), s2.length());
        int idx1 = num1;
        int idx2 = num2;
        
        while(idx1<length || idx2<length){
            if(s1.charAt(idx1)==s2.charAt(idx2)){
                idx1++;
                idx2++;
            }else{
                break;
            }
        }

        return Math.min(idx1,idx2);

    } 

    public static String gcdOfStrings(String str1, String str2) {

        // if the str1 = "ABCD" and str2 ="ABC"
        // then str1 + str2 = "ABCDABC"
        // and str2 + str1 = "ABCABCD"
        // here both are not equal so simply return "".
        if(!((str1 + str2).equals(str2 + str1))){
            
            return "";
        }
        
        // if str1 == str2 return any one of the two strings
        // str1 = "ABC" and str2 = "ABC"
        else if(str1.equals(str2)){
            
            return str1;
        }
        
        // if str1 > str2 
        // str1 = "ABCABC" and str2 = "ABC"
        else if(str1.length() > str2.length()){
            
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        
        // if str1 < str2 
        // str2 = "ABCABC" and str1 = "ABC"
        else{
            
            return gcdOfStrings(str2.substring(str1.length()), str1);
        }
    }

    public static String solution(String str1, String str2) {
        String ans = "";
        // if longer string is str1 that means str1=str2+str2+...
        // so str1+str2 should equal to str2+str1
        // ex. s1=HAPPY,s2=TUESDAY ; s1=ABCDEF,s2=ABC
        if(!((str1+str2).equals(str2+str1))){
            ans = "";
            
        }else if((str1).equals(str2)){ // if two strings are the same
            ans = str1;
            
        // prune the repeated part
        }else if(str1.length()>str2.length()){ // if the length of str2 is shorter than str1
            ans = solution(str1.substring(str2.length()), str2);
            
        }else if(str1.length()<str2.length()){ // if the length of str1 is shorter than str2
            ans = solution(str2.substring(str1.length()), str1);
            
        }
        
        return ans;
    }

    public static void main(String args[]){
        String s1 ="ABCABC", s2="ABC";
        String s3 ="ABABAB", s4="AB";
        String s5 ="ABCDEF", s6="ABC";

        // divide(s1,s2);
        System.out.println("Test Case 1 Solution:"+solution(s1,s2));
        System.out.println("Test Case 2 Solution:"+solution(s3,s4));
        System.out.println("Test Case 3 Solution:"+solution(s5,s6));
    }
}