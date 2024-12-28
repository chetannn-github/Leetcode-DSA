class Solution {
    public String entityParser(String text) {
        HashMap<String,String> hm = new HashMap<>();
        hm.put("&quot;" , "\"");
        hm.put("&apos;" , "'");
        hm.put("&amp;" , "&");
        hm.put("&gt;" , ">");
        hm.put("&lt;" , "<");
        hm.put("&frasl;" , "/");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<text.length();){
            while(i<text.length() && text.charAt(i)!='&'){
                sb.append(text.charAt(i));
                i++;
            }
            int count = 0;
            while(i<text.length() && text.charAt(i)=='&'){
                sb.append(text.charAt(i));
                i++;
                count++;
            }
            

            StringBuilder temp = new StringBuilder("");
            if(count>=1){
                temp.append("&");
                sb.deleteCharAt(sb.length() - 1); 
            }
            while(i<text.length() && count>=1 &&text.charAt(i)!='&' && text.charAt(i)!=';'){
                temp.append(text.charAt(i));
                i++;
            }
            if(i<text.length() && text.charAt(i)==';'){
                temp.append(text.charAt(i));
                i++;
            }
            String possibleEntity = temp.toString();
            sb.append(hm.getOrDefault(possibleEntity, possibleEntity));
        }

        return sb.toString();

    }
}