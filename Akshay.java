class employee{
    String name;
    int age;

    employee(){
        name = "Akshay";
        age = 19;
    }

    employee(String n , int a){
        name = n;
        age = a;
    }

    void display(){
        System.out.println("Employee 1:"  + name + "Age :" + age);
    }


    
}
public class Akshay {
        public static void main(String [] args){
        employee Eobj1 = new employee();
         employee Eobj2= new employee("Aman" , 19);
        
         Eobj1.display();
         Eobj2.display();
        
        //  System.out.println("Employee 1:"  + Eobj1.name + "Age :" + Eobj1.age);
        // System.out.println("Employee 2:"  + Eobj2.name  + "Age :" + Eobj2.age);

        
    }
}

// class employee {
//     String name;
//     int age;

//     // Default constructor
//     employee() {
//         name = "Akshay";
//         age = 19;
//     }

//     // Parameterized constructor
//     employee(String n, int a) {
//         name = n;
//         age = a;
//     }

//     void display() {
//         System.out.println("Employee: " + name + "  Age: " + age);
//     }
// }

// public class Akshay {

//     public static void main(String[] args) {

//         employee Eobj1 = new employee();
//         employee Eobj2 = new employee("Aman", 19);

//         Eobj1.display();
//         Eobj2.display();
//     }
// }

