class Solution {
    public int bestClosingTime(String customers) {
        // jis time pr shop band krr rhe hoo uss time se lekrrr y count krlooo and phele wale n
        int totalY = 0;
        int n = customers.length();

        for(int i= 0; i<n;i++){
            if(customers.charAt(i) =='Y'){ totalY++;}   
        }

        int preY = 0;
        int preN =0;
        int minPenalty = totalY;
        int closingHour = 0;

        for(int i= 0; i<n; i++){
           int  penalty = totalY - preY + preN;
            if(penalty < minPenalty){
                minPenalty = penalty;
                closingHour = i;
            }

            if (customers.charAt(i) =='Y') preY++ ; 
            else preN++;
        }
        
        if(preN < minPenalty) closingHour = n;

        return closingHour;
    }
}