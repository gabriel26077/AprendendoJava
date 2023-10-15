public class RecursiveFactorial{
    public static void main(String[] args){

        if(args.length < 1){
            System.out.println("You must provide a number as argument!");
        }
        
        try{
            int n = Integer.parseInt(args[0]);
            long  n_factorial = calculateFactorial(n);
            System.out.println(n + "! = " + n_factorial);
        } catch (NumberFormatException e){
            System.out.println("The argument provided are not a valid number :(");
        }

    }

    public static long calculateFactorial(int n){
        if(n == 0){
            return 1;
        } else {
            return n * calculateFactorial(n-1);
        }
    }

}