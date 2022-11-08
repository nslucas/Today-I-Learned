package estCondicionais;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        int num1;
        int num2;
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        if(num1 % num2 == 0 || num2 % num1 == 0 ) {
            System.out.println("São múltiplos");
        } else {
            System.out.println("Não são múltiplos");
        }

        sc.close();

    }
}
