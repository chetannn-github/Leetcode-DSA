function maxFrequency(nums: number[], k: number): number {
    nums.sort((a,b)=> (a-b));

    let result : number = 1;
    let start : number = 0;
    let sum : number = 0;
    let n : number = nums.length;

    for(let end = 0; end < n; end++) {
        sum += nums[end];

        while(nums[end] * (end - start + 1)  - sum > k) {
            sum -= nums[start++];
        }

        result = Math.max(result,end-start+1);
    }


    return result;
};