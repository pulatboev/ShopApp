import java.util.Scanner;

public class ShopApp {
    public static void main(String[] args) {
        System.out.println("Student Number: 2370153");
        Scanner scanner = new Scanner(System.in);

        Product[] products = new Product[5];
        products[0] = new Product("Product1", 10, 5.0);
        products[1] = new Product("Product2", 20, 8.0);
        products[2] = new Product("Product3", 15, 12.0);
        products[3] = new Product("Product4", 30, 6.0);
        products[4] = new Product("Product5", 25, 10.0);

        int choice;

        do {
            System.out.println("\n1. Display all products");
            System.out.println("2. Buy stock");
            System.out.println("3. Sell stock");
            System.out.println("4. Re-price an item");
            System.out.println("5. Display total value of all stock");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllProducts(products);
                    break;
                case 2:
                    buyStock(products);
                    break;
                case 3:
                    sellStock(products);
                    break;
                case 4:
                    rePriceItem(products);
                    break;
                case 5:
                    displayTotalValue(products);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void displayAllProducts(Product[] products) {
        System.out.println("\nProduct List:");
        for (Product product : products) {
            System.out.println(product.getName() + " - Stock: " + product.getStockLevel() +
                    ", Price: $" + product.getPrice());
        }
    }

    private static void buyStock(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product index to buy stock: ");
        int index = scanner.nextInt();
        System.out.print("Enter the quantity to buy: ");
        int quantity = scanner.nextInt();

        double cost = products[index].buyStock(quantity);
        System.out.println("Stock bought successfully. Cost: $" + cost);
    }

    private static void sellStock(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product index to sell stock: ");
        int index = scanner.nextInt();
        System.out.print("Enter the quantity to sell: ");
        int quantity = scanner.nextInt();

        boolean success = products[index].sell(quantity);
        if (success) {
            System.out.println("Stock sold successfully.");
        } else {
            System.out.println("Insufficient stock to sell.");
        }
    }

    private static void rePriceItem(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product index to re-price: ");
        int index = scanner.nextInt();
        System.out.print("Enter the new price: $");
        double newPrice = scanner.nextDouble();

        products[index].setPrice(newPrice);
        System.out.println("Price updated successfully.");
    }

    private static void displayTotalValue(Product[] products) {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getStockLevel() * product.getPrice();
        }
        System.out.println("Total value of all stock: $" + totalValue);
    }
}
