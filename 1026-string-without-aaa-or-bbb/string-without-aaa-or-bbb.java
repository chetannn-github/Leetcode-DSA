class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int A = a, B= b;
        boolean lastB = false;

        while(a>0 && b > 0 && (a>b || b>a)) {
            while(a>b && b>0) {
                if(a>=2) {
                    sb.append("aa");
                    a -=2;
                }else {
                    sb.append("a");
                    a--;
                }
                sb.append("b");
                lastB = true;
                b--;
                
            }
            
            while(a<b && a>0) {
                if(lastB) {
                    sb.append("a");
                    a--;
                }
               
                if(b>=2) {
                    sb.append("bb");
                    b -=2;
                }else {
                    sb.append("b");
                    b--;
                }

                if(!lastB) { 
                    sb.append("a");
                    lastB = false;
                    a--;
                }else lastB = true;
                
                
            }
            
          
        }


        while(a>0 || b>0) {
            if(a>0) {
                sb.append("a");
                a--;
            }

            if(b>0) {
                sb.append("b");
                b--;
            }
        }



        
        

        return sb.toString();


    }
}