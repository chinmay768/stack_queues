import java.util.Stack;
import java.util.stream.Collectors;

public class MakeTheStringGreat {

    public static String makeStringGreatNaive(String str){
        String res = "";
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(!st.isEmpty() && st.peek() != str.charAt(i) && Character.toLowerCase(st.peek()) == Character.toLowerCase(str.charAt(i))){
                st.pop();
            }else {
                st.push(str.charAt(i));
            }
        }

        res = st.stream().map(s -> s.toString()).collect(Collectors.joining(""));
        return res;
    }

    public static String makeStringGreat(String str){
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()){
            if(!sb.isEmpty() && Math.abs(sb.charAt(sb.length() - 1) - ch) == 32){
                sb.deleteCharAt(sb.length() - 1);
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "leEeetcode";
        System.out.println(makeStringGreat(str));
    }
}
