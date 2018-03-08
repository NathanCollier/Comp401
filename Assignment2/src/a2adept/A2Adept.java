package a2adept;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// Your code goes here.
		int numberOfIngredients = s.nextInt();


		String[] nameIngredient = new String[numberOfIngredients];
		double[] priceOunce = new double[numberOfIngredients];
		boolean [] vegOrNot = new boolean[numberOfIngredients];
		int [] caloriesOunce = new int[numberOfIngredients];

		for (int i = 0; i < numberOfIngredients; i++){
			nameIngredient[i] = s.next();
			priceOunce[i] = s.nextDouble();
			vegOrNot[i] = s.nextBoolean();			
			caloriesOunce[i] = s.nextInt();	
		}

		int numOfDish = s.nextInt();
		for (int n = 0; n < numOfDish; n++){
			String menuItemName = s.next(); 
			
			int numOfDishIngredients = s.nextInt();
			boolean isVeg = true;
			int itemCalories = 0;
			double itemPrice = 0;
			for(int t = 0; t < numOfDishIngredients; t++){
				String nameDishIngredient = s.next();
				int ingredientIndex = 0;
				while (nameIngredient[ingredientIndex].equals(nameDishIngredient)== false){
					ingredientIndex++;
				}

				double ouncesNeeded = s.nextDouble();
				itemCalories += (caloriesOunce[ingredientIndex]*ouncesNeeded);
				
				itemPrice = (priceOunce[ingredientIndex]*ouncesNeeded);
				
				
				if(vegOrNot[ingredientIndex]==false){
				isVeg = false;
				}
		
		}System.out.println(menuItemName + ":");
		itemCalories = ((int)(itemCalories + 0.5));
		itemPrice = ((int)((itemPrice*100.0)+0.5))/100.0;
		System.out.println(itemCalories + " calories");
		System.out.println("$" + itemPrice);
		if (isVeg == true){
			System.out.println("Vegetarian");
		} else {
			System.out.println("Non-Vegetarian");
		}
		}





	}

}

