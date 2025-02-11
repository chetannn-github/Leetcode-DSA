class Solution {
    public int bestClosingTime(String customers) {
        // jis time pr shop band krr rhe hoo uss time se lekrrr y count krlooo and phele wale n
        int totalY = 0;
        for(int i= 0; i<customers.length();i++){
            if(customers.charAt(i) =='Y'){ totalY++;}   
        }

        int preY = 0;
        int preN =0;
        int minPenalty = totalY;
        int closingHour = 0;

        for(int i= 0; i<customers.length();i++){
           int  penalty = totalY - preY + preN;
            if(penalty < minPenalty){
                 minPenalty = penalty;
                 closingHour = i;
            }

            if(customers.charAt(i) =='Y'){ preY++;}   
            else{preN++;}
        }
        
        if(preN<minPenalty){closingHour = customers.length();}


        
        return closingHour;
    }
}