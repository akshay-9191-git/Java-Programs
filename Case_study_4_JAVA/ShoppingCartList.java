import java.util.ArrayList;

class Cart {
    private ArrayList<String> products = new ArrayList<>();

    public void addProduct(String product) {
        products.add(product);
        System.out.println("Added to cart: " + product);
    }

    public void removeProduct(String product) {
        if (products.remove(product)) {
            System.out.println("Removed from cart: " + product);
        } else {
            System.out.println(product + " is not in the cart.");
        }
    }

    public boolean isInCart(String product) {
        return products.contains(product);
    }

    public void checkProduct(String product) {
        System.out.println(product + (isInCart(product) ? " is in the cart." : " is NOT in the cart."));
    }

    public void displayProducts() {
        System.out.println("\nProducts in cart (" + products.size() + "):");
        if (products.isEmpty()) {
            System.out.println("  (cart is empty)");
        }
        for (String p : products) {
            System.out.println("  - " + p);
        }
    }
}

public class ShoppingCartList {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addProduct("Laptop Bag");
        cart.addProduct("Headphones");
        cart.addProduct("Keyboard");
        cart.displayProducts();
        cart.checkProduct("Headphones");
        cart.checkProduct("Mouse");
        cart.removeProduct("Headphones");
        cart.removeProduct("Mouse");
        cart.displayProducts();
    }
}
