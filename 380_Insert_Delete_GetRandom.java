c class RandomizedSet {
    
    private HashMap<Integer, Integer> key = null;
    private HashMap<Integer, Integer> value = null;
    int count;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        key = new HashMap<Integer, Integer>();
        value = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(key.containsKey(val)) {
            return false;
        } else {
            key.put(val, count);
            value.put(count, val);
            count = key.size();
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!key.containsKey(val)) {
            return false;
        } else {
            int valueKey = key.get(val);
            key.remove(val);
            if(valueKey != value.size() - 1) {
                value.put(valueKey, value.get(value.size() - 1));
                key.put(value.get(value.size() - 1), valueKey);
                value.remove(value.size() - 1);
            } else {
                value.remove(valueKey);
            }
            count = key.size();
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        int n = r.nextInt(key.size());
        return value.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


