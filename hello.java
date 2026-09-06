class Hello {
    int a, b, res;

    void sum() {
        res = a + b;
        System.out.println("Sum = " + res);
    }

    public static void main(String[] args) {
        Hello obj = new Hello();
        obj.a = 10;
        obj.b = 20;
        obj.sum();

        Hello obj2 = new Hello();
        obj2.a = 5;
        obj2.b = 15;
        obj2.sum();
    }
}
