class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int numLine[] = new int[n+1];

        for(int i=0;i<shifts.length; i++){
            if(shifts[i][2] == 0){
                numLine[shifts[i][0]]--;
                numLine[shifts[i][1]+1]++;
            }else{
                numLine[shifts[i][0]]++;
                numLine[shifts[i][1]+1]--;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            if(i!=0) numLine[i] += numLine[i-1];

            char ch = s.charAt(i);
            ch =(char) (( ch -'a' + (numLine[i] %26) +26 ) % 26 + 'a');
            sb.append(ch);
        }

        return sb.toString();
    }
}