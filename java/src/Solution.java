class Solution{
    public static void main(String[] args) {

        Solution father = new Solution();
        Child child = new Child();
        try {
            father.test();
            child.test();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test() throws RuntimeException{
        System.out.println("father");
    }
    static class  Child extends Solution{
        @Override
        public void test() throws RuntimeException {
            System.out.println("child");
        }
    }
}


