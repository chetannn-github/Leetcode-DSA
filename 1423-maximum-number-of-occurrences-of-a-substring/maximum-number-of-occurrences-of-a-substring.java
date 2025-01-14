class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // trick is that ki minimum size wale substrings hii max ho skte hh
        int n = s.length();
        int start = 0; 

        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<Character,Integer> freq = new HashMap<>();


        for(int end = 0; end<n; end++){
            char ch = s.charAt(end);

            freq.put(ch, freq.getOrDefault(ch,0)+1);

            while(freq.size()> maxLetters || end - start +1> minSize){
                char left = s.charAt(start);
                if(freq.get(left) ==1){
                    freq.remove(left);
                }else{
                    freq.put(left, freq.get(left)-1);
                }
                start++;
            }
            if(freq.size() <= maxLetters && end-start+1==minSize ){
                String st =  s.substring(start,end+1);
                System.out.println(st);
                hm.put(st, hm.getOrDefault(st,0)+1);
            }

        }
        int max = 0;
        for(String key : hm.keySet()){
            max = Math.max(max, hm.get(key));
        }
        return max;
    }
}