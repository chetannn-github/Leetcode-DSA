class Solution {
    int[] nums;
    public String largestNumber(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        mergeSort(0,n-1);   

        StringBuilder sb = new StringBuilder();
        for(int num : nums) sb.append(num);
        return trimStartingZero(sb).toString();
    }

    private void mergeSort(int left, int right) {
        if(left >= right) return;
        int mid = left + ((right - left)>>1);

        mergeSort(left,mid);
        mergeSort(mid+1,right);  
        merge(left,mid,right);
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++)
            L[i] = nums[left + i];

        for(int j = 0; j < n2; j++)
            R[j] = nums[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if(customSort(L[i],R[j]))
                nums[k++] = L[i++];
            else
                nums[k++] = R[j++];
        }

        while(i < n1)
            nums[k++] = L[i++];

        while(j < n2)
            nums[k++] = R[j++];
    }


    private boolean customSort(int a, int b) {
        if(a == 0 || b == 0) return a > b;
        return mergeTwoNumber(a,b) >= mergeTwoNumber(b,a);
    }

    private long  mergeTwoNumber(int a, int b) {
        long digitB =  (long) Math.log10(b) + 1;
       
        long multiplyFactor = (long) Math.pow(10,digitB); 
        return a * multiplyFactor + b;

    }

    private StringBuilder trimStartingZero(StringBuilder sb) {
        int n = sb.length();
        if(n > 1 && sb.charAt(0) == '0' && sb.charAt(1) == '0') return new StringBuilder("0"); 
        return sb;
    }
}