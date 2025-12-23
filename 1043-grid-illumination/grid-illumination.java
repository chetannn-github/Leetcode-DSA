class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer,Integer> rows = new HashMap<>();
        HashMap<Integer,Integer> cols = new HashMap<>();
        HashSet<String> lampSet = new HashSet<>();
        HashMap<Integer,Integer> diagonal1 = new HashMap<>();
        HashMap<Integer,Integer> diagonal2 = new HashMap<>();


        for(int[] lamp : lamps) {
            int row = lamp[0], col = lamp[1];
            String key = row + " " + col;
            if(lampSet.contains(key)) continue;

            lampSet.add(key);

            rows.put(row,rows.getOrDefault(row,0)+1);
            cols.put(col,cols.getOrDefault(col,0)+1);
            diagonal1.put(row-col, diagonal1.getOrDefault(row-col,0)+1);
            diagonal2.put(row+col, diagonal2.getOrDefault(row+col,0)+1);
        }

        int[] result = new int[queries.length];
        int idx = 0;
        for(int[] query : queries) {
            int row = query[0], col = query[1];
            boolean isIlluminated = (
                rows.getOrDefault(row,0) > 0 || 
                cols.getOrDefault(col,0) > 0 || 
                diagonal1.getOrDefault(row-col,0) > 0 || 
                diagonal2.getOrDefault(row+col,0) > 0
            );
            
            result[idx++] = isIlluminated ? 1 : 0;

            int startRow = Math.max(0,row-1);
            int endRow = Math.min(n,row+2);
            int startCol = Math.max(0,col-1);
            int endCol = Math.min(n,col+2);

            for(int i=startRow; i<endRow; i++) {
                for(int j=startCol; j<endCol; j++) {
                    String key = i + " " + j;
                  
                    if(lampSet.contains(key)) {
                        decreaseFreq(rows,i);
                        decreaseFreq(cols,j);
                        decreaseFreq(diagonal1,i-j);
                        decreaseFreq(diagonal2,i+j);
                        lampSet.remove(key);
                    }
                }
            }
        }

        return result;
    }

    private <K> void decreaseFreq(HashMap<K,Integer> map, K key) {
        if (map.get(key) == 1) map.remove(key);
        else map.put(key,map.getOrDefault(key,0)-1);
    }
}