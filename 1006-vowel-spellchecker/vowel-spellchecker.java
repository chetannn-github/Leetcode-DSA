class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exact = new HashSet<>();
        HashMap<String,Integer> lowerCased = new HashMap<>();
        HashMap<String,Integer> vowelMasked = new HashMap<>();
        int idx = 0;
        for(String word : wordlist){
            exact.add(word);
            String replaced = replaceVowel(word.toLowerCase());
            String lowered = word.toLowerCase();
            
            if(!lowerCased.containsKey(lowered)){
                lowerCased.put(lowered,idx);
            }
            if(!vowelMasked.containsKey(replaced)){
                vowelMasked.put(replaced,idx);
            }
            idx++;
        }

        int i=0;
        String[] ans = new String[queries.length];

        for(String query : queries){
            if(exact.contains(query)){
                ans[i] = query;
            }else if(lowerCased.containsKey(query.toLowerCase())){
                ans[i] = wordlist[lowerCased.get(query.toLowerCase())];

            }else if(vowelMasked.containsKey(replaceVowel(query.toLowerCase()))){
                ans[i] = wordlist[vowelMasked.get(replaceVowel(query.toLowerCase()))];
            }else{
                ans[i] = "";
            }

            i++;
        }

        return ans;
    }

    public String replaceVowel(String word){
        StringBuilder sb = new StringBuilder(word);

        for(int i=0;i<sb.length(); i++){
            if(sb.charAt(i)=='a' || sb.charAt(i)=='e' || sb.charAt(i)=='i'|| sb.charAt(i)=='o'|| sb.charAt(i)=='u'){
                sb.setCharAt(i,'#');
            }
        }

        return sb.toString();

    }
}