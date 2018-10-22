/**
 * 
 * Title: TailZero
 * Description: �ݹ�ʵ����׳�β����0���������������ת��Ϊ��׳���5�������������
 *
 * @author maxiao
 * @version 1.0
 * @date 2018��2��5�� ����4:20:57
 *
 */
public class TailZero {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long count = 0L;
        
        count += cal(n);
        return count;
        
    }    
    
    public long cal(long n) {
        if(n >= 5) {
            int mi = calmi(n);
            long sum = liancheng(mi);
            n -= sum;
            return cheng5jia1(mi) + cal(n);
        } else {
            return 0;
        }
        
    }
    public int calmi(long n) {
        if(n < 5) {
            return 0;
        }
        long sum = 1;
        int mi = 0;
        do {
            sum *= 5;
            mi += 1;
        } while(sum <= n);
        
        return mi == 0 ? 0 : mi - 1;
    }
    
    public long liancheng(int mi) {
        long result = 1;
        for(int i = 0; i < mi; i++) {
            result *= 5;
        }
        return result;
    }
    
    public long cheng5jia1(int n) {
        long result = 0;
        for(int i = 0; i < n; i++) {
            result = result * 5 + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        TailZero instance = new TailZero();
        System.out.println(instance.trailingZeros(5));
    }
}
