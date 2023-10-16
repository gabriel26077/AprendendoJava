import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TextCaseTool{
    public static void main(String[] args){
        if(args.length == 1 && args[0].equals("--help")){
            System.out.println("\nThis program converts the text of a file to uppercase or lowercase depending on the option passed.\n");
            System.out.println("Pass the file name, like example.txt, and an option:");
            System.out.println("--uppercase or -u\n\tA file named example_up.txt will be created.");
            System.out.println("--lowercase or -l\n\tA file named example_low.txt will be created.\n");
            return;
        }

        if(args.length < 2){
            System.out.println("You must provide a file and an option as arguments.\nUse --help to more infomation");
            return;
        }

        String inputFileName = args[0];
        String option = args[1];

        StringBuilder content = new StringBuilder();

        try{
            
            FileReader reader = new FileReader(inputFileName);
            int charactere;
            
            String outputFileName;

            if(option.equals("-u") || option.equals("--uppercase")){

                outputFileName = inputFileName.split("\\.")[0] + "_up.txt";

                while((charactere = reader.read()) != -1){
                    char upperCaseChar = Character.toUpperCase((char) charactere);
                    content.append(upperCaseChar);
                }
            }else
            if(option.equals("-l") || option.equals("--lowercase")){
                
                outputFileName = inputFileName.split("\\.")[0] + "_low.txt";

                while((charactere = reader.read()) != -1){
                    char upperCaseChar = Character.toLowerCase((char) charactere);
                    content.append(upperCaseChar);
                }
            }else{
                System.out.println("you must pass a valid option like --uppercase or --lowercase");
                return;
            }

            reader.close(); 

            FileWriter writer = new FileWriter(outputFileName);

            writer.write(content.toString());
            
            writer.close();

            System.out.println("Successfully converted file!");
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}