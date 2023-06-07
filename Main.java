class Product {
    private String id;
    private String name;
    private String type;
    private double price;
    private double amount;

    public Product(String id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount =0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setType(String type) {
        this.type = type;
        return type;
    }

    public double setPrice(double price) {
        this.price = price;
        return price;
    }
    public double getAmount() {
        return amount;
    }

    public double setAmount(double amount) {
        this.amount = amount;
        return amount;
    }


    @Override
    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nType: "+type+"\nPrice: "+price+"\nAmount: "+(price+amount);
    }
}

class FreshFruit extends Product {
    private double weight;

    public FreshFruit(String id, String name, String type, double price, double weight) {
        super(id, name, type, price);
        this.weight = weight;
    }

    public double setWeight(double weight) {
        this.weight = weight;
        return weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWeight: "+weight+" grams";
    }
}

class PackagedItem extends Product {
    private int quantity;
    private String useByDate;

    public PackagedItem(String id, String name, String type, double price, int quantity, String useByDate) {
        super(id, name, type, price);
        this.quantity = quantity;
        this.useByDate = useByDate;
        setAmount(price*0.1);
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }


    public String setUseByDate(String useByDate) {
        this.useByDate = useByDate;
        return useByDate;
    }

    public String getUseByDate() {
        return useByDate;
    }

    @Override
    public String toString() {
        return super.toString()+"\nQuantity: " + quantity+"\nUse-By Date: "+useByDate;
    }
}


// main class
// public class Main{
//     public static void main(String[] args) {
//         FreshFruit apple = new FreshFruit("F001", "Apple", "Fruit", 1.5, 100);
//         PackagedItem milk = new PackagedItem("P001", "Milk", "Dairy", 2.5, 2, "12/12/2020");

//         System.out.println(apple);
//         System.out.println();
//         System.out.println(milk);
//     }
// }

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermarket {
    private List<Product> products;

    public Supermarket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProductMenu() {
        System.out.println("Product Menu:");
        for (Product product : products) {
            System.out.println(product);
            System.out.println();
        }
    }

    public double calculateTotalAmount(List<String> selectedProductIds) {
        double totalAmount = 0.0;
        for (Product product : products) {
            if (selectedProductIds.contains(product.getId())) {
                totalAmount += product.getAmount();
            }
        }
        return totalAmount;
    }

    public double calculateTotalTax(List<String> selectedProductIds) {
        double totalTax = 0.0;
        for (Product product : products) {
            if (selectedProductIds.contains(product.getId())) {
                totalTax += product.getAmount() - product.getPrice();
            }
        }
        return totalTax;
    }

    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();

        // Add fresh fruits to the supermarket
        supermarket.addProduct(new FreshFruit("F001", "Apple", "Fruit", 1.5, 100));
        supermarket.addProduct(new FreshFruit("F002", "Banana", "Fruit", 0.5, 150));
        supermarket.addProduct(new FreshFruit("F003", "Orange", "Fruit", 1.0, 200));
        supermarket.addProduct(new FreshFruit("F004", "Grapes", "Fruit", 2.0, 250));
        supermarket.addProduct(new FreshFruit("F005", "Watermelon", "Fruit", 5.0, 500));

        // Add packaged items to the supermarket
        supermarket.addProduct(new PackagedItem("P001", "Milk", "Dairy", 2.5, 2, "12/12/2020"));
        supermarket.addProduct(new PackagedItem("P002", "Bread", "Bakery", 1.5, 1, "15/12/2020"));
        supermarket.addProduct(new PackagedItem("P003", "Eggs", "Dairy", 3.0, 12, "10/12/2020"));
        supermarket.addProduct(new PackagedItem("P004", "Chocolate", "Snacks", 1.0, 10, "20/12/2020"));
        supermarket.addProduct(new PackagedItem("P005", "Chips", "Snacks", 2.0, 5, "25/12/2020"));

        // Display the product menu
        supermarket.displayProductMenu();

        // Ask users to select products
        Scanner scanner = new Scanner(System.in);
        List<String> selectedProductIds = new ArrayList<>();
        String input;
        do {
            System.out.print("Enter the ID of the product you want to buy (or 'done' to finish): ");
            input = scanner.nextLine();
            if (!input.equals("done")) {
                selectedProductIds.add(input);
            }
        } while (!input.equals("done"));

        // Calculate and display the docket
        System.out.println("Docket:");
        double totalAmount = supermarket.calculateTotalAmount(selectedProductIds);
        double totalTax = supermarket.calculateTotalTax(selectedProductIds);
        System.out.println("Total Amount Due: " + totalAmount);
        System.out.println("Total Tax: " + totalTax);

        scanner.close();
    }
}
