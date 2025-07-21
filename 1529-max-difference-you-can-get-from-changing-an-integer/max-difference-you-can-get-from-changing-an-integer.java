class Solution {
    public int maxDiff(int num) {
        int copyNum = num;
        int digits = (int) Math.log10(num) + 1; // num > 0 so safe

        int leftDigit = num / ((int) Math.pow(10,digits-1));

        int result = 0;

        while(digits-- > 0) {
            int divisor = ((int) Math.pow(10,digits));
            int currDigit = num / divisor;

            if(currDigit == leftDigit) {
                result += 8 * divisor;
            }

            num %= divisor;
        }

        if((leftDigit != 9 && leftDigit != 1) || copyNum < 10) return result;
        if(leftDigit == 1) return result + handleFirstDigitOne(copyNum);
        
        return result + handleFirstDigitNine(copyNum);
       
        

    }


    public int handleFirstDigitOne(int num) {
        
        int copyNum = num;
        int digits = (int) Math.log10(num) + 1; 
        int leftDigit = 1;

        while(digits-- > 0 && (leftDigit == 1 || leftDigit == 0)) {
            int divisor = ((int) Math.pow(10,digits));
            leftDigit = num / divisor;
            num %= divisor;
        }

        if(leftDigit == 1) return 0;
        

        num = copyNum;
        digits = (int) Math.log10(num) + 1; 
        int result = 0;

        while(digits-- > 0) {
            int divisor = ((int) Math.pow(10,digits));
            int currDigit = num / divisor;

            if(currDigit == leftDigit) {
                result += currDigit * divisor;
            }

            num %= divisor;
        }

        return result;
    }

    public int handleFirstDigitNine(int num) {
        int copyNum = num;
        int digits = (int) Math.log10(num) + 1; 
        int leftDigit = 9;

        while(digits-- > 0 && leftDigit == 9) {
            int divisor = ((int) Math.pow(10,digits));
            leftDigit = num / divisor;
            num %= divisor;
        }

        if(leftDigit == 9) return 0;
        
        

        num = copyNum;
        digits = (int) Math.log10(num) + 1; 
        int result = 0;

        while(digits-- > 0) {
            int divisor = ((int) Math.pow(10,digits));
            int currDigit = num / divisor;

            if(currDigit == leftDigit) {
                result += (9-leftDigit) * divisor;
            }

            num %= divisor;
        }

        return result;
       
    }
}