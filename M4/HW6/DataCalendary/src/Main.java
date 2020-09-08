import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) {

//        SimpleDateFormat df = new SimpleDateFormat(" - dd.MM.yyyy - E", Locale.ENGLISH);
//        Calendar calendar = new GregorianCalendar();
//        Calendar calendarHB = new GregorianCalendar(1996, 0, 26);
//        for (int i = 0;calendar.after(calendarHB) ; i++) { //(calendar.get(Calendar.YEAR) >= calendarHB.get(Calendar.YEAR))
//            System.out.println(i + df.format(calendarHB.getTime()));
//            calendarHB.add(Calendar.YEAR, +1);
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern(" - dd.MM.yyyy - E", new Locale("ru"));
        LocalDate birthday =   LocalDate.of(1996,1,26);
        LocalDate today = LocalDate.now();
        for(int i =0;today.isAfter(birthday);i++)
        {
            System.out.println(i + printFormat.format(birthday));
            birthday = birthday.plusYears(1);
        }
    }
}
