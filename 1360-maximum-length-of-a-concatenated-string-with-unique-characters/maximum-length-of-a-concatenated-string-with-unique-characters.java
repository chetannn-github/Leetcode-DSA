class Solution {
    int n;
    public int maxLength(List<String> arr) {
        HashSet<Character> temp = new HashSet<>();
        n = arr.size();
    
        return solve(arr,0, temp);
    }

    public int solve(List<String> arr, int start,HashSet<Character> temp){
        if(start == n){
            return 0;
        }

        // take  it -- with some condition kii koi bhi letter phele se toh nhi h aurr khud string toh dup nhii hh
        boolean isPresent = true;
        String curr = arr.get(start);
        int length = curr.length();
        HashSet<Character> checkDup = new HashSet<>();

        for(int i=0; i<length; i++){
            char ch = curr.charAt(i);
            if(temp.contains(ch)){
                isPresent = false;
                break;
            }

            if(checkDup.contains(ch)){
                isPresent = false;
                break;
            }else{
                checkDup.add(ch);
            }
        }
        int taken = 0;
        if(isPresent){
            for(int i=0; i<curr.length(); i++){
                temp.add(curr.charAt(i));
            }
            taken = length + solve(arr,start+1,temp);
            for(int i=0; i<curr.length(); i++){
                temp.remove(curr.charAt(i));
            }
        }
        // dont take 
        int notTaken = solve(arr,start+1,temp);

        return Math.max(taken , notTaken);
        

    }
}