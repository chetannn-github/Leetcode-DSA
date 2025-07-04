class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> futureMeetings = new PriorityQueue<>((a,b)-> (a[0] - b[0]));
        PriorityQueue<long[]> runningMeetings = new PriorityQueue<>((a,b)-> (int)(a[1]-b[1]));
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>(); 

        int[] freq =  new int[n];
        int maxFreq = 0;
        int mostFrequentRoom = 0;

        for(int[] meeting : meetings) {
            futureMeetings.add(meeting);
        }

        for(int i=0; i<n; i++) {
            emptyRooms.add(i);
        }

        long currTime = 0;

        while(!futureMeetings.isEmpty()) {
            if(runningMeetings.size() == 0 || !emptyRooms.isEmpty()) {
                if(currTime < futureMeetings.peek()[0]) currTime = futureMeetings.peek()[0];

                // check krr loo koi meeting finish toh nhii ho rhiii hain 
                while(!runningMeetings.isEmpty() && runningMeetings.peek()[1] <= currTime) {
                    emptyRooms.add((int)runningMeetings.remove()[0]);
                }
                

                int roomNumber = emptyRooms.remove();
                long endingTime = currTime + (futureMeetings.peek()[1] - futureMeetings.remove()[0]);
                runningMeetings.add(new long[] {roomNumber,endingTime});

                freq[roomNumber]++;
                boolean hasGotMostFrequentRoom = (freq[roomNumber] > maxFreq || 
                (freq[roomNumber] == maxFreq && mostFrequentRoom > roomNumber));

                if(hasGotMostFrequentRoom) {
                    mostFrequentRoom = roomNumber;
                    maxFreq = freq[roomNumber];
                }
            }else if(emptyRooms.size() == 0) {
                currTime = runningMeetings.peek()[1];
                emptyRooms.add((int)runningMeetings.remove()[0]);
            }


        }

        return mostFrequentRoom;
              
    }
}