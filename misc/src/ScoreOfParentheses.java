import java.util.Stack;

public class ScoreOfParentheses {

    public static int scoreOfParanthesesNaive(String str){
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                st.push(score);
                score = 0;
            }else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }

    public static int scoreOfParentheses(String str){
        int depth = 0;
        int res = 0;

        char prev = '(';
        for (char ch : str.toCharArray()){
            if(ch == '('){
                depth++;
            }else {
                depth--;
                if(prev == '('){
                    res += Math.pow(2, depth);
                }
            }
            prev = ch;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "()()";

        System.out.println(scoreOfParentheses(str));
    }
}
