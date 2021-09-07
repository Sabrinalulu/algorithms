import java.util.*;

public class circularPrinter {
    public static long solution(String seq){
        int sum = 0;

        HashMap<Character, Integer> mm = new HashMap<>();
        mm.put('A', 0);
        mm.put('B', 1);
        mm.put('C', 2);
        mm.put('D', 3);
        mm.put('E', 4);
        mm.put('F', 5);
        mm.put('G', 6);
        mm.put('H', 7);
        mm.put('I', 8);
        mm.put('J', 9);
        mm.put('K', 10);
        mm.put('L', 11);
        mm.put('M', 12);
        mm.put('N', 13);
        mm.put('O', -12);
        mm.put('P', -11);
        mm.put('Q', -10);
        mm.put('R', -9);
        mm.put('S', -8);
        mm.put('T', -7);
        mm.put('U', -6);
        mm.put('V', -5);
        mm.put('W', -4);
        mm.put('X', -3);
        mm.put('Y', -2);
        mm.put('Z', -1);
 
        char[] c = seq.toCharArray();
        int init = Math.abs(mm.get(c[0])); // start from a

        for(int i=1; i<c.length; i++){
            int prev = mm.get(c[i-1]);
            int cur = mm.get(c[i]);
            int diff = Math.abs(cur-prev);
            int compare = 26-diff;
            sum += Math.min(diff,compare);
        }
        // System.out.println(init);
        return (long)sum+init;

    }

    public static void main(String[] args){
        String seq = "UPM";
        System.out.println(solution(seq));
    }
    
}
