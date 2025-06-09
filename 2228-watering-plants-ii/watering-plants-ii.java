class Solution {
    public int minimumRefill(int[] plants, int capA, int capB) {
        int currCapA= capA;
        int currCapB= capB;

        int left = 0;
        int right = plants.length-1;
        int count = 0;

        while(left<=right){
            if(left == right){
                if(plants[left]>Math.max(currCapA,currCapB)){
                    count++;
                }
            }else{
                if(plants[left]>currCapA){
                    count++;
                    currCapA = capA;
                }
                currCapA -= plants[left];
                
                if(plants[right]>currCapB){
                    count++;
                    currCapB = capB;
                }
                currCapB -= plants[right];
            }

            left++;
            right--;
        }

        return count;
    }
}