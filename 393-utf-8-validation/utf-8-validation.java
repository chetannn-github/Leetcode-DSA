class Solution {
    public boolean validUtf8(int[] data) {
        int start = 0;
        int n = data.length;
        boolean ans = true;
        while(start<n){
            int num = data[start];
            if(num>247){
                return false;
            }else if(num>=240){
                ans = ans && checkNext(data,start+1,3,n);
                start +=4;
            }else if(num>=224){
                ans = ans && checkNext(data,start+1,2,n);
                start +=3;
            }else if(num>=192){
                ans = ans &&checkNext(data,start+1,1,n);
                start +=2;
            }else if(num>=128){
                return false;
            }
            else if((num & (1<<8)) == 0){
                start++;
            }

            if(!ans){
                return ans;
            }
        }

        return ans;
    }

    public boolean checkNext(int[] data, int start, int x,int n){
        if(start + x - 1 > n-1){
            return false;
        }

        while(x>0){
            if (!(data[start]>=128 && data[start]<=191 )){
                return false;
            }
            x--;
            start++;
        }


        return true;
        
    }
}