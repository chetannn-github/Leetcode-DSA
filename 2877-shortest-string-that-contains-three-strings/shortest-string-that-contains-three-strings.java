class Solution {
    public String minimumString(String a, String b, String c) {
        // abc , acb, bac,bca, cab, cba
        List<String> results = new ArrayList<>();
        results.add(merge(merge(a,b),c));
        results.add(merge(merge(a,c),b));
        results.add(merge(merge(b,a),c));
        results.add(merge(merge(b,c),a));
        results.add(merge(merge(c,a),b));
        results.add(merge(merge(c,b),a));
        
        results.add(merge(c,merge(a,b)));
        results.add(merge(b,merge(a,c)));
        results.add(merge(c,merge(b,a)));
        results.add(merge(a,merge(b,c)));
        results.add(merge(b,merge(c,a)));
        results.add(merge(a,merge(c,b)));

        List<String> minLengthResult = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        for(int i=0; i<12; i++) {
            minLength = Math.min(minLength, results.get(i).length());
        }
        // System.out.println(results.toString());
    
        for(String str : results) {
            if(str.length() == minLength) {
                minLengthResult.add(str);
            }
        }
        

        
        int minLengthLexiSmallestIdx =0;

        for(int i=1; i < minLengthResult.size(); i++) {
            String curr = minLengthResult.get(i);
            String possibleAns = minLengthResult.get(minLengthLexiSmallestIdx);

            if(isLexicographicallySmaller(curr,possibleAns)) {
                minLengthLexiSmallestIdx = i;
            }
        }

        return minLengthResult.get(minLengthLexiSmallestIdx);
    }


    private boolean isLexicographicallySmaller(String s1, String s2) {
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) continue;
            if(s1.charAt(i) < s2.charAt(i)) return true;
            else return false;
        }
        return false;
    }


    private String merge(String s1, String s2) {
        int maxOverlap = 0;

        if (s1.contains(s2)) {
            return s1;
        }

        for (int i = 1; i <=  Math.min(s1.length(), s2.length()); i++) {
            if (s1.substring(s1.length() - i).equals(s2.substring(0, i))) {
                maxOverlap = i;
            }
        }
        return s1 + s2.substring(maxOverlap);
    }

}