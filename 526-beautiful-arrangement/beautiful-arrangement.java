class Solution {
    int result = 0;
    HashSet<Integer> hs = new HashSet<>();

    public int countArrangement(int n) {
        List<Integer> temp = new ArrayList<>();
        solve(n,temp);
        return result;
    }

    public void solve(int n, List<Integer> temp ){
        if(temp.size()==n){
            result++;
            return;
        }

        for(int i=1; i<=n; i++){
            if(hs.contains(i)){
                continue;
            }
            int size = temp.size();
            if((i%(size+1))!=0 && (size+1)%i!=0){
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