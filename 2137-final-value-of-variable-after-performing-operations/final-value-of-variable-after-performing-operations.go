func finalValueAfterOperations(operations []string) (result int) {
    
    for _,op := range operations {
        if(op == "--X" || op == "X--") {
            result--;
        }else {
            result++;
        }
    }

    return;
}