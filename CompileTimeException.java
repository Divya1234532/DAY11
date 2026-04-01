public class CompileTimeException {
    public static void main(String[] args) {
        Thread T=new Thread(()->{
            try
            {
                System.out.println("Thread sleep");
                Thread.sleep(6000);
                System.out.println("thread wake");
            }
            catch(InterruptedException e)
            {
                System.out.println("Sleep Interrupted");
            }
        });
        T.start();
        T.interrupt();//Works in Compile Time
        try
        {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            System.out.println("Not T");
        }
        T.interrupt();
    }
}
