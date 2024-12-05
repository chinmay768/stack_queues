import java.util.Arrays;
import java.util.Stack;

public class CheckForBalancedParantheses {

    public static boolean checkBalancedParantheses(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if(Arrays.asList('(', '{', '[').contains(str.charAt(i))){
                stack.push(str.charAt(i));
            }else{
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(top == '(' && str.charAt(i) != ')' ||
                        top == '{' && str.charAt(i) != '}' ||
                        top == '[' && str.charAt(i) != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(checkBalancedParantheses(str));
    }
}
