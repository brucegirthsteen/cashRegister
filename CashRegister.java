/*Philip Lowe Submission for Pineapple Payments Coding challenge
Program expects minimum of 1 argument for an input file.
Also accepts a 2nd argument for an out put file, but without one given
'output.txt' is used.
Program uses commonly used denominations of currency.  Sorry no $2 bills or 50 cent pieces
*/
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.Math;

public class CashRegister{

	public static void main ( String args[] ){
		try{
			//Declares and create input and output objects and creates default output
			//if one is not given.  Also declares change object and random number generator
			//random divisor is set to 3.
			Scanner input = new Scanner( new File(args[0] ));
			PrintWriter outfile;
			if (args.length == 2){
				outfile = new PrintWriter( new File(args[1]) );
			}
			else
				outfile = new PrintWriter( new File("output.txt"));
			int randDivisor = 3;
			Random rand = new Random();
			Change change;
			//iterate over input, split line into owed and given
			//and calculate change needed.
			//calls change object to find the denominations needed or random
			//denominations needed. then writes to file.  
			//Informs user to amount owed is more than amount given.
			while(input.hasNextLine()){
				String line = input.nextLine();
				String [] numbers = line.split(",");
				change = new Change();
				int owed = convertToCents(Double.parseDouble(numbers[0]));
				int given = convertToCents(Double.parseDouble(numbers[1]));
				int changeNeeded = given - owed;
				System.out.println("Owed: " + owed + " Given: " + given);
				if (changeNeeded < 0){
					outfile.println("Woah, hold up bud.  That is not enough money");
					continue;
				}
				if ( owed % randDivisor == 0) {
					System.out.println("owed is divisable by 3: " + owed);
					change.getRandomChange(given - owed);
				}
				else{
					change.getChange(given - owed);
				}
				outfile.println(change);
			}
			input.close();
			outfile.close();
		}catch(FileNotFoundException e) {
			System.out.println("for proper usage, argument 1: input file, "
				+"argument 2: desired output file(this will overwrite the file),"
				+"default set to output.txt");
			e.printStackTrace();
		}
	}
//convert all money to integers and rounding to nearest integer to avoid any loss of 
//precision from using floating point operations.
	public static int convertToCents(double input){
		double temp = input * 100;
		int cents = (int)Math.round(temp);
		return cents;
	}
}
