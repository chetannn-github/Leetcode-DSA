class Solution {
    public int compress(char[] chars) {
       if(chars.length==1){return 1;}
        int ans = 0;
        int idx =0;
        for(int i=0; i<chars.length;i++){
            int count = 1;
            char ch = chars[i];
            while( i<chars.length-1 && ch == chars[i+1]){
                count++;
                i++;
            }
            chars[idx] = ch;
            idx++;
            if(count==1){
                ans+=count;
                
            }else if(count>=1000){ 
                chars[idx] = (char) (count/1000 + '0') ;
                chars[idx+1] = (char) (count%1000+ '0') ;
                chars[idx+2] = (char) (count%100 + '0') ;
                chars[idx+3] = (char) (count%10 + '0') ;
                idx +=4;
                ans += 5;
            }else if(count>=100){
                chars[idx] = (char) (count/100 + '0') ;
                chars[idx+1] = (char) (count%100 + '0') ;
                chars[idx+2] = (char) (count%10 + '0') ;
                idx +=3;
                ans += 4;
            }else if(count>=10){
                chars[idx] = (char) (count/10 + '0') ;
                chars[idx+1] = (char) (count%10 + '0') ;
                idx +=2;
                ans += 3;
            }else{
                chars[idx] =(char) (count + '0') ;
                idx++;
                ans+=2;
            } 
        }
        return idx;
    }
}


