class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) +1);
        }
        final int[][] arr = new int[hm.size()][2];
        final int[] i ={0};
        hm.forEach((key,value)->{
            arr[i[0]] = new int[]{key,value};
            i[0]++;
        });

        Arrays.sort(arr,(a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int j = 0;
        for(int k=0; k<arr.length; k++){
            while(arr[k][1]!=0){
                nums[j] = arr[k][0];
                arr[k][1]--;
                j++;
            }
        }

        return nums;
    }
}