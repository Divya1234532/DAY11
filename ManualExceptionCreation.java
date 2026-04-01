class InvalidAgeException extends Exception{
    public InvalidAgeException(String msg)
    {
        super(msg);//To Call The Parent Class
    }
}
public class ManualExceptionCreation {
    static void checkAge(int age) throws InvalidAgeException{
        if(age<18)
        {
            throw new InvalidAgeException("Age is lesser than 18");
        }
        else
        {
            System.out.println("Eligible to vote");
        }
    }
    public static void main(String[] args) {
         try
         {
             checkAge(27-19);
         }
         catch(Exception e)
         {
             System.out.println(e.getMessage());//Get that particular exception message
         }
    }
}
