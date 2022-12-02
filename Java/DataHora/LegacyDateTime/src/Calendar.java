import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Calendar {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d = Date.from(Instant.parse("2022-12-01T15:38:42:07Z"));
        System.out.println(d);

        Calendar cal = Calendar;
        
    }
}
