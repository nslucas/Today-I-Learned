package declarandoFuncoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int higher = max(a, b, c);
        showResult(higher);

        sc.close();


        /*
        if(a > b &&  a > c) {
            System.out.println("Higher: " + a);
        } else if(b > c){
            System.out.println("Higher: " + b);
        } else {
            System.out.println("Higher: " + c);
        }
            ALL OF IT WILL TURN INTO A FUNCTION to simplify the code:
            int higher = max(a, b, c)
            the function max will do the same that the conditionals above

            showResult(higher);
         */

    }

    public static int max(int x, int y, int z) {
        int aux;
        if(x > y &&  x > z) {
            aux = x;
        } else aux = Math.max(y, z);
        return aux;
    }

    public static void showResult(int value) {
        System.out.println("Higher = " + value);
    }
}
