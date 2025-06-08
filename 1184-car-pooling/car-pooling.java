class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int arr[] = new int[1001];
        for(int i=0; i<trips.length; i++){
            if(arr[trips[i][0]]>capacity) {
                return false;
            }
            arr[trips[i][1]] -= trips[i][0];
            arr[trips[i][2]] += trips[i][0];
        }
        
        for(int i=0; i<1001; i++){
            capacity += arr[i];
            if(capacity < 0){
                return false;
            }
        }

        return true;
    }
}