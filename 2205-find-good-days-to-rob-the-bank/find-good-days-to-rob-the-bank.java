class Solution{
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList();
        
        int dec[] = new int[security.length];
        int inc[] = new int[security.length];
        
        int count = 0;
        for(int i = 0;i<security.length-1;i++){
            if(security[i] >= security[i+1]){
                dec[i+1] = ++count;
            }else{
                count= 0;
                dec[i+1] = count;
            }
        }
        
        count = 0;
        for(int i=security.length-2; i>= 0;i--){
            if(security[i] <= security[i+1]){
                inc[i] = ++count;
            }else{
                count= 0;
                inc[i] = count;
            }
        }
        
        
        for(int i = 0;i<security.length;i++){
            if(inc[i] >= time && dec[i] >= time){
                list.add(i);
            }
        }
 
        return list;

    }
}
