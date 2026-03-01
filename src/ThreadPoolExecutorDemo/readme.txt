ThreadPool
It is a collection of threads which are available to perform a submitted task.
After they complete the task, they are put back into the thread pool and are
available to pick new task.

1. Thread creation time can be saved
2. Thread state can be managed easily
3. Increased performance, with more threads created context switching increases
but with this, context switching is minimized because of task queue and thread limits

ThreadPoolExecutor maintains lifecycle of thread creation, deletion, rejection

Thread Pool executor follows this pattern

Parameter
1. corePoolSize - Creates this much initial threads when any task is submitted to the executor
2. maxPoolSize - Maximum number of threads the pool can create
3. BlockingQueue - The queue to store task which no thread can pick because they are busy,
those tasks are stored in this queue, this can be an arrayBlockingQueue for fixed size
of LinkBlockingQueue for not defined sizes
4. ThreadFactory - This is an interface which has a method newThread which accepts Runnable
as a parameter, create the thread as you like by implementing this interface and provide
the object in the executor.
5. RejectedExecutionHandler - This is an interface which has a method void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
implement it as you like and provide the object in the executor.
6. KeepAliveTime(int) - For how much time idle threads needs to stay in the core pool
7. TimeUnit - The unit of time for KeepAliveTime, minutes, seconds, hours etc
8. executor.allowCoreThreadTimeOut(true); - This lets the executor removes idle threads
after keepAliveTime has exhausted.

The executor creates threads when a task is submitted to it, it only creates
core pool size number of tasks first and then new tasks it put in the queue,
after the queue is full and more tasks are coming, executor creates new thread for
those tasks until total threads < maxPoolSize
If any more tasks are requested, they are gracefully rejected
