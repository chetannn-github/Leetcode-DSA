class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int poi = -1;
        for(int i=n-1; i>=1; i--) {
            if(arr[i] < arr[i-1]) {
                poi = i-1;
                System.out.println(poi);
                break;
            }
        }

        if(poi == -1) return arr;
        int smallerGreatestIdx = poi + 1;

        for(int i=poi; i<n; i++) {
            if(arr[i] < arr[poi] && arr[i] > arr[smallerGreatestIdx]) {
                smallerGreatestIdx = i;
            }
        }

        int temp = arr[smallerGreatestIdx];
        arr[smallerGreatestIdx] = arr[poi];
        arr[poi] = temp;

        return arr;
    }
}