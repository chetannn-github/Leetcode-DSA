class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
      
        for(int i=0; i<arr.length; i++){
            arr[i] = (arr[i]%k + k) %k ; 
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }

    for (Integer key : hm.keySet()) {
         if(key==0 && hm.get(0)%2!=0){
            return false;
        }else if(key!=0&&!hm.get(key).equals(hm.get(k - key)) ){
            return false;
        
        }


    }

    return true;


    }
}

// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         int res[]=new int [k];
//         for(int i=0;i<arr.length;i++){
//             int rem=(arr[i]%k + k) % k;
//             res[rem]++;
//         }
//         if(res[0]%2!=0) return false;
//         for(int i=1;i<=k/2;i++){
//             if(res[i]!=res[k-i]) return false;
//         }
//         return true;
//     }
// }