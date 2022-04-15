package problem_2022.腾讯;

import java.io.*;

public class Main3 {
    private static double A = 0;
    private static double B = 0;
    private static double C = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            String[] params = br.readLine().split(" ");
            A = Double.parseDouble(params[0]);
            B = Double.parseDouble(params[1]);
            C = Double.parseDouble(params[2]);

            if (A*A - 2*A*B*C <0){
                System.out.println(0);
            }else {
                double lb = (A - Math.sqrt(A*A - 2 * A*B*C)) / B;
                double ub = (A + Math.sqrt(A*A - 2*A*B*C)) / B;
                System.out.println(f(ub) - f(lb));
            }

        }


    }

    private static double f(double y){
        return -y*y*y / (6*A) + y*y /(2*B) - C*y/B;
    }

}
