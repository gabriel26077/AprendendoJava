public class ConsoleSum{
	public static void main( String[] args){
		
		if( args.length < 2){
			System.out.println("You must provide two numbers as arguments!");
			return;
		}

		try{

			double number1 = Double.parseDouble(args[0]);
			double number2 = Double.parseDouble(args[1]);

			double sum = number1 + number2;

			System.out.println(number1 + " + " + number2 + " = " + sum);

		} catch (NumberFormatException e){
			System.out.println("The arguments provided are not valid numbers :(");
		}

		
	}
}