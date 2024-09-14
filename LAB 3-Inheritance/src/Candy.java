public class Candy extends Dessert{

    // initializing weight and pricePerPound to be final since we don't need to change them in the program later
    private final double weight;
    private final double pricePerPound;
    // totalCost needs to be changed in the program later so we cannot assign it as final here
    private double totalCost;

    // Candy constructor takes a String for the name and doubles for weightInPound and price per pound
    public Candy (String name, double weightInPound, double price){
        super(name); // using super to call name from Dessert

        // weigntInPound and price is given while calling the Candy constructor
        this.weight = weightInPound;
        this.pricePerPound = price;
    }

    public double getWeightInPounds()
    {
        return weight;
    }

    public double getPricePerPound()
    {
        return pricePerPound;
    }

    // getPrice() calculates the totalCost of the Candy and returns the value
    @Override
    public double getPrice() {
        totalCost = pricePerPound * weight;
        return totalCost;
    }
}
