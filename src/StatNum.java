
public class StatNum {

    /**
     * @param : An integer
     * @param : An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        // ��λͳ�ƣ�����ͳ����λ��ǧλ����λ��ʮλ����λ��k���ֵĴ���
        int result = 0;
        String nStr = n + "";
        int length = nStr.length();
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = nStr.charAt(i) - 48;
        }
        for(int i = 0; i < length; i++) {
            //��λ������0������0�������
            if(k == 0 && i == 0) {
                if(length == 1) {
                    return 1;
                } else {
                    continue;
                }
            } 
            for(int m = 0; m < i; m ++) {
                result += array[m] * Math.pow(10, length - m - 2);
            }
            if(k > array[i]) {
                continue;
            } else if(k < array[i]) {
                
                int increment = 1;
                for(int j = i + 1; j < length; j++) {
                    increment *= 10;
                }
                result += increment;
            } else {
                for(int j = i + 1; j < length; j++) {
                    result += array[j] * Math.pow(10, length - j - 1);
                }
                result += 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(digitCounts(0, 9));
    }
}
