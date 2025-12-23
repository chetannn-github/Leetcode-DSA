class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        int n = nums.length;
        Arrays.sort(nums);
        Arrays.sort(target);

        List<Integer> oddNums = new ArrayList<>();
        List<Integer> oddTarget = new ArrayList<>();
        List<Integer> evenNums = new ArrayList<>();
        List<Integer> evenTarget = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if((nums[i] & 1) == 0) {
                evenNums.add(nums[i]);
            }else {
                oddNums.add(nums[i]);
            }

            if((target[i] & 1) == 0) {
                evenTarget.add(target[i]);
            }else {
                oddTarget.add(target[i]);
            }
        }

        long ops = 0L;
        for(int i=0; i<oddNums.size(); i++) {
            ops += Math.abs(oddNums.get(i) - oddTarget.get(i)) / 2;
        }

        for(int i=0; i<evenNums.size(); i++) {
            ops += Math.abs(evenNums.get(i) - evenTarget.get(i)) / 2;
        }

        return ops / 2;
    }

    
}