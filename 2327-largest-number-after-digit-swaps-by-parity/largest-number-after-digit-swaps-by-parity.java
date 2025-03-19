class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((a,b)->(b-a));
        PriorityQueue<Integer> even = new PriorityQueue<>((a,b)->(b-a));
        int reverse = 0;
        
        while(num!=0){
            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;

            num /= 10;
            if(lastDigit % 2 == 0){
                even.add(lastDigit);
            }else{
                odd.add(lastDigit);
            }
        }
        int ans = 0;

        while(reverse!=0){
            int lastDigit = reverse % 10;
            reverse /= 10;
            if(lastDigit % 2 == 0){
                int digit = even.remove();
                ans = ans * 10 + digit;
            }else{
                int digit = odd.remove();
                ans = ans * 10 + digit; 
            }
        }

        while(!even.isEmpty()){
            ans *= 10;
            even.remove();
        }

        return ans;
    }
}