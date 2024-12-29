class Solution {
    public String evaluate(String s, List<List<String>> know) {
        HashMap<String,String> hm = new HashMap<>();
        for(int i=0; i<know.size(); i++){
            hm.put(know.get(i).get(0),know.get(i).get(1));
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); ){
            while(i<s.length() && s.charAt(i)!='('){
                ans.append(s.charAt(i));
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while(i<s.length()&&s.charAt(i)!=')'){
                sb.append(s.charAt(i));
                i++;
            }

            if(sb.length()>0){
                sb.deleteCharAt(0);
                ans.append(hm.getOrDefault(sb.toString(),"?"));
                i++;
            }
        }

        return ans.toString();
    }
}