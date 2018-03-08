

import java.util.Scanner;

public class A3Jedi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		scanner(s);
	}

	private static void scanner(Scanner s) {

		int numberOfIngredients = s.nextInt();
		Ingredient[] ingredients = new Ingredient[numberOfIngredients];
		double[] countArray = new double[numberOfIngredients];

		for (int i = 0; i < numberOfIngredients; i++) {
			String tempName = s.next();
			double tempDouble = s.nextDouble();
			Boolean tempBoolean = s.nextBoolean();
			int tempInt = s.nextInt();
			Ingredient ingredientinfo = new IngredientImpl(tempName, tempDouble, tempInt, tempBoolean);
			ingredients[i] = ingredientinfo;
		}
		int menuCount = s.nextInt();
		MenuItem[] menu = new MenuItemImpl[menuCount];

		for (int i = 0; i < menuCount; i++) { 
			String menuName = s.next();
			int ingredCount = s.nextInt();
			IngredientPortion[] tempPortion = new IngredientPortionImpl[ingredCount];
			for (int n = 0; n < ingredCount; n++) {
				String tempIngredient = s.next();
				double tempAmount = s.nextDouble();
				for (int t = 0; t < numberOfIngredients; t++) {
					if ((ingredients[t].getName()).equals(tempIngredient)) {
						tempPortion[n] = new IngredientPortionImpl(ingredients[t], tempAmount);

					}
				}
			}
			menu[i] = new MenuItemImpl(menuName, tempPortion);
		}
		while (true) {
			String orderName = s.next();
			if (orderName.equals("EndOrder")) {
				break;
			}
			for (int i = 0; i < menuCount; i++) {
				if (menu[i].getName().equals(orderName)) {
					IngredientPortion[] tempIngredient = menu[i].getIngredients();

					for (int j = 0; j < tempIngredient.length; j++) {
						for (int k = 0; k < numberOfIngredients; k++) {
							if ((tempIngredient[j].getName()).equals(ingredients[k].getName())) {
								countArray[k] += tempIngredient[j].getAmount();

							}
						}
					}
				}
			}
		}
		System.out.println("The order will require:");

		for (int i = 0; i < numberOfIngredients; i++) {
			double temp = ((int) ((countArray[i]*100.0)+0.5))/100.0;
			System.out.println(temp + " ounces of " + ingredients[i].getName());
		}

	}
}




//package a3jedi;
//
//import java.util.Scanner;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class A3Jedi {
//
//
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//
//		String nameIngredient = new String();
//		boolean vegOrNot = false;
//		double priceOunce = 0.0;
//		int caloriesOunce = 0;
//
//		int numOfIngredients = s.nextInt();
//		Ingredient[] ingredientsInOrder = new Ingredient[numOfIngredients];
//		Map<String,Ingredient>ingredientMap = new HashMap<String,Ingredient>();
//
//		for (int i = 0; i < numOfIngredients; i++){
//			nameIngredient = s.next();
//			priceOunce = s.nextDouble();
//			vegOrNot = s.nextBoolean();			
//			caloriesOunce = s.nextInt();		
//
//			Ingredient myIng = new IngredientImpl(nameIngredient, priceOunce, caloriesOunce, vegOrNot);
//			ingredientMap.put(nameIngredient, myIng);
//			ingredientsInOrder[i] = myIng;
//		}
//
//
//
//		Map<String, MenuItem> menuItemMap = new HashMap<String, MenuItem>();
//		int numOfMenuItems = s.nextInt();
//
//		for (int n = 0; n < numOfMenuItems; n++){
//			String nameDish = s.next();
//			int numIngDish = s.nextInt();
//			IngredientPortion[] ingPortions = new IngredientPortion[numIngDish];
//			for (int t = 0; t < numIngDish; t++){
//				String nameDishIngredient = s.next();
//				double portionDishIngredient = s.nextDouble();
//				IngredientPortion myPortion = new IngredientPortionImpl(ingredientMap.get(nameDishIngredient),portionDishIngredient);
//				ingPortions[t] = myPortion;
//			}
//
//			MenuItem myMenuItem = new MenuItemImpl(nameDish,ingPortions);
//			menuItemMap.put(nameDish, myMenuItem);
//			//map ingredient type to ingredient portion type
//		}
//
//		//Map<String,IngredientPortion>ingredientPortionMap = new HashMap<String, IngredientPortion>();
//
//		Map<Ingredient, IngredientPortion> combinedPortions = new HashMap<Ingredient, IngredientPortion>();
//
//		String nextItem = s.next();
//		while(!nextItem.equals("EndOrder")){
//			MenuItem orderItem = menuItemMap.get(nextItem);
//
//			IngredientPortion[] ingredPortions = orderItem.getIngredients();
//
//			for (int t = 0; t < ingredPortions.length; t++){
//				Ingredient portionIngredient = ingredPortions[t].getIngredient();
//				IngredientPortion orderTotal = combinedPortions.get(orderItem);
//				combinedPortions.put(portionIngredient, ingredPortions[t].combine(orderTotal));
//			}
//			nextItem = s.next();	
//		}
//		System.out.println("The order will require");
//		for (int q=0; q < ingredientsInOrder.length; q++){
//			IngredientPortion orderTotalPortion = combinedPortions.get(ingredientsInOrder[q]);
//			double total = 0;
//			if (orderTotalPortion != null) {
//				total = orderTotalPortion.getAmount();
//			}
//			System.out.println(Math.round(100.0 * total)/100.0 + " ounces of " + ingredientsInOrder[q].getName());
//		}
//	}
//
//
//
//}