class Solution {
    public List<Integer> numOfBurgers(int tomato, int cheese) {
        // 4x + 2y = tomato  
        // x + y = cheese 
        // 2x + 2y = 2cheese
        // x = (tomato - 2 cheese) / 2; 
        // y = cheese - x


        if((tomato - cheese * 2) % 2 != 0) {
            return new ArrayList<>();
        }

        int x = (tomato - cheese * 2) / 2 ;
        int y = cheese - x;

        if(y < 0 || x<0) return new ArrayList<>();


        List<Integer> result = new ArrayList<>();
        result.add(x);
        result.add(y);

        return result;
       


    }
}