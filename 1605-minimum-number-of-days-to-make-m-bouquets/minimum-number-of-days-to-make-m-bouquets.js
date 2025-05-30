
var minDays = function(bloomDay, m, k) {
    if(m*k > bloomDay.length) return -1; 

    let start  = Math.min(...bloomDay);
    let end =  Math.max(...bloomDay);
    let ans = -7;

    while(start <= end){
        let mid = start + ((end - start) >> 1);

        if(checkPossible(bloomDay,m,k,mid)){
            ans = mid;
            end = mid-1;
        }else{
            start = mid+1;
        }
    }

    return ans;
    
};


let checkPossible = (bloomDay,m,k,day) =>{
    let temp= 0;
    for (let i = 0 ; i<bloomDay.length;i++){
        
        if(bloomDay[i]<=day){
            temp++;
            if(temp===k){temp=0;m--;}
        }else {temp = 0;}

       
        if(m===0){return true }
    }
    return false

}