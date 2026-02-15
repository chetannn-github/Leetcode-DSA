func minOperations(nums []int, k int) int {
    sum := 0;
    for _,val := range nums {
        sum += val;
        fmt.Println(sum);
    }

    return sum % k;
}