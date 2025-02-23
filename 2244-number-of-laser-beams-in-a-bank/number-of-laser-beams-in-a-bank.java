class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams=0;
        int prev=0;
        for(String st:bank){
            int cur=0;
            for(int i=0;i<st.length();i++){
                if(st.charAt(i)=='1'){
                    cur++;
                }
            }
            if(cur>0){
                totalBeams+=(prev*cur);
                prev=cur;
            }
        }
        return totalBeams;
    }
}