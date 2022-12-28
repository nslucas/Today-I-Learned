import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String path = sc.nextLine();

        Map<String, Integer> votes = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String[] aux = line.split(",");
                String name = aux[0];
                Integer count = Integer.valueOf(aux[1]);
                line = br.readLine();

                if (votes.containsKey(name)) {
                    int votesSoFar = votes.get(name);
                    votes.put(name, count + votesSoFar);
                } else {
                    votes.put(name, count);
                }

            }
            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}