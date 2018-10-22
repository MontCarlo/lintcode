import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title: Trie
 * Description: 
 *  字典树，实现插入、查找（含前缀查找）、删除，Node节点含count属性，也可计数
 * @author maxiao
 * @version 1.0
 * @date 2018年10月22日 下午8:15:15
 *
 */
public class Trie {
    public Node root;

    class Node {
        public int count = 0;

        public Map<Integer, Node> children = new HashMap<Integer, Node>();
        
        public boolean containsKey(Integer i) {
            return children.containsKey(i);
        }
        
        public Node get(Integer i) {
            return children.get(i);
        }
        
        public Node put(Integer i, Node node) {
            return children.put(i, node);
        }
        
        public int childrenSize() {
            return children.size();
        }
        
        public Node remove(Integer i) {
            return children.remove(i);
        }
    }

    public Trie() {
        // do intialization if necessary
        root = new Node();
    }

    /*
     * @param word: a word
     * 
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int cIndex = c - 97;
            if (currentNode.containsKey(cIndex)) {
                currentNode = currentNode.get(cIndex);

            } else {
                Node node = new Node();
                currentNode.put(cIndex, node);
                currentNode = node;
            }
            if (i == word.length() - 1) {
                currentNode.count++;
            }
        }
    }

    /*
     * @param word: A string
     * 
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int cIndex = c - 97;
            if (currentNode.containsKey(cIndex)) {
                currentNode = currentNode.get(cIndex);
            } else {
                return false;
            }
        }
        if (currentNode.count > 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * @param prefix: A string
     * 
     * @return: if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        Node currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int cIndex = c - 97;
            if (currentNode.containsKey(cIndex)) {
                currentNode = currentNode.get(cIndex);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public boolean remove(String word) {
        //记录各个位置的前缀存不存在
        boolean[] flags = new boolean[word.length()];
        Node currentNode = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int cIndex = c - 97;
            if(currentNode.containsKey(cIndex)) {
                currentNode = currentNode.get(cIndex);
                flags[i] = currentNode.count != 0;
            } else {
                return false;
            }
        }
        if(currentNode.count != 0) {
            //如果该节点既没有子节点，自己的count也是0，那就要保证叶子节点的count 大于0
            if(currentNode.childrenSize() == 0) {
                int num = 0;
                for(int i = 0; i < flags.length; i++) {
                    if(flags[i]) {
                        num = i;
                    }
                }
                Node tempNode = root;
                for(int i = 0; i < num; i++) {
                    int cIndex = word.charAt(i) - 97;
                    tempNode = tempNode.get(cIndex);
                }
                int rmIndex = word.charAt(num) - 97;
                tempNode.remove(rmIndex);
            } else {
                currentNode.count --;
            }
        }
        return true;
    }
}
