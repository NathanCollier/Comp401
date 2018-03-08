package a3jedi;

public class IngredientPortionImpl  implements IngredientPortion {
	private Ingredient _ingredientName;
	private double _amount;


	public IngredientPortionImpl(Ingredient ingredientName, double amount){
		_ingredientName = ingredientName;
		_amount = amount;
		if (ingredientName == null){
			throw new RuntimeException("The name is null");
		}
		if (amount < 0){
			throw new RuntimeException("The amount is negative");
		}
	}
	public Ingredient getIngredient() {
		return _ingredientName;
	}

	public double getAmount() {
		return _amount;
	}

	public String getName() {
		return _ingredientName.getName();
	}

	public boolean getIsVegetarian() {	
		return _ingredientName.getIsVegetarian();
	}

	public double getCalories() {
		return _ingredientName.getCaloriesPerOunce()*_amount;
	}

	public double getCost() {
		return _ingredientName.getPricePerOunce()*_amount;
	}

	public IngredientPortion combine(IngredientPortion other) {	
		if (other == null){
			return this;
		}
		if (!this.getName().equals(other.getName()) ){
			throw new RuntimeException("These ingredients are not the same");
		}
			return new IngredientPortionImpl(this.getIngredient(),this.getAmount() + other.getAmount());
		}

	}
