import java.util.Locale;
import java.util.Scanner;

public class Negativos {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números você irá digitar? ");
        int n = sc.nextInt();

        int vect[] = new int[n];

        for(int i = 0; i < n; i++){
            System.out.println("Digite um número: ");
            vect[i] = sc.nextInt();
            }

        System.out.println("NÚMEROS NEGATIVOS:");

        for (int i=0; i<n; i++) {
            if (vect[i] < 0) {
                System.out.printf("%d\n", vect[i]);
            }
        }

        sc.close();
    }
}
