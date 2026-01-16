class DinnerPlates {
    int maxSize;
    int maxIdx = -1;
    public DinnerPlates(int maxSize) {
        this.maxSize = maxSize;
    }
    
    HashMap<Integer,Stack<Integer>> map = new HashMap<>();
    TreeSet<Integer> partialStacks = new TreeSet<>((a,b)->(a-b));
    HashSet<Integer> emptyStacks = new HashSet<>();

    public void push(int val) {
        if(maxIdx == -1 || (partialStacks.size() == 0 && map.get(maxIdx).size() == maxSize)) {
            maxIdx++;
            Stack<Integer> newSet = new Stack<>();
            newSet.add(val);
            map.put(maxIdx, newSet);

            if(emptyStacks.contains(maxIdx)) emptyStacks.remove(maxIdx);

        }else if((partialStacks.size() == 0 && map.get(maxIdx).size() != maxSize)) {
            Stack<Integer> currSet = map.get(maxIdx);
            currSet.add(val);
            map.put(maxIdx, currSet);
            if(emptyStacks.contains(maxIdx)) emptyStacks.remove(maxIdx);
            
        }else {
            int smallestIdx = partialStacks.first();
            Stack<Integer> currSet = map.get(smallestIdx);
            currSet.push(val);

            if(currSet.size() == maxSize) {
                partialStacks.remove(smallestIdx);
                
            }
            if(emptyStacks.contains(smallestIdx)) emptyStacks.remove(smallestIdx);
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
        if(!partialStacks.contains(index)) partialStacks.add(index);

        if(currSet.isEmpty()) emptyStacks.add(index);

        if(currSet.isEmpty() && index == maxIdx) {
            while(emptyStacks.contains(maxIdx-1)) maxIdx--;
            maxIdx--;
        }

        return val;
    }
}