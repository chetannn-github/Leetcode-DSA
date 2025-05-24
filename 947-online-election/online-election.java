// class TopVotedCandidate {
//     int[] persons;
//     int[] times;
//     public TopVotedCandidate(int[] persons, int[] times) {
//         this.persons = persons;
//         this.times = times;
//     }
    
//     public int q(int t) {
        

//         int idx = bs(t);
//         HashMap<Integer,Integer> freq = new HashMap<>();
//         int maxFreq = 0;
//         int mostVoted = -1;

//         for(int i=0; i<=idx; i++) {
//             freq.put(persons[i], freq.getOrDefault(persons[i], 0) + 1);

//             if(freq.get(persons[i]) >= maxFreq) {
//                 maxFreq = freq.get(persons[i]);
//                 mostVoted = persons[i];
//             }
//         }
//         return mostVoted;
//     }

//     public int bs(int target) {
//         int start = 0 , end = times.length-1;
//         int ans = -1;
//         while(start <= end) {
//             int mid = start + ((end - start)>>1);
            
//             if(times[mid] > target) {
//                 end = mid - 1;
//             }else if(times[mid] < target) {
//                 ans = mid;
//                 start = mid + 1;
//             }else {
//                 return mid;
//             }
//         }
//         return ans;
//     }
// }


class TopVotedCandidate {
    int[] times;
    int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[times.length];

        HashMap<Integer, Integer> voteCount = new HashMap<>();
        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            voteCount.put(p, voteCount.getOrDefault(p, 0) + 1);

            if (voteCount.get(p) >= maxVotes) {
                    leader = p;
                    maxVotes = voteCount.get(p);
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int start = 0, end = times.length - 1;
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (times[mid] < t) {
                ans = mid;
                start = mid+ 1;
            }else if(times[mid] > t){
                end = mid - 1;
            }else {
                return leaders[mid];
            }
        }
        return leaders[end];
    }
}


