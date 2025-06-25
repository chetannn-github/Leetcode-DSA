function maxSatisfied(customers: number[], grumpy: number[], minutes: number): number {
    let result : number = 0;
    let n = customers.length;

    for(let i=0; i<n; i++) {
        result += ((1- grumpy[i]) * customers[i]);
    }

    let start : number = 0;
    let maxSum = 0;
    let sum = 0;

    for(let end:number = 0; end<n; end++) {
        sum += (grumpy[end]) * customers[end];

        while(end - start + 1 > minutes) {
            sum -= (grumpy[start]) * customers[start];
            start++;
        }

        maxSum = Math.max(sum, maxSum);
    }

    return maxSum + result;
};