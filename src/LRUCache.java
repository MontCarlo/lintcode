import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 
 * Title: LRUCache
 * Description: ʵ��lru������ԣ���Ҫ�������¼�����map���ٲ�ѯ��
 * LRU�������ӻ��߷��ʵĶ����ŵ���ǰ��
 *
 * @author maxiao
 * @version 1.0
 * @date 2018��10��23�� ����2:03:05
 *
 */
public class LRUCache {
    
    LinkedList<Integer> keyList;
    
    Map<Integer, Integer> map;
    
    int capacity;
    /*
    * @param capacity: An integer
    */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        map = new HashMap<Integer, Integer>(capacity);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        Integer value = map.get(key);
        if(value == null) {
            return -1;
        }
        keyList.remove(new Integer(key));
        keyList.addFirst(key);
        return value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if(map.containsKey(key)) {  
            map.remove(key);
            keyList.remove(new Integer(key));
        } else if (keyList.size() == capacity) {
            Integer removed = keyList.removeLast();
            map.remove(removed);
        }
        keyList.addFirst(key);
        map.put(key, value);
    }
}
