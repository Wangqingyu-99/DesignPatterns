corePoolSize： 线程池维护线程的最少数量
maximumPoolSize：线程池维护线程的最大数量
keepAliveTime： 线程池维护线程所允许的空闲时间
unit： 线程池维护线程所允许的空闲时间的单位
workQueue： 线程池所使用的缓冲队列
handler： 线程池对拒绝任务的处理策略 

一个任务通过 execute(Runnable)方法被添加到线程池，任务就是一个 Runnable类型的对象，任务的执行方法就是Runnable类型对象的run()方法。
   当一个任务通过execute(Runnable)方法欲添加到线程池时： 
       如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
       如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
       如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
       如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
       当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
       
四种常见线程池：
    （1）fixThreadPool  正规线程
             我的理解这是一个有指定的线程数的线程池，有核心的线程，里面有固定的线程数量，响应的速度快。正规的并发线程，多用于服务器。固定的线程数由系统资源设置。
         核心线程是没有超时机制的，队列大小没有限制，除非线程池关闭了核心线程才会被回收。
         源码 ： public static ExecutorService newFixedThreadPool(int nThreads) {
                     return new ThreadPoolExecutor(nThreads, nThreads,
                                                   0L, TimeUnit.MILLISECONDS,
                                                   new LinkedBlockingQueue<Runnable>());
                 }
    
   （2）caCheThreadPool  缓存线程池
             只有非核心线程，最大线程数很大（Int.Max(values)），它会为每一个任务添加一个新的线程，这边有一个超时机制，当空闲的线程超过60s内没有用到的话，就会被回收。缺点就是没有考虑到系统的实际内存大小。
        源码：public static ExecutorService newCachedThreadPool() {
               return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                             60L, TimeUnit.SECONDS,
                                             new SynchronousQueue<Runnable>());
             }
    
   （3）singleThreadPoll   单线程线程池
        看这个名字就知道这个家伙是只有一个核心线程，就是一个孤家寡人，通过指定的顺序将任务一个个丢到线程，都乖乖的排队等待执行，不处理并发的操作，不会被回收。确定就是一个人干活效率慢。
        源码： public static ExecutorService newSingleThreadExecutor() {
                return new FinalizableDelegatedExecutorService
                    (new ThreadPoolExecutor(1, 1,
                                            0L, TimeUnit.MILLISECONDS,
                                            new LinkedBlockingQueue<Runnable>()));
              }
    
   （4）ScheduledThreadPoll   
        这个线程池就厉害了，是唯一一个有延迟执行和周期重复执行的线程池。它的核心线程池固定，非核心线程的数量没有限制，但是闲置时会立即会被回收
        源码： public ScheduledThreadPoolExecutor(int corePoolSize) {
                 super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
                       new DelayedWorkQueue());
              }
           