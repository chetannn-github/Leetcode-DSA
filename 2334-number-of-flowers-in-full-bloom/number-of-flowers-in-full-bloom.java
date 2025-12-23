// memory limit exceed 
// class Solution {
//     public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;

//         for(int[] row : flowers) {
//             min = Math.min(row[0], min);
//             max = Math.max(row[1], max);
//         }

//         int[] line = new int[max - min + 2];

//         for(int[] row : flowers) {
//             int start = row[0] - min;
//             int end = row[1] - min;

//             line[start]++;
//             line[end + 1]--;
//         }

//         for(int i = 1 ;i < line.length ; i++) {
//             line[i] += line[i-1];
//         }

//         for(int i=0; i<people.length; i++) {
//             int idx = people[i] - min;
//             if(idx < 0 || idx >= line.length-1) {
//                 people[i] = 0;
//             }else people[i] = line[people[i] - min];
//         }

//         return people;

//     }
// }

// // time limit exceeded
// class Solution {
//     public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//         TreeMap<Integer,Integer> hm = new TreeMap<>();

//         for(int[] row : flowers) {
//             int start = row[0];
//             int end = row[1];
//             hm.put(start, hm.getOrDefault(start,0) + 1);
//             hm.put(end+1 ,hm.getOrDefault(end + 1, 0) - 1);

//         }
//         int idx = 0;
//         for(int time : people) {
//             int flowersBloomed = 0;
//             for(Integer key : hm.keySet()) {
//                 if(key > time) break;

//                 flowersBloomed += hm.get(key);
//             }
//             people[idx++] = flowersBloomed; 
//         }

    
//         return people;

//     }
// }



class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
    
        for(int[] flower : flowers) {
            int start = flower[0], end = flower[1]+1;
            hm.put(start, hm.getOrDefault(start,0) + 1);
            hm.put(end, hm.getOrDefault(end,0) - 1);
        }

        int n = hm.size();
        int[] times = new int[n];
        int[] prefix = new int[n];
        
        int currIdx = 0, cumSum = 0;
        for(Integer key : hm.keySet()) {
            cumSum += hm.get(key);
            times[currIdx] = key;
            prefix[currIdx] = cumSum;
            currIdx++;
        }

        for(int j = 0; j < people.length; j++) {
            int time = people[j];
            int idx = binarySearch(times, time);
            people[j] = idx >= 0 ? prefix[idx] : 0;
        }

        return people;
    }

    int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int result = -1;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);

            if(arr[mid] <= target) {
                result = mid;
                start = mid + 1;
            }else{ 
                end = mid - 1;
            }
        }
        return result;
    }
}
