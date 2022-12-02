import java.util.Locale;
import java.util.Scanner;

public class Soma {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números você irá digitar? ");
        int n = sc.nextInt();
        double[] vect = new double[n];

        for(int i=0; i < n; i++){
            System.out.println("Digite um número: ");
            vect[i] = sc.nextDouble();
        }

        System.out.print("VALORES = ");

        for (int i=0; i<n; i++) {
            System.out.printf("%.1f ", vect[i]);
        }

        double sum = 0;
        for(int i = 0; i < n; i++){
            sum += vect[i];
        }
        System.out.println("SOMA = " + sum);

        double avg = sum / n;
        System.out.printf("MEDIA = %.2f", avg);

        sc.close();

    }

}
