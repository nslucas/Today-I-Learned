import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UsandoDate {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date y1 = sdf1.parse("01/12/2022");
        Date y2 = sdf2.parse("01/12/2022 14:16:50");
        /*Date y3 = Date.from(Instant.parse("2022-12-01T15:11:42:07Z"));
         */

        java.util.Date x1 = new java.util.Date();
        java.util.Date x2 = new java.util.Date(System.currentTimeMillis());
        java.util.Date x3 = new java.util.Date(0L);
        java.util.Date x4 = new java.util.Date(1000L * 60L * 60L * 5L);

        /* Data sem formatacao */
        System.out.println("x1: " + x1);
        System.out.println("x2: " + x2);
        System.out.println("x3: " + x3);
        System.out.println("x4: " + x4);
        System.out.println("y1: " + y1);
        System.out.println("y2: " + y2);
        System.out.println("-----------------------");
        /* Data com formatacao para hora do brasil*/
        System.out.println("x1: " + sdf2.format(x1) );
        System.out.println("x2: " + sdf2.format(x2));
        System.out.println("x3: " + sdf2.format(x3));
        System.out.println("x4: " + sdf2.format(x4));
        System.out.println(sdf2.format(y1));
        System.out.println(sdf2.format(y2));
        System.out.println("-----------------------");
        /* Data com formatacao para o horario de Greenwich */
        System.out.println("x1: " + sdf3.format(x1) );
        System.out.println("x2: " + sdf3.format(x2));
        System.out.println("x3: " + sdf3.format(x3));
        System.out.println("x4: " + sdf3.format(x4));
        System.out.println("y1: " + sdf3.format(y1));
        System.out.println("y2: " + sdf3.format(y2));
        /*System.out.println("y3: " + sdf3.format(y3));

         */
    }
}