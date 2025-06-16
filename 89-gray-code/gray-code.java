//  tle

// class Solution {
//     public List<Integer> grayCode(int n) {
//         List<Integer> ans = new ArrayList<>();
//         ans.add(0);
//         HashSet<Integer> hs = new HashSet<>();

//         solve(ans,n,hs);
//         return ans;
//     }

//     public boolean solve(List<Integer> ans, int n,HashSet<Integer> hs) {
//         int size  = ans.size();
//         int last = ans.get(size-1);

//         if(size == (1<<n)) {
//             // last one must ki 2 ki power
//             if( (last & (last -1)) == 0) {
//                 return true;
//             }  
//         }
//         boolean bool = false;

//         for(int i=1; i<(1<<n) ; i++) {
//             if(hs.contains(i)) continue;
//             int xor = (i ^ last);

//             if (xor == 0) continue;

//             if( (xor & (xor-1)) == 0 ) {
//                 hs.add(i);
//                 ans.add(i);
//                 bool = bool ||  solve(ans,n,hs);
//                 if (bool) return true;
//                 else{
//                     hs.remove(i);
//                     ans.remove(size);
//                 }
 
//             }

//         }

//         return bool;
//     }
// }

// trick : xor me 1 ek hii bit different honi chaiyee mtlb xor krne prr 1 one aaegaa 
// khii bhii aur a^ b = c or a^c = b

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        ans.add(0);
        hs.add(0);
        
        solve(ans,n,hs);
        return ans;
    }

    public boolean solve(List<Integer> ans, int n,HashSet<Integer> hs) {
        int size  = ans.size();
        int last = ans.get(size-1);

        if(size == (1<<n)) return true;

        for(int i=0; i<n ; i++) {
            int next = last ^ (1<<i);

            if(hs.contains(next)) continue;

            hs.add(next);
            ans.add(next);
            if (solve(ans,n,hs)) return true;
            else{
                hs.remove(next);
                ans.remove(size);
            }
        }

        return false;
    }
}