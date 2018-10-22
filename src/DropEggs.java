
public class DropEggs {
    /**
     * @param m: the number of eggs
     * @param n: the number of floors
     * @return: the number of drops in the worst case
     */
    public int dropEggs2(int m, int n) {
        // write your code here
        int[][] square = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            square[i][0] = 0;
            square[i][1] = 1;
        }
        for(int j = 0; j <= n; j++) {
            square[0][j] = 0;
            square[1][j] = j;
        }
        
        for(int i = 2; i <= m; i++) {
            
            for(int j = 2; j <= n; j++) {
                int result = Integer.MAX_VALUE;
                for(int k = 1; k <= j; k++) {
                    int broken = square[i - 1][k - 1];
                    int unbroken = square[i][j - k];
                    int bigger = Math.max(broken, unbroken) + 1;
                    result = Math.min(result, bigger);
                }
                square[i][j] = result;
            }
        }
        return square[m][n];
    }
    
    public static void main(String[] args) {
        System.out.println(new DropEggs().dropEggs2(2, 10));
    }
}
