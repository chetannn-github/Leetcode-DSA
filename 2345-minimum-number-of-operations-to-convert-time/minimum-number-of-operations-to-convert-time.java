class Solution {
    public int convertTime(String current, String correct) {
        int currHour = (current.charAt(0) - '0')*10 + (current.charAt(1) - '0');
        int correctHour = (correct.charAt(0) - '0')*10 + (correct.charAt(1) - '0');
        int currMin = (current.charAt(3) - '0')*10 + (current.charAt(4) - '0');
        int correctMin = (correct.charAt(3) - '0')*10 + (correct.charAt(4) - '0');

        int diffHour = correctHour - currHour;

        int ops =  0;
        int diffMin = correctMin - currMin;

        if(diffMin < 0) {
            ops += diffHour - 1;
            diffMin += 60;
        }else{
            ops += diffHour;
        }
        

        while(diffMin > 0) {
            if(diffMin >= 15) {
                ops += diffMin / 15;
                diffMin = diffMin % 15;
                
            }else if(diffMin >= 5) {
                ops += diffMin / 5;
                diffMin = diffMin % 5;
                
            }else {
                ops += diffMin;
                diffMin = 0;
            }
        }
        return ops;

    }
}