import java.util.Random;
//Custom enum class, with the commonly denominations, as well as there value in cents.
//Used integers to avoid precision loss in floats.  Also provides method to select random
//denominations.  

public enum MoneyType {
	HUNDRED(10000),
	FIFTY(5000),
	TWENTY(2000),
	TEN(1000),
	FIVE(500),
	ONE(100),
	QUARTER(25),
	DIME(10),
	NICKEL(5),
	PENNY(1);

    private final int value;
    private final String description;
	private static Random rand = new Random(1);
    MoneyType(int value) {
        this.value = value;
        this.description = this.name();
    }
	//returns the value of the enum
    public int getValue() {
        return this.value;
    }
	
    public String toString() {
        return this.description;
    }
    //Select random enum and returns it.
    public static MoneyType getRandomType() {
        return values()[rand.nextInt(values().length)];
    }
}