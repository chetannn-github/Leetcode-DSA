func scoreOfString(s string) (result int) {
    result = 0;
    
    for i :=1; i < len(s); i++  {
        diff := int(s[i]) - int(s[i-1]);

        result += int(math.Abs(float64(diff)));
    }

    return ;
}