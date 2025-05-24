class MyHashSet {
    List<Integer> ls;
    public MyHashSet() {
        ls = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!ls.contains(key)) {
            ls.add(key);
        }
    }
    
    public void remove(int key) {
        ls.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return ls.contains(key);
    }
}

