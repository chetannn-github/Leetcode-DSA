class Solution {
    public int countTriples(int n) {
        int result = 0;
        for(int i=1; i<n; i++) {
            for(int j=i; j<n; j++) {
                double root = Math.sqrt(i*i + j*j);
                double rootRounded =  Math.round(root);
                if(root == rootRounded && root <= n) {
                    result += i==j ? 1 : 2;}
            }
        }

        return result;
    }
}