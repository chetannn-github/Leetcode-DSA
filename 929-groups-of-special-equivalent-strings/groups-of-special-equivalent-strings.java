class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<String> hs = new HashSet<>();
        for(String word : words){
            hs.add(getEvenAndOddSorted(word));
        }

        return hs.size();
    }

    public String getEvenAndOddSorted(String word){
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for(int i=0;i<word.length(); i++){
            if(i%2==0){
                even.append(word.charAt(i));
            }else{
                odd.append(word.charAt(i));
            }
        }
        char[] evenChar = even.toString().toCharArray();
        char[] oddChar = odd.toString().toCharArray();

        Arrays.sort(evenChar);
        Arrays.sort(oddChar);

        String e = new String(evenChar);
        String o = new String(oddChar);
        return e+o;
    }
}