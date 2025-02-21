
var maxProfit = function(prices) {
   

    let buyPrice = prices[0];
    let maxProfit = 0;

    for(let i = 1 ; i<prices.length; i++ ){
        profit = 0;
        if(prices[i]>buyPrice){
            profit = prices[i] -  buyPrice;
            maxProfit = profit>maxProfit? profit : maxProfit;
         }
         else {
            buyPrice = prices[i];
         }

    }
    return maxProfit
};