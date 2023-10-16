import java.io.*;

public class XOREncryption{
    public static void main(String[] args){
        if(args.length == 1 && args[0].equals("--help")){
            System.out.println("Provide a option (encrypt or decrypt), a file name and a key.");
            System.out.println("Example: java XOREncryption encrypt example.txt my_key");
            System.out.println("Example: java XOREncryption decrypt example.txt my_key");
        }

        if(args.length < 3){
            System.out.println("You must provide a file name, a option and a key");
            System.exit(1);
        }

        String option = args[0];
        String inputFileName = args[1];
        String key = args[2];

    

        if(option.equals("encrypt")){
            encryptFile(inputFileName, key);
            System.out.println("File encrypted successfully!");
        }else if(option.equals("decrypt")){
            decryptFile(inputFileName, key);
            System.out.println("File decrypted successfully");
        }else{
            System.out.println("Invalid option, use 'encrypt' or 'decrypt'");
        }
         
    }

    public static void encryptFile(String fileName, String key){
        try{
            FileInputStream inputStream = new FileInputStream(fileName);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] keyBytes = key.getBytes();
            int keyLength = keyBytes.length;
            int bytesRead;
            int keyIndex = 0;

            byte[] buffer = new byte[1024];


            while ((bytesRead = inputStream.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] = (byte) (buffer[i] ^ keyBytes[keyIndex]);
                    keyIndex = (keyIndex + 1) % keyLength;
                }
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();

            byte[] encryptedData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();

            FileOutputStream outputStream = new FileOutputStream(fileName);
            outputStream.write(encryptedData);
            outputStream.close();

        }catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static void decryptFile(String fileName, String key){
        encryptFile(fileName, key);
    }
}
