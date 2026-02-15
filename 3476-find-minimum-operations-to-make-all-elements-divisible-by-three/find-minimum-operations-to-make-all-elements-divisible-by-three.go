func minimumOperations(nums []int) (result int) {
    for _,val := range nums {
        if val % 3 != 0 {
            result++;
        }
    }

    return;
}