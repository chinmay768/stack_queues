import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Stack;

public class MaximumNestingDepthTwoValidParenthesesStrings {

    public static int[] maxNestingDepthTwoVPAStrings(String str){
        int[] maxNesting = new int[str.length()];
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                if(st1.size() <= st2.size()){
                    st1.push(str.charAt(i));
                    maxNesting[i] = 0;
                }else {
                    st2.push(str.charAt(i));
                    maxNesting[i] = 1;
                }
            }else{
                if(st1.size() >= st2.size()){
                    st1.pop();
                    maxNesting[i] = 0;
                }else{
                    st2.pop();
                    maxNesting[i] = 1;
                }
            }
        }

        return maxNesting;
    }

    public static void main(String[] args) {
        String str = "(()())";
        System.out.println(Arrays.toString(maxNestingDepthTwoVPAStrings(str)));
    }
}
