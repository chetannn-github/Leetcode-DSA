class Solution {
    public int[] minOperations(String boxes) {
        // check kro konse index pr 1 hain --
        // no operations to move ball to desired box = mod(index at which one is present - index for we want ans)

        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new  int [boxes.length()];

        for(int i = 0; i<boxes.length();i++){
            if(boxes.charAt(i)=='1'){
                list.add(i);
            }
        }

        for(int i =0;i<boxes.length();i++){
            int ans =0;
            for(int j=0 ; j<list.size();j++){
                ans = ans + Math.abs(list.get(j) - i);
            }
            answer[i] = ans;
        }

        return answer;

        




}
}