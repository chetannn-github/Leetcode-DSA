class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        while(l1>=0 || l2>=0){
            
            if(l1<0){
                if(b.charAt(l2)=='1'){
                    if(carry == 1){
                        sb.append("0");
                    }else{
                        sb.append("1");
                    }
                }else{
                    sb.append(carry);
                    carry = 0;
                }
            }else if(l2<0){
                if(a.charAt(l1)=='1'){
                    if(carry == 1){
                        sb.append("0");
                    }else{
                        sb.append("1");
                    }
                }else{
                    sb.append(carry);
                    carry = 0;
                }
            }else{
                if(carry == 1){
                    if(a.charAt(l1) == '1'){
                        sb.append(b.charAt(l2));
                    }else{
                        if(b.charAt(l2)== '1'){
                            sb.append("0");
                            carry = 1;
                        }else{
                            sb.append("1");
                            carry = 0;
                        }
                    }
                }else{
                    if(a.charAt(l1) == '1'){
                        if(b.charAt(l2)== '1'){
                            sb.append("0");
                            carry = 1;
                        }else{
                            sb.append("1");
                        }
                    }else{
                        sb.append(b.charAt(l2));  
                    }
                }
                
            }

            l1--;
            l2--;

        }

        if(carry==1){
                sb.append("1");
        }


        return sb.reverse().toString();

    }

   
}