class PDemo {
    int a, b;
    int res;

    void sum() {
        res = a + b;
        System.out.println("Sum = " + res);
    }
}

class Cdemo extends PDemo {

    int c, d;
    int resC;

    Cdemo() {
        a = 10;
        b = 20;

        // Values for child class variables
        c = 9;
        d = 5;
    }

    void sumC() {
        resC = c - d;
        System.out.println("Sub = " + resC);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Cdemo Cobj = new Cdemo();

        Cobj.sum(); 
        Cobj.sumC(); 
    }
}