class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        HashSet<Integer> deleteIndices = new HashSet<>();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                int[] arr = pq.remove();
                deleteIndices.add(arr[1]);
            }else{
                pq.add(new int[]{(int) ch, i});
            }
        }

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch != '*' && !deleteIndices.contains(i)){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}