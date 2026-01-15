class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        Pair[] arr = new Pair[n];

        for(int i=0; i<n; i++) {
            arr[i] = new Pair((double) wage[i] / (double) quality[i], quality[i]);
        }

        Arrays.sort(arr,(a,b)->(a.ratio - b.ratio) > 0 ? 1 : -1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        double kQualitySum = 0;
        double minCost = Double.MAX_VALUE;

        for(int i=0; i<n; i++) {
            pq.add(arr[i].quality);
            kQualitySum += arr[i].quality;

            if(pq.size() > k) {
                kQualitySum -= pq.remove();
            }

            if(pq.size() == k) {
                double currRatio = arr[i].ratio;
                double currCost = kQualitySum * currRatio;

                minCost = Math.min(currCost,minCost);
            }
        }

        return minCost;

    }
}

class Pair {
    double ratio;
    int quality;

    Pair(double ratio, int quality) {
        this.ratio = ratio;
        this.quality = quality;
    }
}