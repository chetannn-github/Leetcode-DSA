class Solution {
    public String getHint(String s, String g) {
        HashMap<Character,Integer> guess = new HashMap<>();
        HashMap<Character,Integer> secret = new HashMap<>();

        int bull = 0;
        for(int i=0; i<s.length(); i++){
            char charG = g.charAt(i);
            char charS = s.charAt(i);
            
            if(charS==charG){
                bull++;
            }else{
                guess.put(charG, guess.getOrDefault(charG,0)+1);
                secret.put(charS, secret.getOrDefault(charS,0)+1);
            }
        }

        int cow = 0;
        for(Character key : guess.keySet()){
            if(secret.containsKey(key)){ 
                cow += Math.min(secret.get(key), guess.get(key));
            }
        }
       

        return bull+"A" + cow + "B";
    }
}