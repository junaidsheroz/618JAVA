// importing the required packages
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Product class with the required attributes and methods
class Product {
    private String id;
    private String name;
    private String type;
    private double price;
    private double amount;

    // constructor for the Product class with the required parameters

    public Product(String id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount =0;
    }

    // getters and setters for the attributes of the Product class
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


    // toString method to display the details of the product. Polymorphism is used here
    @Override
    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nType: "+type+"\nPrice: "+price+"\nAmount: "+(price+amount);
    }
}

// FreshFruit class which extends the Product class. It has the required attributes and methods. FreshFruit class is a subclass of the Product class
// Inheritance is used here
class FreshFruit extends Product {
    // attributes of the FreshFruit class
    private double weight;

    // constructor for the FreshFruit class with the required parameters
    public FreshFruit(String id, String name, String type, double price, double weight) {
        super(id, name, type, price);
        this.weight = weight;
    }

    // getters and setters for the attributes of the FreshFruit class
    public double setWeight(double weight) {
        this.weight = weight;
        return weight;
    }

    public double getWeight() {
        return weight;
    }

    // PolyMorphism is used here. toString method is overridden here
    @Override
    public String toString() {
        return super.toString()+"\nWeight: "+weight+" grams";
    }
}

// PackagedItem class which extends the Product class. It has the required attributes and methods. PackagedItem class is a subclass of the Product class
// Inheritance is used here
class PackagedItem extends Product {
    // PackagedItem class with the following attributes
    private int quantity;
    private String useByDate;

    // constructor for the PackagedItem class with the required parameters
    public PackagedItem(String id, String name, String type, double price, int quantity, String useByDate) {
        super(id, name, type, price);
        this.quantity = quantity;
        this.useByDate = useByDate;
        setAmount(price*0.1);
    }

    // getters and setters for the attributes of the PackagedItem class

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

    // PolyMorphism is used here. toString method is overridden here
    // toString method is overridden here
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


// Supermarket class with the required attributes and methods
// Composition is used here
public class Supermarket {
    // List<Product> products = new ArrayList<>(); is used to store the products in the supermarket
    private List<Product> products;

    // constructor for the Supermarket class
    public Supermarket() {
        products = new ArrayList<>();
    }

    // addProduct method is used to add products to the supermarket
    public void addProduct(Product product) {
        products.add(product);
    }

    // displayMenu method is used to display the products in the supermarket

    public void displayMenu() {
        System.out.println("Product Menu:");
        for (Product product : products) {
            System.out.println(product);
            System.out.println();
        }
    }

    // calculateTotalAmount method is used to calculate the total amount of the selected products

    public double calculateTotalAmount(List<String> selectedProductIds) {
        double totalAmount = 0.0;
        for (Product product : products) {
            if (selectedProductIds.contains(product.getId())) {
                totalAmount += product.getPrice();
            }
        }
        return totalAmount;
    }

    // calculateTotalTax method is used to calculate the total tax of the selected products
    public double calculateTotalTax(List<String> selectedProductIds) {
        double totalTax = 0.0;
        for (Product product : products) {
            if (selectedProductIds.contains(product.getId())) {
                totalTax += product.getAmount();
            }
        }
        return totalTax;
    }

    // main method to run the program. It is used to add products to the supermarket and display the menu
    public static void main(String[] args) {
        // Create a new supermarket object to add products
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
        supermarket.displayMenu();

        // Ask users to select products
        Scanner scanner = new Scanner(System.in);
        // a list to store the selected product ids
        List<String> selectedProductIds = new ArrayList<>();
        // input variable to store the user input
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
        // to display the selected products
        double totalAmount = supermarket.calculateTotalAmount(selectedProductIds);
        double totalTax = supermarket.calculateTotalTax(selectedProductIds);
        double grandTotal = totalAmount + totalTax;
        //  to display Total Amount Due, Total Tax and Grand Total
        System.out.println("Total Amount Due: $ " + totalAmount);
        System.out.println("Total Tax: $ " + totalTax);
        System.out.println("Grand Total: $ " + grandTotal);

        // closing the scanner object. scanner.close() is used always after using the scanner object
        scanner.close();
    }
}
