
public class UglyNum {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        int uglys[] = new int[n];
        uglys[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int nowIndex = 0;
        while(nowIndex < n) {
            int nowUgly = min(min(uglys[idx2] * 2, uglys[idx3] * 3), uglys[idx5] * 5);
            if(nowUgly == uglys[idx2] * 2) {
                idx2 += 1;
            }
            if(nowUgly == uglys[idx3] * 3) {
                idx3 += 1;
            }
            if(nowUgly == uglys[idx5] * 5) {
                idx5 += 1;
            }
            nowIndex += 1;
            uglys[nowIndex] = nowUgly;
        }
        return uglys[n - 1];
    }
    
    public int min(int a, int b) {
        if(a < b) {
            return a;
        }
        return b;
    }
    
    public static void main(String[] args) {
        UglyNum instance = new UglyNum();
        System.out.println(instance.nthUglyNumber(9));
    }
}
