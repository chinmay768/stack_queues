import java.util.Stack;
import java.util.stream.Collectors;

public class RemovingStarsFromAString {

    public static String removeStars(String str){
        String res = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) != '*'){
                st.push(str.charAt(i));
            }else {
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        res = st.stream().map(s -> s.toString()).collect(Collectors.joining("")); // This reverses the stack so we don't need to do it explicitly

        return res;
    }

    public static void main(String[] args) {
        String str = "leet**cod*e";
        System.out.println(removeStars(str));
    }
}
