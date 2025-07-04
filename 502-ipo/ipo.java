class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        int n = profit.length;
        PriorityQueue<Pair> left = new PriorityQueue<>((a,b)->(b.profit - a.profit));
        PriorityQueue<Pair> right = new PriorityQueue<>((a,b)-> (a.capital - b.capital));
        
        for(int i=0; i<n;i++) {
            if(capital[i] > w) right.add(new Pair(profit[i], capital[i]));
            else left.add(new Pair(profit[i], capital[i]));
        }

        if(left.isEmpty()) return w;

        while(k-->0 ) {
            while(!right.isEmpty() && right.peek().capital <= w){
                left.add(right.remove());
            }
            if(!left.isEmpty()) w += left.remove().profit;
            else break;
        }

        return w;
}


}


class Pair {
    int profit,capital;
    Pair(int profit,int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}