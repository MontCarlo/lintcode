import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title: MinStack
 * Description: ʵ��һ������ȡ��Сֵmin������ջ��min���������ص�ǰջ�е���Сֵ�� ��ʵ�ֵ�ջ��֧��push��pop �� min ���������в���Ҫ����O(1)ʱ�������
 * Company: ��������Ԫ����Ϣ�������޹�˾
 *
 * @author maxiao
 * @version 1.0
 * @date 2018��5��22�� ����12:25:03
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
