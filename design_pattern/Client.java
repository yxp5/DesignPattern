package design_pattern;

public class Client {

    public static Date month1 = new Date(Month.JAN, Year.ONE);
    public static Date month2 = new Date(Month.JAN, Year.TWO);
    public static Date month3 = new Date(Month.FEB, Year.ONE);
    public static Date month4 = new Date(Month.JAN, Year.ONE);

    public static Calendar calendar = new Calendar(Year.ONE);
    public static IteratingCalendar iteratingCalendar = new IteratingCalendar(Year.ONE);

    public static void main(String[] args) {
        System.out.println(iteratingCalendar);
    }
}
