class Solution {
    public int[] countRectangles(int[][] rect, int[][] points) {
        HashMap<Integer, List<Integer>> hm= new HashMap<>();
        
        for(int i=0; i<rect.length; i++){       
            if(hm.containsKey(rect[i][1])) {
                hm.get(rect[i][1]).add(rect[i][0]);
            }else {
                hm.put(rect[i][1],new ArrayList<>());
                hm.get(rect[i][1]).add(rect[i][0]);
            }
        }
        
        for(int key : hm.keySet()){
            Collections.sort(hm.get(key));        
        }
		
        int[] ans = new int[points.length];
		
        for(int i=0; i<points.length; i++){
            int x = points[i][0], y = points[i][1];
            int count=0;
            for(int j= y; j<=100; j++){
                if(hm.containsKey(j)){
                    count += hm.get(j).size()- bs(hm.get(j), x);
                }
            }
            
            ans[i] = count;
            
        }
        
        return ans;        
    }


    int bs(List<Integer> arr, int x){
        int start =0, end = arr.size()-1;
        int ans = arr.size(); 
		
        while(start <=end){
            int mid = start + ((end-start ) >> 1);
        
            if(arr.get(mid)>=x){
                ans=mid;
                end=mid-1;
            }
            else{
                start =mid+1;
            }
            
        }
        
        return ans;
    }
}