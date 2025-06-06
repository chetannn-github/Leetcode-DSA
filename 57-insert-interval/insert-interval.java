class Solution {
    public int[][] insert(int[][] arr, int[] newInterval) {
        if(arr.length == 0) return new int[][] {newInterval};

        Stack<int[]> st = new Stack<>();
        boolean isAdded = false;

        for(int i = 0; i< arr.length; i++) {
            if(!isAdded ){
                
                if((newInterval[0] < arr[i][0]) || (newInterval[0] == arr[i][0] && arr[i][0] > newInterval[1]) ){
                    isAdded = true;
                    i--;
                    
                }

                if(isAdded &&  !st.isEmpty() && st.peek()[1] >= newInterval[0]) {
                    int start = st.peek()[0];
                    int end = Math.max(newInterval[1], st.pop()[1]);
                    
                    st.push(new int[]{start,end});
                }else if(isAdded){
                    st.push(newInterval);
                }
                

            }
            
            if(i<0) continue;
            
            if(!st.isEmpty()  && st.peek()[1] >= arr[i][0]){
                int start = st.peek()[0];
                int end = Math.max(arr[i][1], st.pop()[1]);

                st.push(new int[]{start,end});
            }else {
                st.push(arr[i]);
            }
            
        }

        // last me hogaa add
        if(!isAdded) {
            
            if(!st.isEmpty() && st.peek()[1] >= newInterval[0]) {
                    int start = st.peek()[0];
                    int end = Math.max(newInterval[1], st.pop()[1]);
                    
                    st.push(new int[]{start,end});
            }else{
                st.push(newInterval);
            }
        }




        


        int[][] ans = new int[st.size()][2];
        int idx = ans.length-1;
        while(!st.isEmpty()){
            ans[idx--] = st.pop();
        }
        
        return ans;
    }
}