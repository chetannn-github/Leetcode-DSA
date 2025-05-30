
var smallestDivisor = function(nums, threshold) {
    let start = 1;
    let end = Math.max(...nums);
    let ans ;
    while(start<= end){
        let mid = start + Math.floor((end-start)/2);
        if(checkSum(nums,threshold , mid)){
            ans = mid;
            end = mid-1;
        }else{
            start = mid+1;
        }
    }
    return ans
};

let checkSum =(nums,threshold,div)=>{
    let sum = 0;
    for (let  i = 0;i<nums.length;i++){
        sum += Math.ceil(nums[i]/div);
        if(sum>threshold){return false}
    }
    return true
    
}