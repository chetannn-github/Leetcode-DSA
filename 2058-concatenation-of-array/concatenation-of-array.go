func getConcatenation(nums []int) []int {
    n := len(nums);
    result := make([]int, 2*n);

    for idx,num := range nums {
        result[idx] = num;
        result[idx+n] = num; 
    }

    return result;
}