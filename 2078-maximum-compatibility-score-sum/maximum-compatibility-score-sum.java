class Solution {
    int m;
    int n;
    int ans = 0;
    HashSet<Integer> hs = new HashSet<>();

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m = students.length;
        n = students[0].length;
        solve(students,mentors,0);
        return ans;
    }

    public void solve(int[][] students, int[][] mentors, int temp){
        int digits ;
        if(temp!=0){
            digits = (int) Math.log10(temp) + 1;  
        }else {
            digits = 0; //intentioanlly kiyaa hh meene yhhh 
            //jisse jb 1 length ho toh dikkt naa aayee
        }

        
        
        if(digits==m){
            compatibility(students,mentors,temp);
            return;
        }

        for(int i=1; i<=m; i++){
            if(hs.contains(i)){
                continue;
            }
            temp = temp*10 + i;
            hs.add(i);
            
            solve(students,mentors,temp);
            hs.remove(i);
            temp /=10;
        }
    }

    public void compatibility(int[][] students, int[][] mentors, int num){
        int totalCompatibility = 0;
        int last;
        for(int i = m-1; i>=0; i--){
            last = num%10;
            totalCompatibility += findCompatibility(students,mentors,i,last-1);
            num /=10;
        }

        ans = Math.max(ans,totalCompatibility);
    }

    public int findCompatibility(int[][] students, int[][] mentors, int i,int j){
        int compatibility = 0;
        for(int p=0; p<n; p++){
           compatibility += students[i][p] == mentors[j][p]? 1: 0;
        }
        return compatibility;
    }
}