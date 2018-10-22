import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title: MinStack
 * Description: 实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。 你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成
 * Company: 北京华宇元典信息服务有限公司
 *
 * @author maxiao
 * @version 1.0
 * @date 2018年5月22日 上午12:25:03
 *
 */
public class MinStack {
    List<Integer> array;

    List<Integer> min;

    int size = 0;

    public MinStack() {
        // do intialization if necessary
        array = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }

    /*
     * @param number: An integer
     * 
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        array.add(number);
        if (size == 0) {
            min.add(number);
        } else if (min.get(size - 1) > number) {
            min.add(number);
        } else {
            min.add(min.get(size - 1));
        }
        size++;
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int last = array.get(size - 1);
        array.remove(--size);
        min.remove(size);
        return last;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min.get(size - 1);
    }
}
