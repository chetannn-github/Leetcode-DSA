class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue= new LinkedList<>();

        for(int i=1; i<=n; i++){
            queue.add(i);
        }

        while(true){
            for(int i=1;i<k; i++){
                queue.add(queue.remove());
            }
            if(queue.size()!=1){
                queue.remove();
            }
            
            if(queue.size()==1 ){
                break;
            }
        }

        return queue.peek();
    }
}

// class Solution {
//     public int findTheWinner(int n, int k) {
//         int winner=0;
//         for (int i = 1; i <= n; i++) {
//             winner = (winner + k) % i;
//         }
//         return winner + 1;
//     }
// }