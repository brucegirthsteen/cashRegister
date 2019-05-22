import java.util.EnumMap;
//import java.util.Random;
public class Change {

	private boolean isZero;
	private EnumMap<MoneyType, Integer> moneyMap;
//	private Random rand;
	public Change (){
		moneyMap = new EnumMap<>(MoneyType.class);
		for(MoneyType mt : MoneyType.values()){
			moneyMap.put(mt, 0);
		}
		isZero = true;
//		rand = new Random();
	}
	public void getChange(int changeNeeded ){	
		for (MoneyType mt : MoneyType.values()) {
   			while (changeNeeded >= mt.getValue()) {
        		changeNeeded -= mt.getValue();
        		this.addValue(mt);
    		}		
		}
		//return theChange;
	}
	public void getRandomChange(int changeNeeded) {

		MoneyType temp;
		while( changeNeeded > 0){
			temp = MoneyType.getRandomType();
			if( changeNeeded >= temp.getValue()){
				changeNeeded -= temp.getValue();
				this.addValue(temp);
			}
		}
		//return change;
	}
	private void addValue(MoneyType mt){
		int temp = moneyMap.get(mt);
		moneyMap.put(mt, (temp + 1));
		isZero = false;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		int temp = moneyMap.get(MoneyType.HUNDRED);
		if( temp > 1)
			sb.append(temp + " Hundreds,");
		else if(temp == 1)
			sb.append(temp + " Hundred,");
		temp = moneyMap.get(MoneyType.FIFTY);
		if(temp > 1)
			sb.append(temp + " Fifties,");
		else if(temp == 1)
			sb.append(temp + " Fifty,");
		temp = moneyMap.get(MoneyType.TWENTY);
		if(temp > 1)
			sb.append(temp + " Twenties,");
		else if(temp == 1)
			sb.append(temp + " Twenty,");
		temp = moneyMap.get(MoneyType.TEN);
		if(temp > 1)
			sb.append(temp + " Tens,");
		else if(temp == 1)
			sb.append(temp + " Ten,");
		temp = moneyMap.get(MoneyType.FIVE);
		if(temp > 1)
			sb.append(temp + " Fives,");
		else if(temp == 1)
			sb.append(temp + " Five,");
		temp = moneyMap.get(MoneyType.ONE);
		if(temp > 1)
			sb.append(temp + " Ones,");
		else if(temp == 1)
			sb.append(temp + " One,");
		temp = moneyMap.get(MoneyType.QUARTER);
		if(temp > 1)
			sb.append(temp + " Quarters,");
		else if(temp == 1)
			sb.append(temp + " Quarter,");
		temp = moneyMap.get(MoneyType.DIME);
		if(temp > 1)
			sb.append(temp + " Dimes,");
		else if(temp == 1)
			sb.append(temp + " Dime,");
		temp = moneyMap.get(MoneyType.NICKEL);
		if(temp > 1)
			sb.append(temp + " Nickels,");
		else if(temp == 1)
			sb.append(temp + " Nickel,");
		temp = moneyMap.get(MoneyType.PENNY);
		if(temp > 1)
			sb.append(temp + " Pennies,");
		else if(temp == 1)
			sb.append(temp + " Penny,");

		if(isZero == true){
			sb.append("Zero");
		}
		if(sb.charAt(sb.length() - 1) == ',')
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}	
	
}