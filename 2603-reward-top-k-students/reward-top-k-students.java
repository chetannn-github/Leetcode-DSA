class Solution {
    HashSet<String> positive;
    HashSet<String> negative;
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        positive = new HashSet<>();
        negative = new HashSet<>();

        for(String word : positive_feedback) positive.add(word);
        for(String word : negative_feedback) negative.add(word);

        int[] points = new int[report.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{
            return points[a] == points[b] ? student_id[b] - student_id[a] : points[a] - points[b];
        });
        
        
        for(int i=0; i<report.length; i++){
            points[i] = calculatePoints(report[i]);
            pq.add(i);
            if(pq.size() > k) pq.remove();
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<k; i++){
            ans.add(student_id[pq.remove()]);
        }

        Collections.reverse(ans);

        return ans;
    }

    public int calculatePoints(String feedback){
        int points = 0;

        String[] words = feedback.split(" ");

        for(String word : words){
            if(positive.contains(word)) points +=3;
            else if(negative.contains(word)) points -=1;
        }

        return points;
    }
}