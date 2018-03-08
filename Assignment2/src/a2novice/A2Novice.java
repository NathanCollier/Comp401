package a2novice;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// Your code goes here.
		int numberOfIngredients = s.nextInt();
		
		int vegNum = 0;
		
		String[] nameIngredient = new String[numberOfIngredients];
		double[] priceOunce = new double[numberOfIngredients];
		boolean [] vegOrNot = new boolean[numberOfIngredients];
		int [] caloriesOunce = new int[numberOfIngredients];
		double cal$Ratio = 0.0;
		
		double highestRatio = Double.NEGATIVE_INFINITY;
		
		double lowestRatio = Double.POSITIVE_INFINITY;
		String lowIngredient = new String();
		String highIngredient = new String();
		for (int i = 0; i < numberOfIngredients; i++){
			nameIngredient[i] = s.next();
			priceOunce[i] = s.nextDouble();
			vegOrNot[i] = s.nextBoolean();
			
				if(vegOrNot[i] == true){
					vegNum++;
				}
			
			caloriesOunce[i] = s.nextInt();
			
				
			double possCal$Ratio = caloriesOunce[i]/priceOunce[i];
			
			if (possCal$Ratio < lowestRatio){
				lowestRatio = possCal$Ratio;
				lowIngredient = nameIngredient[i];
			}
			if (possCal$Ratio > highestRatio){
				highestRatio = possCal$Ratio;
				highIngredient = nameIngredient[i];
			}
		
			
		}	

		System.out.println("Number of vegetarian ingredients: " + vegNum);
		System.out.println("Highest cals/$: " + highIngredient);
		System.out.println("Lowest cals/$: " + lowIngredient);
		}
}

