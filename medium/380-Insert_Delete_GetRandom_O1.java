/**
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
**/
class RandomizedSet {

    List<Integer> data;
    Map<Integer, Integer> pos;
    Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        data = new ArrayList<>();
        pos = new HashMap<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(pos.containsKey(val)) {
            return false;
        }
        pos.put(val, data.size());
        data.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!pos.containsKey(val)) {
            return false;
        }
        int lastVal = data.get(data.size() - 1);
        if(val == lastVal) {
            data.remove(data.size() - 1);
            pos.remove(val);
        } else {
            int targetPos = pos.get(val);
            data.set(targetPos, lastVal);
            data.remove(data.size() - 1);
            pos.put(lastVal, targetPos);
            pos.remove(val);
        }

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(data.size() == 0) {
            return -1;
        }
        int next = r.nextInt(data.size());
        return data.get(next);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
