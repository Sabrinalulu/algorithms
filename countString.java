// string 
// aabbc
// a2b2c1
// aabba->a2b2a1
public class countString {

    public static String operation(String input){
        int count = 1;
        StringBuilder s = new StringBuilder();

        s.append(input.charAt(0));
        for(int i=1; i<input.length(); i++){
            
            if(input.charAt(i)!=input.charAt(i-1)){
                s.append(count); 
                s.append(input.charAt(i));
                count=1;
            }
            else{
                count++;
            }
            
            if(i==input.length()-1) s.append(count);
        }
        return s.toString();
    }

    public static void main(String[] args){
        String input = new String("aabbc");
        System.out.println(operation(input));
    }
    
}
