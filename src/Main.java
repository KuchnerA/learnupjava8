import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("myfile.txt");

        Client client = new Client("Maxim", 34, 30_000, 500_000);

        client.connectToFile(file);
        client.save();

        Client c2 = Client.loadFromFile(file);
        c2.save();
        System.out.println(c2);

    }

}
