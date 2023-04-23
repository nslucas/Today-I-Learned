import java.util.Locale;
import java.util.Scanner;

public class working_double {
    public static void main (String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int num;
        double salario;
        double valorHora;
        int horas;
        num = sc.nextInt();
        horas = sc.nextInt();
        valorHora = sc.nextDouble();
        double soma = valorHora * horas;
        System.out.printf("NUMBER = %d", num);
        System.out.printf("SALARY = U$ %.2f", soma);
    }
}
