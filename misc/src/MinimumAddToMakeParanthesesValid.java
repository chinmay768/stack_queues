import java.util.Stack;

public class MinimumAddToMakeParanthesesValid {



    public static int minimumAddToMakeParanthesesValid(String str){
        int open = 0;
        int extraClosed = 0;
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                open++;
            }else {
                if(open == 0){
                    extraClosed++;
                }else {
                    open--;
                }
            }
        }

        return open + extraClosed;
    }

    public static void main(String[] args) {
        String str = "())";

        System.out.println(minimumAddToMakeParanthesesValid(str));
    }
}
