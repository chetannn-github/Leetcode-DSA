class Solution {
    List<Integer> result = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {
        int temp = 0;
        solve(n, k ,temp);

        int[] ans = new int[result.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = result.get(i);
        }

        return ans;
    }


    public void solve(int length , int dif, int temp){
        int digits;
        if(temp!=0){
            digits = (int) Math.log10(temp) + 1;
        }else{
            digits = 0;
        }
        
        if(digits == length){
            result.add(temp);
            return;
        }

        for(int i = 0; i<10; i++){
            if(temp==0 && i == 0){
                continue;
            }
            int lastDigit = temp%10;

            if(digits==0 && i!=0){
                temp  = temp*10 + i;
                solve(length, dif, temp);
                temp = 0;
            }

            else if(lastDigit+dif==i || lastDigit - dif == i){
                temp  = temp*10 + i;
                solve(length, dif, temp);
                temp /=10;
            }
        }
    }
}