public class JavaDestroyExp extends Thread   
{  
    JavaDestroyExp(String threadname, ThreadGroup tg)  
    {  
        super(tg, threadname);  
        start();  
    }  
    public void run()  
    {  
        for (int i = 0; i < 2; i++)   
        {  
            try  
            {  
                Thread.sleep(10);  
            }  
            catch (InterruptedException ex) {  
                System.out.println("Exception encountered");}  
        }  
        System.out.println(Thread.currentThread().getName() + " finished executing");  
    }  
    @SuppressWarnings("removal")
    public static void main(String arg[]) throws InterruptedException, SecurityException  
    {  
        // creating a ThreadGroup  
        ThreadGroup g1 = new ThreadGroup("Parent thread");  
        // creating a child ThreadGroup for parent ThreadGroup  
        ThreadGroup g2 = new ThreadGroup(g1, "child thread");  
          
        // creating a thread   
        JavaDestroyExp t1 = new JavaDestroyExp("Thread-1", g1);  
        // creating another thread   
        JavaDestroyExp t2 = new JavaDestroyExp("Thread-2", g1);  
          
        // block until other thread is finished  
        t1.join();  
        t2.join();  
   
        // destroying child thread  
        g2.destroy();  
        System.out.println(g2.getName() + " destroyed");  
          
        // destroying parent thread  
        g1.destroy();  
        System.out.println(g1.getName() + " destroyed");  
    }  
}