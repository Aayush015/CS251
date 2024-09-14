public class Cookie extends Dessert
{
    private final int number; // final since we don't need to change its value in the program later
    private final double pricePerDozen;
    private double totalCost;

    public Cookie (String name, int number, double price){
        super(name); // calling the name from the Dessert class
        this.number = number;
        this.pricePerDozen = price;
    }

    // gives the number of Cookies
    public int getItemCount()
    {
        return number;
    }

    // gives the price per Dozen
    public double getPricePerDozen()
    {
        return pricePerDozen;
    }

    // gives the totalCost by multiplying the pricePerDozen and the number of items in a dozen
    @Override
    public double getPrice() {
        totalCost = pricePerDozen * number/12;
        return totalCost;
    }
}
