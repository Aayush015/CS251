# Inheritance and Dessert Shop

**Author:** Aayush Kafle  
**Class:** CS-251L-005 (Spring 2022)  
**Date Submitted:** 02/19/2022

## Description

This lab demonstrates the use of inheritance in Java by implementing a `Dessert` class hierarchy. Different types of desserts (such as `Candy`, `Cookie`, `IceCream`, and `Sundae`) are represented as subclasses of an abstract base class `Dessert`. Each subclass has unique properties and methods, such as weight or price per dozen, and calculates the total price based on these attributes. A `Sundae` can be created by combining two `Dessert` objects, showcasing composition in addition to inheritance.

### Class Structure

- **`Dessert` (Abstract Base Class):** Represents any dessert item, providing common attributes and methods such as `name` and `getPrice()`.
- **`Candy`:** Represents candy by weight and price per pound.
- **`Cookie`:** Represents cookies, with the price calculated based on the number of cookies and price per dozen.
- **`IceCream`:** Represents ice cream, with a flat price.
- **`Sundae`:** Combines two dessert objects (typically an ice cream with a topping) into a single sundae.

### Key Concepts:

- Inheritance: The subclasses inherit the properties and methods of the `Dessert` class.
- Polymorphism: The `getPrice()` method is overridden in each subclass to calculate the dessert's total price based on its specific properties.
- Composition: The `Sundae` class demonstrates how a dessert can be composed of other dessert objects.

## How to Run

Compile and run the `DessertTest` class to see the desserts and their prices in action. The program will:

1. Instantiate various dessert objects like `Candy`, `Cookie`, `IceCream`, and `Sundae`.
2. Combine desserts into sundaes.
3. Output the names and prices of the desserts.

### Example Commands:

```bash
javac DessertTest.java
java DessertTest
```

### Example Outputs:
Let's play with desserts!<br>
1.33 pounds of Gummy Worms at $0.89/lb<br>
4 Oatmeal Raisin Cookies at $3.99/dozen<br>
Vanilla Ice Cream topped with Chocolate Sprinkles<br>
Strawberry Ice Cream topped with Oreos<br>
Vanilla Ice Cream topped with Strawberry Ice Cream topped with Oreos<br>
Vanilla Ice Cream topped with Chocolate Sprinkles topped with Gummy Worms<br>
Carrot Cake<br>
Vanilla Ice Cream topped with Carrot Cake<br>
Vanilla Ice Cream topped with Carrot Cake topped with Vanilla Ice Cream topped with Carrot Cake<br>

Put some desserts into an array and loop over them<br>
Gummy Worms will cost $1.18<br>
Oatmeal Raisin Cookies will cost $1.33<br>
Vanilla Ice Cream will cost $1.05<br>
Chocolate Sprinkles will cost $0.25<br>
Vanilla Ice Cream topped with Chocolate Sprinkles will cost $1.30<br>
Strawberry Ice Cream topped with Oreos will cost $2.70<br>
Vanilla Ice Cream topped with Strawberry Ice Cream topped with Oreos will cost $3.75<br>
Vanilla Ice Cream topped with Chocolate Sprinkles topped with Gummy Worms will cost $2.48<br>
Peanut Butter Fudge will cost $8.98<br>
Chocolate Chip Cookies will cost $1.25<br>
Candy Corn will cost $3.27<br>
Carrot Cake will cost $1.23<br>
Vanilla Ice Cream topped with Carrot Cake will cost $2.28<br>
Vanilla Ice Cream topped with Carrot Cake topped with Vanilla Ice Cream topped with Carrot Cake will cost $4.56