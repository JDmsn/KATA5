package kata5;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Histogram <T> {
    
    private final Map<T, Integer> hm = new HashMap<>();

    public Integer get(Object key) {
        return hm.get(key);
    }

    public boolean containsKey(Object key) {
        return hm.containsKey(key);
    }

    public Integer increment(T key) {
        return hm.put(key, hm.containsKey(key)? hm.get(key) + 1 : 1);
    }
    
    public boolean containsValue(Object value) {
        return hm.containsValue(value);
    }
    
    public Set<T> keySet() {
        return hm.keySet();
    }  
}
