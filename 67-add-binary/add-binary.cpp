class Solution {
public:
    string addBinary(string a, string b) {
        int m=a.length();
        int n=b.length();

        string ans="";

        if(m!=n)
        {
           while (m < n) 
           {
              a = "0" + a;
              m++;
           }

            while (n < m) {
            b = "0" + b;
    n++;
}
        }

        cout<<a<<" "<<b;

        int carry=0;
        int i=m-1;

        while(i>=0)
        {
           if((a[i]=='0' && b[i]=='1') || (a[i]=='1' && b[i]=='0'))
           {
               if(carry==0)
               {
                ans.push_back('1');
                 carry=0;
               }
               else{
                ans.push_back('0');
                carry=1;
               }
           }
           else if(a[i]=='1' && b[i]=='1'){
                if(carry==0)
                {
                    carry=1;
                    ans.push_back('0');
                }
                else{
                    carry=1;
                    ans.push_back('1');
                }
           } 

           else{
              if(carry==0)
              {
                ans.push_back('0');
              }
              else{
                ans.push_back('1');
                 carry=0;
              }
           }
            i--;
        }

        if(carry==1)
        {
             ans.push_back('1');
        }

        reverse(ans.begin(),ans.end());

        return ans;
    }
};