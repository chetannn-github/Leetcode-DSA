function sortArrayByParityII(nums: number[]): number[] {
    let even : number = 0;
    let odd : number = 1;
    let n : number = nums.length;

    while(even < n && odd < n) {
        if(nums[even] % 2 === 0) even += 2;
        else if(nums[odd] % 2 === 1) odd += 2;
        else {
            nums[even] = nums[even] ^ nums[odd];
            nums[odd] = nums[even] ^ nums[odd];
            nums[even] = nums[even] ^ nums[odd];
        }
    }

    return nums;
};