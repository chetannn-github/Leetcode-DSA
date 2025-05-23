class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        
        for (int a=0; a<n; a++) {
            HashSet<String> substrings = new HashSet<>();
            for (int k=0; k<n ; k++) {
                if(k==a) continue;

                String str = arr[k];
                int length = str.length();

                for(int i = 0; i < length; i++) {
                    for (int j = i + 1; j <= length; j++) {
                        substrings.add(str.substring(i, j));
                    }
                }
            }
            String str = arr[a];
            int length = str.length();
            int ansLength = Integer.MAX_VALUE;
            ans[a] = "";

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j <= length; j++) {
                    if (j-i <= ansLength) {
                        String sub = str.substring(i, j);
                        if (!substrings.contains(sub)) {
                            if(j-i == ansLength) {
                                ans[a] = getLexicographicallySmaller(ans[a],sub);
                            }else {
                                ans[a] = sub;
                            }
                            ansLength = j-i;
                        }
                    }
                    
                }
            }

            
        }
        
            
        return ans;
    }

    public static String getLexicographicallySmaller(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 < ch2) {
                return str1;
            } else if (ch1 > ch2) {
                return str2;
            }
        }
        return str1; 
    }
}
