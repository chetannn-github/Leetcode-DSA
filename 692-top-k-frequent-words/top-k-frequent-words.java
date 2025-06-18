class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();

        for(String word : words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(hm.get(a) != hm.get(b)) return hm.get(a) - hm.get(b);
            int l1 = a.length();
            int l2 = b.length();

            for(int i=0; i<l1 && i<l2; i++){
                if(a.charAt(i) != b.charAt(i)){
                    return b.charAt(i)-a.charAt(i);
                }
            }

            return l2 - l1;
        });

        for(String key : hm.keySet()){
            pq.add(key);
            if(pq.size() > k) pq.remove();
            
        }

        List<String> result = new ArrayList<>();
        
        while(k--!=0){
            result.add(pq.remove());
        }
        int n = result.size();
        for (int i = 0; i <  n/ 2; i++) {
            String temp = result.get(i);
            result.set(i, result.get(n - 1 - i));
            result.set(n - 1 - i, temp);
        }
        return result;
    }
}