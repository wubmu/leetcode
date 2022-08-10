package demo;

public class Main10 {
    public static void main(String[] args) {
        int d = test();
        System.out.println(d);
    }

    public static int test(){
        int a =1 ;
        try {
            a =2;
            return a;
        }catch (Exception e){
            a =3;
            return a;
        }finally {
            a =4;
            System.out.print("node+");
        }
    }
}
