import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xsj284
 * created date: <p>2022/5/25<p>
 */
public class Main {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse("2002-09-26");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(date.getTime());
    }
}
