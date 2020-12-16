CountDownLatch countDownLatch = new CountDownLatch(5);

这个 5 代表计数器的起始数量 

countDownLatch.await() 此方法会阻塞后面的代码 直到计数器计数为0

countDownLatch.countDown(); 该方法调用一次就会 在计数器里减1