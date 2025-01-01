class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int max = 1;
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=0; i<word.length(); i +=k ){
            StringBuilder temp = new StringBuilder();

            for(int j = i, count = 0; count <k ; j++, count++){
                temp.append(word.charAt(j));  
            }
            String chunk = temp.toString();
            int freq =  hm.getOrDefault(chunk,0);
            hm.put(chunk, freq+1);
            max = Math.max(max,freq+1);
        }
        
        return ((word.length()/k) - max );
    }
}