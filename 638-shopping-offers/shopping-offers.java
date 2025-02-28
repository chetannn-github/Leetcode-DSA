class Solution {
    int n;
Map<List<Integer>, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = price.size();
        return solve(price,special,needs);
    }

    public int solve(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }
        int min = Integer.MAX_VALUE;

        for(int i=0; i<special.size(); i++){
            boolean canTake = true;
            for(int j=0; j<n; j++){
                if(needs.get(j) < special.get(i).get(j)){
                    canTake = false;
                    break;
                }
            }
            if(canTake){
                List<Integer> newNeeds = new ArrayList<>(needs);
                for(int j=0; j<n; j++){
                    newNeeds.set(j,  needs.get(j) - special.get(i).get(j));
                }
                int specialOfferPrice = special.get(i).get(n);
                min = Math.min(specialOfferPrice + solve(price,special,newNeeds), min);
            }
        }
        int totalNormalPrice = 0;
        for(int i=0; i<n; i++){
            totalNormalPrice +=  ( price.get(i) * needs.get(i));  
        }
        min = Math.min(totalNormalPrice, min);
        dp.put(needs, min);
        return min;
    }

}