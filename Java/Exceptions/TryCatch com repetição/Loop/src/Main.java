import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuarLendoValor = true;
        int valor;
        while(continuarLendoValor == true){
            try{
                valor = sc.nextInt();
                if(valor > 10){
                    continuarLendoValor = false;
                    throw new Exception();
                } else {
                    System.out.println("Valor válido");
                }
            } catch(Exception e){
                System.out.println("valor invalido.");
            }
        }
    }
}