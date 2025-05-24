class TimeMap {
    HashMap<String,List<Integer>> keyToTime;
    HashMap<String,String> timeToValue;
    
    public TimeMap() {
        keyToTime = new HashMap<>();
        timeToValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (keyToTime.get(key) == null) {
            keyToTime.put(key,new ArrayList<>());
        }
        List<Integer> times = keyToTime.get(key);
        times.add(timestamp);
        keyToTime.put(key,times);
        
        timeToValue.put(key+"#"+timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        List<Integer> times = keyToTime.get(key);
        if(times == null) return new String("");
        
        int prevOrEqualTime = bs(times, timestamp);
        // System.out.println(prevOrEqualTime);

        return timeToValue.getOrDefault(key+"#"+prevOrEqualTime, "");
    }


    public int bs(List<Integer> times, int target) {
        int start = 0, end = times.size()-1;
        int ans = -1;

        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            int midVal = times.get(mid);
            
            if(midVal < target) {
                start = mid +1;
                ans = mid;
            }else if(midVal > target) {
                end = mid -1;
            }else {
                return midVal;
            } 
        }
        return ans == -1 ? -1 : times.get(ans);
    }
}

