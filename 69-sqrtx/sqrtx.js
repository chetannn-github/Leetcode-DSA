var mySqrt = function(x) {
    let start = 0, ans = 1, end = x;
    while(start<=end){
        let mid = start + ((end-start)>>1);
        let prod = mid * mid;
        if(prod < x){
            ans = mid;
            start = mid+1;
        }else if (prod > x){
            end = mid-1;
        }else return mid;
    }
    return ans;
};