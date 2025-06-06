// class StockSpanner {
//     List<Integer> st;
//     int size = 0;

//     public StockSpanner() {
//         this.st = new ArrayList<>();
//     }
    
//     public int next(int price) {
//         st.add(price);
//         size++;
//         int count = 0;

//         for(int i= size-1; i>=0; i--){
//             if(price < st.get(i)) break;
//             count++;
//         }

//         return count;
        
//     }
// }


class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.pop()[1];
        }

        st.push(new int[]{price, span});
        return span;
    }
}
