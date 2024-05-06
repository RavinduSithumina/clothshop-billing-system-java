import java.util.Scanner;

class ClothingItem {
     String name;
     double price;
     int quantity;

    ClothingItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
}

class DiscountedClothingItem extends ClothingItem {
    public  double discount;

    DiscountedClothingItem(String name, double price, int quantity, double discount) {
        super(name, price, quantity);
        this.discount = discount;
    }
    
    
    public double getPrice() {
        return super.getPrice() * (1 - discount);
    }
}

class ShoppingCart {
    ClothingItem[] items;
    int itemCount;

    ShoppingCart(int capacity) {
        items = new ClothingItem[capacity];
        itemCount = 0;
    }

    void addItem(ClothingItem item) {
        if (itemCount < items.length) {
            items[itemCount++] = item;
            System.out.println("Item added to the cart: " + item.name);
        } else {
            System.out.println("Cart is full. Cannot add more items.");
        }
    }

    void printBill() {
        double total = 0;
        System.out.println("\nShopping Cart:");
        System.out.println("------------------------------");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].name + "\tRS " + items[i].getPrice() + "\tQuantity: " + items[i].quantity);
            total += items[i].getPrice() * items[i].quantity;
        }
        System.out.println("------------------------------");
        System.out.println("Total\tRS " + total);
        System.out.println("------------------------------");
    }
}

public class ClothingStore1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart(10);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Print Bill");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(scanner, cart);
                    break;
                case 2:
                    cart.printBill();
                    break;
                case 3:
                    System.out.println("Thank you for shopping. Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

      static void addItem(Scanner scanner, ShoppingCart cart) {
        System.out.println("\nClothing Categories:");
        System.out.println("1. T-Shirt\tRS 2500.00");
        System.out.println("2. Trouser\tRS 3000.00");
        System.out.println("3. Shirt\tRS 1350.00");
        System.out.println("4. Short\tRS 1500.00");
        System.out.println("5. Skineer\tRS 900.00");

        System.out.print("Enter the category number: ");
        int category = scanner.nextInt();

        ClothingItem item = null;
        switch (category) {
            case 1:
                item = new DiscountedClothingItem("T-Shirt", 2500.00, getQuantity(scanner),0.1);
                break;
            case 2:
                item = new DiscountedClothingItem("Trouser", 3000.00, getQuantity(scanner),0.1);
                break;
            case 3:
                item = new DiscountedClothingItem("Shirt", 1350.00, getQuantity(scanner), 0.1); 
                break;
            case 4:
                item = new DiscountedClothingItem("Short", 1500.00, getQuantity(scanner), 0.1); 
                break;
            case 5:
                item = new DiscountedClothingItem("Skineer", 900.00, getQuantity(scanner), 0.1); 
                break;
            default:
                System.out.println("Invalid category. Please choose a valid category.");
        }

        if (item != null) {
            cart.addItem(item);
        }
    }

     static int getQuantity(Scanner scanner) {
        System.out.print("Enter the quantity: ");
        return scanner.nextInt();
    }
}
