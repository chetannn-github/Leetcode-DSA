class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums2.length];

        for(int i = nums2.length-1; i>=0;i--){
            // for each i check in stack
            while(!st.isEmpty()){
                if(st.peek()<nums2[i]) st.pop(); 
                else{
                    ans[i] = st.peek();
                    break;
                }
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            st.push(nums2[i]);
        }

        for(int i = 0; i<nums1.length;i++){
            for(int j=0; j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    nums1[i] = ans[j];
                    break;
                }
            }
        }

        return nums1;



        // using simple array 2 pointers
        // int res[]= new int[nums1.length];
        // for(int i=0;i<nums1.length;i++){
        //      res[i]=-1;
            
        // }
        // for(int i=0;i<nums1.length;i++){
        //     int element=nums1[i];
        //     Boolean found=false;
        //     for(int j=0;j<nums2.length;j++){
        //         if(nums2[j]==element ){
        //             found=true;
        //         }
        //         if(nums2[j]>element && found==true){
        //             res[i]=nums2[j];
        //             break;
        //         }
                
               
        //     }
        // }
        // return res;
    }
}