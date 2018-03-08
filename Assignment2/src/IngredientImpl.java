

public class IngredientImpl  implements Ingredient {
	private String _name;
	private double _price;
	private int _calories;
	private boolean _isVegetarian;
	public IngredientImpl(String name, double price, int calories, boolean isVegetarian){
		
		if (name == null){
			throw new RuntimeException("The name is null");
		}
		if (price < 0.0){
			throw new RuntimeException("The price is negative");
		}
		if (calories < 0){
			throw new RuntimeException("The calories are negative");
		}
		_name = name;
		_price = price;
		_calories = calories;
		_isVegetarian = isVegetarian;
		
	}

	
	public String getName() {
		return _name;
	}

	public boolean getIsVegetarian() {
		return _isVegetarian;
	}

	public double getPricePerOunce() {
		return _price;
	}

	public int getCaloriesPerOunce() {	
		return _calories;
	}

	public double getCaloriesPerDollar() {
		return _calories/_price;
	}
		
}
