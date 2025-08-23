class Solution {
    public int numTrees(int N) {
        int[] C = new int[N+1];
        C[0] = 1;
for (int n=1; n<=N; n++) {
    for (int i=0; i<n; i++) {
        C[n] += C[i] * C[n-1-i];
    }
}

return C[N];

    }
}