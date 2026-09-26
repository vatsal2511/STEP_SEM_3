package STEP_SEM_3.Week_7_Assignment;

// Domain Class
class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.count = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }
}

// Main Driver Class
public class CartApp {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item Count: " + cart.getItemCount());
    }
}
