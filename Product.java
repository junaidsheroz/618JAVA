public class Product {
    private String id;
    private String name;
    private String type;
    private double price;
    private double amount;

    public Product(String id, String name, String type, double price, double amount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
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


    @Override
    public String toString() {
        return "ID: "+id+"\nName: "+name+"\nType: "+type+"\nPrice: "+price+"\nAmount: "+amount;
    }
}

class FreshFruit extends Product {
    private double weight;

    public FreshFruit(String id, String name, String type, double price, double weight) {
        super(id, name, type, price, price);
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
};

class PackagedItem extends Product {
    private int quantity;
    private String useByDate;

    public PackagedItem(String id, String name, String type, double price, int quantity, String useByDate) {
        super(id, name, type, price, price+(price*0.1));
        this.quantity = quantity;
        this.useByDate = useByDate;
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
