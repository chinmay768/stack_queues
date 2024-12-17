import java.util.Stack;

public class RemoveKDigits {

    public static String removeLeadingZeroes(String num){
        for(int i=0;i<num.length();i++){

            if(num.charAt(i)!='0'){
                String res = num.substring(i);
                return res;
            }
        }
        return "0";
    }

    public static String removeKDigits(String num, int k){
        String res = "";
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++){
            while (!st.isEmpty() && k > 0 && (st.peek() - '0') > (num.charAt(i) - '0')){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while (k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        while (!st.isEmpty()){
            res = st.peek() + res;
            st.pop();
        }

        res = removeLeadingZeroes(res);

        return res;
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKDigits(num, k));
    }
}
