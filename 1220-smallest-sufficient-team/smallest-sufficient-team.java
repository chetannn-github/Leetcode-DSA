class Solution {
    int[] peopleBit;
    List<Integer> result;
    int k,n;
    int resultLength = Integer.MAX_VALUE;
    int[][] dp;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String,Integer> skillIdx = new HashMap<>();
        n = people.size();
        k = req_skills.length;
        peopleBit = new int[n];

        for(int i=0; i<k; i++) {
            skillIdx.put(req_skills[i],i);
        }

        dp = new int[n+1][1<<k];

        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }

        for(int i=0; i<n; i++) {
            int bitVal = 0;
            for(String skill : people.get(i)) {
                if(skillIdx.containsKey(skill)) {
                    bitVal |=  (1<< (skillIdx.get(skill)));
                }
            }
            peopleBit[i] = bitVal;
        }

        solve(0,0,new ArrayList<>());
        return toArray(result);
    }

    private void solve(int curr, int bitVal, List<Integer> team) {
        int teamSize = team.size();
        if(1+bitVal == (1<<k)) {
            if(resultLength > teamSize) {
                resultLength = teamSize;
                result = new ArrayList<>(team);
            }
            return;
        }
        if(curr >= n) return;

        if(teamSize > resultLength) return;
        if(dp[curr][bitVal] != -1 && dp[curr][bitVal] <= teamSize) return ;

        solve(curr+1, bitVal, team);

        if(peopleBit[curr] > 0) {
            team.add(curr);
            solve(curr+1, bitVal | peopleBit[curr] , team);
            team.remove(team.size() - 1);
        }

        dp[curr][bitVal] = teamSize;
        
    }

    public int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}