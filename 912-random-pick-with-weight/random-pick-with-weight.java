class Solution {
    int sum = 0;
    int length;
    int[] pre;
    
    public Solution(int[] w) {
        length = w.length;
        pre = new int[length];

        for(int i=0; i<w.length; i++){
            sum += w[i];
            if(i!=0) {
                pre[i] = pre[i-1] + w[i];
            }else {
                pre[i] = w[i];
            }
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int randomNumInCummSum =  rand.nextInt(sum);
        
        return bs(randomNumInCummSum);
    }

    public int bs(int num) {
        int s = 0;
        int e = length -1;
        int ans = 0;

        while(s<=e) {
            int mid = s + ((e-s)>>1) ;
            if(num > pre[mid]) {
                s = mid+1;
            }else if(num < pre[mid]) {
                ans = mid;
                e = mid - 1;
            }else {
                return mid +1 ;
            }
        }
        return ans;
    }
}
