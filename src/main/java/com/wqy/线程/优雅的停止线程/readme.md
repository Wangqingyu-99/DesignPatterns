thread.interrupt(); 功能：
1.修改线程中断状态 Thread.interrupted()可以检测到线程中断状态，并且停止线程
2.调用此方法后,线程中出现阻塞，会抛出
   java.lang.InterruptedException: sleep interrupted  异常，从而中断线程。
   
如何称为优雅：线程在运行的时候不能强制中断(所以stop()方法就不优雅)，
            而是在线程处于阻塞状态（比如：Object.wait, Thread.join和Thread.sleep),
            才去停止线程！