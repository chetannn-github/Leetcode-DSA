class DinnerPlates {
    int maxSize;
    int maxIdx = -1;
    public DinnerPlates(int maxSize) {
        this.maxSize = maxSize;
    }
    
    HashMap<Integer,Stack<Integer>> map = new HashMap<>();
    TreeSet<Integer> empty = new TreeSet<>((a,b)->(a-b));
    HashSet<Integer> pureEmpty = new HashSet<>();

    public void push(int val) {
        if(maxIdx == -1 || (empty.size() == 0 && map.get(maxIdx).size() == maxSize)) {
            maxIdx++;
            Stack<Integer> newSet = new Stack<>();
            newSet.add(val);
            map.put(maxIdx, newSet);

            if(pureEmpty.contains(maxIdx)) pureEmpty.remove(maxIdx);

        }else if((empty.size() == 0 && map.get(maxIdx).size() != maxSize)) {
            Stack<Integer> currSet = map.get(maxIdx);
            currSet.add(val);
            map.put(maxIdx, currSet);
            if(pureEmpty.contains(maxIdx)) pureEmpty.remove(maxIdx);
            
        }else {
            int smallestIdx = empty.first();
            Stack<Integer> currSet = map.get(smallestIdx);
            currSet.push(val);

            if(currSet.size() == maxSize) {
                empty.remove(smallestIdx);
                
            }
            if(pureEmpty.contains(smallestIdx)) pureEmpty.remove(smallestIdx);
            maxIdx = Math.max(maxIdx, smallestIdx);
        }
    }
    
    public int pop() {
       return popAtStack(maxIdx);
    }
    
    public int popAtStack(int index) {
        if(index == -1) return -1;
        Stack<Integer> currSet = map.get(index);

        if(currSet == null || currSet.isEmpty()) return -1;

        int val = currSet.pop();
        if(!empty.contains(index)) empty.add(index);

        if(currSet.isEmpty()) pureEmpty.add(index);

        if(currSet.isEmpty() && index == maxIdx) {
            while(pureEmpty.contains(maxIdx-1)) maxIdx--;
            maxIdx--;
        }

        return val;
    }
}