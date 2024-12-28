class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) +1);
        }

        final int[][] arr = new int[hm.size()][2];
        final int[] i ={0};
        hm.forEach((key,value)->{
            arr[i[0]] = new int[]{(int)(key),value};
            i[0]++;
        });

        Arrays.sort(arr,(a,b)->{
            return Integer.compare(b[1], a[1]);
        });
       
        StringBuilder sb = new StringBuilder();

        for(int k=0; k<arr.length; k++){
            while(arr[k][1]!=0){
                sb.append((char)(arr[k][0]));
                arr[k][1]--;
            }
        }

        return sb.toString();
    }
}