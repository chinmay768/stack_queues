import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollisions {

    public static List<Integer> asteroidCollisions(int[]  arr){
        Stack<Integer> st = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0) st.push(arr[i]);
            else{
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])){
                    st.pop();
                }

                if(!st.isEmpty() &&  st.peek() == Math.abs(arr[i])){
                    st.pop();
                }else if(st.isEmpty() || st.peek() < 0){
                    st.push(arr[i]);
                }
            }
        }

        while (!st.isEmpty()){
            list.addFirst(st.pop());
        }
//        list.stream().mapToInt(i->i).toArray();
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 1, 2, -3, -7, 17, 15, -16};

        List<Integer> list = asteroidCollisions(arr);
        System.out.println(list);
    }
}
