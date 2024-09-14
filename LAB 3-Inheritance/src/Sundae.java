public class Sundae extends IceCream
{
    public Sundae(IceCream item, Dessert topping){
        // calls IceCream class and addes the Strings(name of the IceCream and the dessert), and also the price to get the final price of Sundae
        super(item.getName() + " topped with " + topping.getName(), item.getPrice()+ topping.getPrice());
    }

}
