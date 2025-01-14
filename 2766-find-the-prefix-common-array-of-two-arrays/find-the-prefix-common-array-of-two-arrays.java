class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        int ans[] = new int[A.length];

        for(int i=0; i<A.length;i++){
            int count =0;

            if(hs2.contains(A[i])){
                count++;
            }
            if(hs1.contains(B[i])){
                count++;
            }
            if(A[i]==B[i]){
                count++;
            }
            hs1.add(A[i]);
            hs2.add(B[i]);

            if(i!=0){
                ans[i] = count + ans[i-1];
            }else{
                ans[i] = count;
            }
            
        }
        return ans;
    }
}