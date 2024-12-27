class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int start = 0; 
        int end = 1_000_000_000;
        int rad = -1;
        while(start<=end){
            int mid = start + ((end - start)>>1);
            if(checkPossible(houses,heaters,mid)){
                rad = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return rad;
    }

    public boolean checkPossible(int[] houses, int[] heaters, int rad){
        int i = 0, j= 0; 
        while(i<houses.length && j<heaters.length){
            if(Math.abs(houses[i] - heaters[j])<=rad){
                i++;
            }else{
                j++;
            }
        }

        return i==houses.length;
    }
}