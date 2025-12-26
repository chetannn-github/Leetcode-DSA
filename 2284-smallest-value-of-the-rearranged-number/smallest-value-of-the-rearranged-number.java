class Solution {
    int[] arr;
    public long smallestNumber(long num) {
        if(num == 0) return 0;
        boolean isNegative = num < 0;
        if(isNegative) num = -num;
        buildDigitArray(num);
        
        mergeSort(0,arr.length-1, isNegative);   
        if(!isNegative) fixIntialZero();

        long result = 0;
        for(int d : arr) {
            result = mergeTwoNumber(result,d);
        }

        return isNegative ? -result : result;
    }

    private void mergeSort(int left, int right, boolean isDescending) {
        if(left >= right) return;
        int mid = left + ((right - left)>>1);

        mergeSort(left,mid, isDescending);
        mergeSort(mid+1,right, isDescending);  
        merge(left,mid,right, isDescending);
    }

    private void merge(int left, int mid, int right, boolean isDescending ) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) L[i] = arr[left + i];
        for(int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2) {
            if(customSort(L[i],R[j],isDescending,k)) {
                arr[k++] = L[i++];
            }else {
                arr[k++] = R[j++];
            }       
        }

        while(i < n1) arr[k++] = L[i++];
        while(j < n2) arr[k++] = R[j++];
    }

    private boolean customSort(int a, int b, boolean isDescending, int idx) {
        if(a == 0 || b == 0) return isDescending ? a > b : (a < b);
        
        return isDescending ? 
            (mergeTwoNumber(a,b) >= mergeTwoNumber(b,a)) : (mergeTwoNumber(a,b) <= mergeTwoNumber(b,a))
        ;
    }

    private long  mergeTwoNumber(long a, long b) {
        if(b == 0) return a*10;
        long digitB =  (long) Math.log10(b) + 1;
       
        long multiplyFactor = (long) Math.pow(10,digitB); 
        return (long) a * multiplyFactor + b;
    }

    private void buildDigitArray(long num) {
        int digits = (int) Math.log10(num) + 1;
        arr = new int[digits];
        int idx = 0;
        while(num > 0) {
            long lastDigit = num % 10;
            arr[idx++] = (int) lastDigit;
            num /= 10;
        }
    }


    private void fixIntialZero() {
        int n = arr.length;
        int idx = 0;

        while(idx<n && arr[idx] == 0) {
            idx++;
        }

        int temp = arr[idx];
        arr[idx] = 0;
        arr[0] = temp; 
    }
}