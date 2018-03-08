package a2jedi;


public interface MenuItem {
	String getName();
	IngredientPortion[] getIngredients();
	int getCalories();
	double getCost();
	boolean getIsVegetarian();
}
