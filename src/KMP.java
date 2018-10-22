
public class KMP {
    /**
     * kmp算法求字符串第一次出现的位置
     * @param source
     * @param target
     * @return
     */
    public int strStr(String source, String target) {
        // write your code here
        if(null == source || null == target) {
            return -1;
        }
        int n = source.length();
        int m = target.length();
        if(m == 0) {
            return 0;
        }
        if(m > n) {
            return -1;
        }
        int[] next = makeNext(target);
        for(int i = 0, q = 0; i < n; i++) {
            while(q > 0 && target.charAt(q) != source.charAt(i)) {
                q = next[q - 1];
            }
            if(target.charAt(q) == source.charAt(i)) {
                q ++;
            } 
            if(q == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
    
    public int[] makeNext(String target) {
        int m = target.length();
        int[] next = new int[m];
        next[0] = 0;
        for(int q = 1, k = 0; q < m; q ++) {
            while(k > 0 && target.charAt(q) != target.charAt(k)) {
                k = next[k - 1];
                
            }
            if(target.charAt(q) == target.charAt(k)) {
                k ++;
            }
            next[q] = k;
        }
        for(int i : next) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println();
        return next;
    }
    
    public static void main(String[] args) {
        String source = "abcdabzabcdabc";
        String target = "abcdabd";
        KMP kmp = new KMP();
        System.out.println(kmp.strStr(source, target));
    }
}
