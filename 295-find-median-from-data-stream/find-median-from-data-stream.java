class MedianFinder {
    PriorityQueue<Integer> left ;
    PriorityQueue<Integer> right ;
    int totalNumberAdded;

    public MedianFinder() {
        left = new PriorityQueue<>((a,b)->(b-a));
        right = new PriorityQueue<>((a,b)->(a-b));
        totalNumberAdded = 0;
    }
    
    public void addNum(int num) {
        if(totalNumberAdded == 0) {
            left.add(num);
            totalNumberAdded++;
            return;
        }
        totalNumberAdded++;

        if(left.peek() <= num) {
            right.add(num);
            if(right.size() > left.size()) {
                left.add(right.remove());
            }
        }else {
            left.add(num);

            if(left.size()-1 > right.size()){
                right.add(left.remove());
            }
        }
    }
    
    public double findMedian() {
        if(totalNumberAdded % 2 == 1) {
            return (double) left.peek();
        }

        return (double) (left.peek() + right.peek()) / 2;
    }
}

