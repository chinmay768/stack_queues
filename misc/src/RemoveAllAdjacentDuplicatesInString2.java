import java.util.*;
public class RemoveAllAdjacentDuplicatesInString2 {

    public static String removeDuplicates(String s, int k) {
        // Initialize a stack to keep track of characters and their counts.
        Deque<int[]> stack = new ArrayDeque<>();

        // Loop through each character of the string.
        for (int i = 0; i < s.length(); ++i) {
            // Convert the character to an index (0 for 'a', 1 for 'b', etc.).
            int index = s.charAt(i) - 'a';

            if (!stack.isEmpty() && stack.peek()[0] == index) {
                stack.peek()[1] = (stack.peek()[1] + 1) % k;

                if (stack.peek()[1] == 0) {
                    stack.pop();
                }
            } else {
                stack.push(new int[] {index, 1});
            }
        }

        StringBuilder result = new StringBuilder();

        for (var element : stack) {
            char c = (char) (element[0] + 'a');
            for (int i = 0; i < element[1]; ++i) {
                result.append(c);
            }
        }

        result.reverse();

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";

        System.out.println(removeDuplicates(s, 2));
    }
}
