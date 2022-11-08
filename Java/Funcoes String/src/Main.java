/*
Funções Interessantes para String

Formatar:
    - Minúscula = toLowerCase();
    - Maiúscula = toUpperCase();
    - Remover espaços = trim().

Recortar:
    - substring(inicio), substring(inicio, fim).

Substituir caracteres:
    - Replace(char, char) ; Replace(string, string)

Buscar posição:
    - IndexOf; LastIndexOf

Recortar uma string com base em um separador informado:
    - str.Split(" ")

 */

public class Main {
    public static void main(String[] args) {
        String original = "abcde FHIJ ABC abc aFK OE     ";
        String s1 = original.toLowerCase();
        String s2 = original.toUpperCase();
        String s3 = original.trim();
        String s4 = original.substring(2);
        String s5 = original.substring(2, 9);
        String s6 = original.replace('a', 'x');
        String s7 = original.replace("abc", "xy");
        int i = original.indexOf("bc");
        int j = original.lastIndexOf("bc");
        String s = "potato apple lemon";
        String[] vect = s.split(" ");
        String word1 = vect[0];
        String word2 = vect[1];
        String word3 = vect[2];

        System.out.println("Original: " + original + "-");
        System.out.println("Minúscula: " + s1 + "-") ;
        System.out.println("Maiúscula: " + s2 + "-");
        System.out.println("Sem espaços: " + s3 + "-") ;
        System.out.println("Substring(2): " + s4 + "-") ;
        System.out.println("Substring(2, 9): " + s5 + "-") ;
        System.out.println("Replace('a', 'x'): " + s6 + "-") ;
        System.out.println("Replace('abc', 'xy'): " + s7 + "-") ;
        System.out.println("Index of 'bc'): " + i) ;
        System.out.println("Last Index of 'bc'): " + j);
        System.out.println("Split of 'potato apple lemon': " + word1);
        System.out.println("Split of 'potato apple lemon': " + word2);
        System.out.println("Split of 'potato apple lemon': " + word3);

    }
}