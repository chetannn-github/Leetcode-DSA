class Solution {
    int result = 0;
    HashSet<Integer> hs = new HashSet<>();

    public int countArrangement(int n) {
        List<Integer> temp = new ArrayList<>();
        solve(n,temp);
        return result;
    }

    public void solve(int n, List<Integer> temp ){
        
        int last ;
        int size = temp.size();

        if(size>0){
            last = temp.get(size-1);

            if(last% size !=0 && size % last !=0){
                return;
            }
        }
        if(temp.size()==n){
            System.out.println(temp);
            result++;
            return;
        }

        for(int i=1; i<=n; i++){
            if(hs.contains(i)){
                continue;
            }
            
            hs.add(i);
            temp.add(i);
            solve(n,temp);

            temp.remove(temp.size()-1);
            hs.remove(i);
        }
        


    
    }
}