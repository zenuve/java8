package java8practice;

class Apple{
	/**
	 * 
	 */
	private final FilterApplesLambda apple;

	Apple() {
		apple=null;
	}
	/**
	 * @param filterApplesLambda
	 */
	Apple(FilterApplesLambda filterApplesLambda) {
		apple = filterApplesLambda;
	}

	private String color;
	private Integer weight;

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}