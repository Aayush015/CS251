public class IceCream extends Dessert {

    private final double price; // final since we don't need to change the price later in the program

    // takes name and price as a input
    public IceCream(String name, double price) {
        super(name); // called name from the Dessert class
        this.price = price; // since the given price when the class is called is the price of the IceCream
    }


    @Override
    public double getPrice() {
        return price;
    }
}
