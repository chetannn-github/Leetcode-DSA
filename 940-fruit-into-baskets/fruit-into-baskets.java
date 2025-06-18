class Solution {
    public int totalFruit(int[] fruits) {
        // humee esi max length ki subarray btani hh jisme 2 distinct elements ho

        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = fruits.length;
        int max = 0;
        int start = 0;
        
        for(int end =0; end<n; end++) {
            hm.put(fruits[end],hm.getOrDefault(fruits[end],0)+1);

            while(hm.size()>2) {
                if(hm.get(fruits[start])>1) {
                    hm.put(fruits[start],hm.get(fruits[start])-1);
                }else {
                    hm.remove(fruits[start]);
                }

                start++;
            }

            max = Math.max(end-start+1, max);

        }

        return max;
    }
}