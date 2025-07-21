class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);

        int result = 0;

        for(int i=1;i< arrays.size(); i++ ){
            List<Integer> arr = arrays.get(i);
            int first = arr.get(0);
            int last = arr.get(arr.size()-1);
            

            result = Math.max(result, last - min);
            result = Math.max(result,max - first);

            min = Math.min(min,first);
            max = Math.max(max,last);
        }

        return result;
    }
}