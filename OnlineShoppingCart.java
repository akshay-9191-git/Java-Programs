import java.util.Scanner;
class Product{
    int productId;
    String productName;
    double price;
    int quantity;

    Product(int productId , String productName , double price , int quantity){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    double calculateCost(){
        return price*quantity;
    }

    void display(){
        System.out.println(productId + "\t" + productName + "\t" + quantity + "\t" + calculateCost());
    }
}


public class OnlineShoppingCart {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for(int i=0;i<n;i++){
            System.out.println("\nProduct " +(i+1));

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            products[i] = new Product(id , name , price , quantity);
        }
        double total = 0;
        System.out.println("Shopping Cart");
        System.out.println("ID\tName\tPrice\tQuantity\tCost");

        for(Product product : products){
            product.display();
            total += product.calculateCost();
        }
        System.out.println("\nTotal Bill: " + total);

        if(total > 5000){
            double discount = total * 0.10;
            double finalAmount = total-discount;

            System.out.println("Discount: " +discount);
            System.out.println("Final Bill: "+ finalAmount);
        }else{
            System.out.println("No discount applicable.");
            System.out.println("Final Bill: " + total);
        }
    }
}
