class Solution {
public int[] pivotArray(int[] nums, int pivot) {
    int nums2[] = new int[nums.length];

    int j = 0;
    int count = 0;

    for(int num : nums){
        if(num<pivot){
            nums2[j]=num;
            j++;
        }else if(num == pivot){
            count++;
        }
    }
    while(count>0){
        nums2[j] = pivot;
        j++;
        count--;
    }
    
    for(int num : nums){
        if(num>pivot){
            nums2[j]=num;
            j++;
        }
    }
    return nums2;
}
}