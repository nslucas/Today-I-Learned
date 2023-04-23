package entities;

public class CurrencyConverter {
    public static double cotacaoDolar;
    public static double quantidade;

    public static double compraDolar() {
        double valorCorrigido = (cotacaoDolar * 6.0) / 100;
        double soma = cotacaoDolar += valorCorrigido;
        double resultado = soma * quantidade;

        return resultado;
    }

}
