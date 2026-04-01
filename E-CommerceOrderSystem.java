class Product {
    String name;
    int stock;
    double price;

    Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;

        System.out.println("ProductName: " + name + " Stock: " + stock + " Price: " + price);
    }
}

class User {
    String name;
    String address;

    User(String name, String address) {
        this.name = name;
        this.address = address;

        System.out.println("UserName: " + name + " Address: " + address);
    }
}

class Order {
    Product product;
    User user;
    int quantity;

    Order(Product product, User user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;

        System.out.println("Product: " + product.name + " Quantity: " + quantity);
    }
}

// ✅ Custom Exceptions
class OutOfStockException extends Exception {
    OutOfStockException(String msg) {
        super(msg);
    }
}

class PaymentFailedException extends Exception {
    PaymentFailedException() {
        super("Payment Failed");
    }
}

class OrderProcessingException extends Exception {
    OrderProcessingException() {
        super("Order Processing Failed");
    }
}

class OrderService {

    void placeOrder(Order order) throws OutOfStockException, PaymentFailedException, OrderProcessingException {

        if (order.product.stock <= 0) {
            throw new OutOfStockException("Product Out Of Stock");
        }

        if (Math.random() < 0.5) {
            throw new PaymentFailedException();
        }

        if (Math.random() < 0.2) {
            throw new OrderProcessingException();
        }

        System.out.println("Order Placed Successfully");
    }
}

public class E_CommerceOrderSystem {

    public static void main(String[] args) {

        Product p = new Product("Laptop", 5, 50000);
        User u = new User("Divya", "Chennai");

        Order order = new Order(p, u, 3);
        OrderService service = new OrderService();

        try {
            service.placeOrder(order);
            order.product.stock -= order.quantity;
            System.out.println("Order placed Successfully");
        } 
        catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } 
        catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        } 
        catch (OrderProcessingException e) {
            System.out.println(e.getMessage());
        }
    }
}
