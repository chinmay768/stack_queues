import java.util.*;

public class StockSpan {
    class Pair {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
   Stack<Pair> stack;

//   List<Integer> list;
    public StockSpan() {
//        list = new ArrayList<>();
        stack = new Stack<>();
    }

//    Brute Force With List
//    public int next(int price) {
//        list.add(price);
//        int count = 1;
//
//        for(int i = list.size() - 2; i > 0; i--){
//            if(list.get(i) <= price ) count++;
//            else break;;
//        }
//
//        return count;
//    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().value <= price)
            span += stack.pop().idx;
        stack.push(new Pair(price, span));
        return span;
    }
}

