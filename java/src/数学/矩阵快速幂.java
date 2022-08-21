package 数学;

public class 矩阵快速幂 {

    public static int quickPow(int base , int power){
        int ans = 1;
        while (power >0){
            if (power % 2== 0) {
                // 幂为偶数, 直接减半, base 平方
                power /= 2;
                base *= base;
            }else {
                power /=2;
                ans *= base;
                base *= base;
            }

        }
        return ans;
    }
    public static int quickPow1(int base , int power){
        // 位运算
        int ans = 1;
        while (power >0){
            if ((power & 1) == 1) ans *= base;
            power >>=1;
            base*=base;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(quickPow(2,20));
        System.out.println(quickPow1(2,20));
    }
}
