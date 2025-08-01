class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
    long totalCost = 0L;
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        int h = m-2, v = n-2;
        int horizontalSections = 1, verticalSections = 1;

        while(h>=0 && v>=0) {
            if(horizontalCut[h] >= verticalCut[v]) {
                // make a horizontal Cut
                totalCost += (long) verticalSections * horizontalCut[h];
                horizontalSections++;
                h--;
            }else {
                totalCost += (long) horizontalSections* verticalCut[v];
                verticalSections ++;
                v--;
            }
        }

        while(h>=0) {
            // make a horizontal Cut
            totalCost += (long) verticalSections * horizontalCut[h];
            horizontalSections++;
            h--;
        }
        
        while(v>=0) {
            totalCost += (long) horizontalSections* verticalCut[v];
            verticalSections++;
            v--;
        }

        return (int) totalCost;
    }
}