package a3adept;

public class MenuItemImpl	implements MenuItem {
	private String _name;
	private IngredientPortion[] _ingredientArray;
	public MenuItemImpl(String name, IngredientPortion[] ingredients){
		_name = name;
		_ingredientArray = ingredients;
		if (_name == null){
			throw new RuntimeException("The name is null");
		}
		for (int n = 0; n < _ingredientArray.length; n++){
			if (_ingredientArray[n] == null){
				throw new RuntimeException("One value in the array is null");
			}
		}
	}
	public String getName() {
		return _name;
	}

	
	public IngredientPortion[] getIngredients() {
		return _ingredientArray;
	}

	
	public int getCalories() {
		double sum = 0;
		for (int i = 0; i < _ingredientArray.length; i++){
			
			sum +=_ingredientArray[i].getIngredient().getCaloriesPerOunce() * _ingredientArray[i].getAmount();
			
		}
		return ((int)(sum+0.5));
	}

	
	public double getCost() {
		return ((int)((this.getCost()*100.0)+0.5))/100.0;
	}

	
	public boolean getIsVegetarian() {
		return false;
	}

}
