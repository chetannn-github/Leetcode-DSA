class Solution {
    int MOD = 1_000_000_007;
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<Pair> buy = new PriorityQueue<>((a,b)->(b.price - a.price));
        PriorityQueue<Pair> sell = new PriorityQueue<>((a,b)->(a.price - b.price));
        long currBackLogs = 0;

        for(int[] order : orders) {
            int currOrderPrice = order[0];
            int currOrderQuantity = order[1];
            int currOrderType = order[2];
            // buy
            if(currOrderType == 0) {
                while(currOrderQuantity > 0 && !sell.isEmpty() && sell.peek().price <= currOrderPrice) {
                    int sellQuantity = sell.peek().quantity;
                    int sellPrice = sell.remove().price;
                    currBackLogs -= sellQuantity;

                    if(sellQuantity >= currOrderQuantity) {
                        currBackLogs += (long) (sellQuantity - currOrderQuantity);
                        
                        if(sellQuantity != currOrderQuantity) {
                            sell.add(new Pair(sellPrice,sellQuantity - currOrderQuantity));
                        }
                        currOrderQuantity = 0;

                        
                    }else {
                        currOrderQuantity -= sellQuantity ;
                    }
                }

                if(currOrderQuantity > 0) {
                    buy.add(new Pair(currOrderPrice, currOrderQuantity));

                    currBackLogs += (long) (currOrderQuantity) ;
                }
            } else {
                while(currOrderQuantity > 0 && !buy.isEmpty() && buy.peek().price >= currOrderPrice) {
                    int buyQuantity = buy.peek().quantity;
                    int buyPrice = buy.remove().price;
                    currBackLogs -= buyQuantity;

                    if(buyQuantity >= currOrderQuantity) {
                        currBackLogs += (long) (buyQuantity - currOrderQuantity) ;
                        if(buyQuantity != currOrderQuantity) {
                            buy.add(new Pair(buyPrice,buyQuantity - currOrderQuantity));
                        }
                        currOrderQuantity = 0;
                       

                    }else {
                        currOrderQuantity -= buyQuantity ;
                    }
                }

                if(currOrderQuantity > 0) {
                    sell.add(new Pair(currOrderPrice, currOrderQuantity));

                    currBackLogs += (long) (currOrderQuantity);
                    
                }
            }
        }

        return (int)(currBackLogs % MOD) ;
    }
}

class Pair {
    int price, quantity;

    Pair(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}