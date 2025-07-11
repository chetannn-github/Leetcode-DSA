class Solution {
    public int maxPoints(int[][] points) {
        
        int maxSlopeFreq = 0;
        int n = points.length;

        for(int i=0; i<n; i++) {
            HashMap<Double,Integer> slopes = new HashMap<>();
            for(int j=i+1; j<n; j++) {
                int diffY = points[j][1] -  points[i][1];
                int diffX = points[j][0] -  points[i][0];
                double slope = 0.0;

                if(diffX == 0) slope = 0.0;
                else if(diffY == 0) slope = Double.MAX_VALUE;
                else slope = (double) diffY / diffX;
                
                slopes.put(slope, slopes.getOrDefault(slope,0) + 1);

                maxSlopeFreq = Math.max(maxSlopeFreq, slopes.get(slope));
            }
        }

        return maxSlopeFreq + 1;
    }
}