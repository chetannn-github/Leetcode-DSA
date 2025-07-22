class Solution {
    public List<Integer> getRow(int rowIndex) {
        

        List<Integer> prev = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();

            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) curr.add(1);
                else {
                    int sum = prev.get(j-1) + prev.get(j);
                    curr.add(sum);
                }
            }

            prev = curr;
        }

        return prev;   
    }
}