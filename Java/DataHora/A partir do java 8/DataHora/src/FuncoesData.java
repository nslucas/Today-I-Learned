import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FuncoesData {
    public static void main(String[] args){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate d04 = LocalDate.parse("2022-07-20", formatter);
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-11-29T01:30:26Z");

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

        System.out.println("My time zone " + r1);
        System.out.println("Portugal time zone " + r2);
        System.out.println("My date-time zone " + r3);
        System.out.println("Portugal date-time zone " + r4);
        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mês = " + d04.getMonth());
        System.out.println("d04 número do mês = " + d04.getMonthValue());
        System.out.println("d04 ano = " + d04.getYear());
        System.out.println("d05 hora = " + d05.getHour());
        System.out.println("d05 minutos = " + d05.getMinute());
        System.out.println("d05 segundos = " + d05.getSecond());
        System.out.println("d05 dia da semana = " + d05.getDayOfWeek());
        System.out.println("d05 dia do ano = " + d05.getDayOfYear());
        System.out.println("d05 cronologia = " + d05.getChronology());
    }
}
