class Solution {
    static class Pair {
    int roomNumber;
    long endTime;

    Pair(int roomNumber, long endTime) {
        this.roomNumber = roomNumber;
        this.endTime = endTime;
    }
}
    public int smallestChair(int[][] times, int targetFriend) {
        return mostBooked(times.length,times, times[targetFriend][0]);
    }

    public int mostBooked(int n, int[][] meetings, int target) {
        PriorityQueue<int[]> futureMeetings = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<Pair> runningMeetings = new PriorityQueue<>((a, b) -> Long.compare(a.endTime, b.endTime));
        PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();


        for (int[] meeting : meetings) {
            futureMeetings.add(meeting);
        }

        for (int i = 0; i < n; i++) {
            emptyRooms.add(i);
        }

        long currTime = 0;

        while (!futureMeetings.isEmpty()) {
            if (runningMeetings.size() == 0 || !emptyRooms.isEmpty()) {
                if (currTime < futureMeetings.peek()[0]) currTime = futureMeetings.peek()[0];

                while (!runningMeetings.isEmpty() && runningMeetings.peek().endTime <= currTime) {
                    emptyRooms.add(runningMeetings.remove().roomNumber);
                }
                
                int roomNumber = emptyRooms.remove();
                
                if(futureMeetings.peek()[0] == target) {
                    return roomNumber;
                }
                long endingTime = currTime + (futureMeetings.peek()[1] - futureMeetings.remove()[0]);
                runningMeetings.add(new Pair(roomNumber, endingTime));

            } else if (emptyRooms.size() == 0) {
                currTime = runningMeetings.peek().endTime;
                emptyRooms.add(runningMeetings.remove().roomNumber);
            }
        }

        return -1;
    }
}
