class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        for(String word : words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(hm.get(a) != hm.get(b)) return hm.get(b) - hm.get(a);
            int l1 = a.length();
            int l2 = b.length();
            for(int i=0; i<l1 && i<l2; i++){
                if(a.charAt(i) != b.charAt(i)){
                    return a.charAt(i)-b.charAt(i);
                }
            }

            return a.length() - b.length();
        });

        for(String word : words){
            if(hs.contains(word)) continue;
            pq.add(word);
            hs.add(word);
        }

        List<String> ans = new ArrayList<>();
        
        while(k--!=0){
            ans.add(pq.remove());
        }

        return ans;
    }
}