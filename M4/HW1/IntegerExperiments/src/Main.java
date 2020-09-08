public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 5510;
        System.out.println( sumDigits(container.count));

    }

    public static Integer sumDigits(Integer number)
    {
        String str=number.toString();
        Integer sum=0;
       for(int i=0;i<str.length();i++){
           sum = sum + Character.getNumericValue(str.charAt(i));
       }
        return sum;
    }
}
