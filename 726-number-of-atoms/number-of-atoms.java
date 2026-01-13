class Solution {
    Stack<HashMap<String,Long>> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
    long freq = 0;
    int idx= 0;
    int n;
    String formula;
    public String countOfAtoms(String formula) {
        st.push(new HashMap<>());
        this.n = formula.length();
        this.formula = formula;

        while(idx < n) {
            char ch = formula.charAt(idx);

            if(ch == '(' || ch == ')') handleBraces(ch);
            else if(isEnglishLetter(ch)) {
                if(isUpperCase(ch)) handlePreviousOne();
                sb.append(ch);
            }else {
                freq = freq*10 + (int) (ch-'0');
            }

            idx++;
            
        }
        handlePreviousOne();
        return getSortedString(st.peek());


    }

    private void handleBraces(char ch) {
        handlePreviousOne();
        if(ch == '(') st.push(new HashMap<>());
        else {
            idx++;
            int mulFreq = 0;
            while(idx < n && isNumber(formula.charAt(idx))) {
                mulFreq = mulFreq*10 + (formula.charAt(idx)-'0');
                idx++;
            }

            idx--;
            mulFreq = mulFreq > 0 ? mulFreq : 1;

            HashMap<String,Long> curr = st.pop();
            HashMap<String,Long> prev = st.peek();
        
            for(String key : curr.keySet()) {        
                prev.put(key, prev.getOrDefault(key,0L) + curr.get(key) * mulFreq);
            }
                
            
        }
    }

    private void handlePreviousOne() {
        if(sb.length() > 0) {
            HashMap<String,Long> curr = st.peek();
            String element = sb.toString();
            freq = freq == 0 ? 1 : freq;
            curr.put(element,curr.getOrDefault(element,0L)+freq);
            sb = new StringBuilder();
            freq = 0;
        }
    }

    private boolean isEnglishLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private boolean isUpperCase(char ch) {
        return (ch >= 'A' && ch <= 'Z');  
    }

    private boolean isNumber(char ch) {
        return ch-'0' >= 0 && ch-'0' < 10;
    }

    private String getSortedString(HashMap<String,Long> map) {
        TreeMap<String,Long> treeMap = new TreeMap<>();
        
        for(String key : map.keySet()) {
            treeMap.put(key,map.get(key));
        }

        StringBuilder sb = new StringBuilder();

        for(String key : treeMap.keySet()) {
            sb.append(key);
            if(treeMap.get(key) > 1) sb.append(treeMap.get(key));
        }
        return sb.toString();
    }
}