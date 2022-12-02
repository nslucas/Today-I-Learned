package application;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Eurias");
        list.add("Tatiana");
        list.add("Lucas Tiks");
        list.add("Arthur");
        list.add("Tais");
        list.add(0, "Theodoro");
        list.add(1, "Deuzinete");
        list.add(2, "Adelina");
        System.out.println(list);

        list.remove("Tais");

        for (String x : list){
            System.out.println(x);
        }
    }
}