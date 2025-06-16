class Solution {
    public boolean validUtf8(int[] data) {
        // ese smjo peeche senapti aaege as per power of king
        int n = data.length;
        int senapatiNeeded = 0;

        for(int d : data) {
            int kingType = findKingType(d);
            if(d > 247) return false;
            else if(kingType == 0) {
                if(senapatiNeeded == 0) return false;
                else senapatiNeeded--;
            }else if(kingType != 0 && senapatiNeeded != 0) return false;
            else senapatiNeeded += kingType - 1;
        }

        return senapatiNeeded == 0;
    }

    public int findKingType (int num) {
        if(num >= 0 && num <= 127) return 1;
        else if (num >= 192 && num <= 223) return 2;
        else if (num>=224 && num <= 239) return 3;
        else if (num >=240 && num <=247) return 4;
        else return 0;
    }

    
}