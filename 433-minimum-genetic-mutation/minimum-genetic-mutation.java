class Solution {
    HashSet<String> visited;
    HashSet<String> valid ;
    public int minMutation(String start, String end, String[] bank) {
        visited = new HashSet<>();
        valid = new HashSet<>();

        for(String validGene : bank){
            valid.add(validGene);
        }

        return solve(start, end, 0);
    }

    public int solve(String curr, String end , int mutation){
        Queue<String> queue = new LinkedList<>();
        StringBuilder s;

        visited.add(curr);
        queue.add(curr);

        while(!queue.isEmpty()){
            int n = queue.size();

            while(n-->0){
               curr = queue.remove();
                s = new StringBuilder(curr);

                if(curr.equals(end)){
                    return mutation;
                }
                for(int i=0; i<8; i++){
                    char ch = curr.charAt(i);
                    if(ch != 'A'){
                        s.setCharAt(i,'A');
                        String mutated = s.toString();
                        if(!visited.contains(mutated) && valid.contains(mutated)){
                            queue.add(mutated);
                            visited.add(mutated);
                        }
                    }
                    if(ch != 'C'){
                        s.setCharAt(i,'C');
                        String mutated = s.toString();
                        if(!visited.contains(mutated) && valid.contains(mutated)){
                            queue.add(mutated);
                            visited.add(mutated);
                        }
                    }

                    if(ch != 'G'){
                        s.setCharAt(i,'G');
                        String mutated = s.toString();
                        if(!visited.contains(mutated) && valid.contains(mutated)){
                            queue.add(mutated);
                            visited.add(mutated);
                        }
                    }

                    if(ch != 'T'){
                        s.setCharAt(i,'T');
                        String mutated = s.toString();
                        if(!visited.contains(mutated) && valid.contains(mutated)){
                            queue.add(mutated);
                            visited.add(mutated);
                        }
                    }

                    s.setCharAt(i,ch);
                } 
            }
            
            mutation++;
        }

        return -1;
    }
}