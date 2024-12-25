import java.util.Stack;

public class MaximumNestingDepthParentheses {

    public static int maximumNestingDepthNaive(String str){
        int max = 0;

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                st.push(str.charAt(i));
                max = Math.max(max, st.size());
            }else if(str.charAt(i) == ')') {
                st.pop();
            }
        }

        return max;
    }

    public static int maximumNestingDepth(String str){
        int max = 0;
        int curr = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                curr++;
                max = Math.max(curr, max);
            }else if(str.charAt(i) == ')') {
                curr--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s =
                "(1+(2*3)+((8)/4))+1";

        System.out.println(maximumNestingDepth(s));
    }
}
