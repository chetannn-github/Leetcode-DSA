class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int n = barcodes.length;
        for(int barcode : barcodes) {
            freq.put(barcode, freq.getOrDefault(barcode,0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (freq.get(b) - freq.get(a)));

        for(int key : freq.keySet()) {
            pq.add(key);
        }

        int[] result = new int[n];
        int prev = 25122002;
        int idx = 0;
        while(!pq.isEmpty()) {
            int curr = pq.remove();
            result[idx++] = curr;

            if(prev != 25122002) pq.add(prev);

            if(freq.get(curr) > 1) {
                freq.put(curr,freq.get(curr) - 1);
                prev = curr;
            }
            else {
                freq.remove(curr);
                prev = 25122002;
            }
            
        }

        if(prev != 25122002) {
            result[idx] = prev;
        }
       

        return result;

    }
}