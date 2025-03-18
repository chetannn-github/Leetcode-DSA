// class Solution {
//     public String frequencySort(String s) {
//         HashMap<Character,Integer> hm = new HashMap<>();
//         for(int i=0; i<s.length(); i++){
//             char ch = s.charAt(i);
//             hm.put(ch, hm.getOrDefault(ch, 0) +1);
//         }

//         int[][] arr = new int[hm.size()][2];
//         int i = 0 ;

//         for(Character ch : hm.keySet()){
//             arr[i] = new int[] {(int)(ch),hm.get(ch)};
//             i++;
//         }
        

//         Arrays.sort(arr,(a,b)->{
//             return Integer.compare(b[1], a[1]);
//         });
       
//         StringBuilder sb = new StringBuilder();

//         for(int k=0; k<arr.length; k++){
//             while(arr[k][1]!=0){
//                 sb.append((char)(arr[k][0]));
//                 arr[k][1]--;
//             }
//         }

//         return sb.toString();
//     }
// }


class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) +1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)-> hm.get(b) - hm.get(a));

        
        for(Character ch : hm.keySet()){
            pq.add(ch);
        }
        


        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            char ch = pq.remove();
            int freq = hm.get(ch);
            while(freq!=0){
                sb.append(ch);
                freq--;
            }
        }

        return sb.toString();
    }
}
