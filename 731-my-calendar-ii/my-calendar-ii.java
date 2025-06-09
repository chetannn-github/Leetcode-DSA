class MyCalendarTwo {
    private TreeMap<Integer, Integer> hm;
    private int maxOverlappingEvents;

    public MyCalendarTwo() {
        hm = new TreeMap<>();
        maxOverlappingEvents = 2;
    }

    public boolean book(int start, int end) {
        
        hm.put(start, hm.getOrDefault(start, 0) + 1);
        hm.put(end, hm.getOrDefault(end, 0) - 1);

        int overlappedBooking = 0;

        for (Integer key : hm.keySet()) {
            overlappedBooking += hm.get(key);

            if (overlappedBooking > maxOverlappingEvents) {
                hm.put(start, hm.get(start) - 1);
                hm.put(end, hm.get(end) + 1);

                if (hm.get(start) == 0) hm.remove(start);
                // if (hm.get(end) == 0) hm.remove(end);

                return false;
            }
        }

        return true;
    }
}