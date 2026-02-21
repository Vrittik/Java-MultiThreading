There are different states a thread can be in
New - Thread created but not started, its an object in memory
Runnable - Thread is ready to run, waiting for CPU time
Running - When thread starts executing its code
Blocked - Example - Thread has to acquire lock on a resource which is already
locked by another thread, it has to wait. Release all monitor locks
Waiting - Thread goes into this state if wait() method is called, makes it a non runnable
It goes back to runnable, once we call notify(), notifyAll() method, releases all
monitor locks in this as well
Timed waiting - Thread waits for specific time and then comes back to runnable state
example - sleep(), join(). Does not release monitor locks
Terminated - Life of thread completed, cannot be started back again

Monitor locks
It's a synchronization mechanism in java that ensures only one thread can execute a critical
section of a code for a specific object at a time. Using synchronized etc.

Notify() - When the wait() method is executed while performing the tasks, the worker threads
goes into non runnable state, when notify() is called to wake up single thread, they resume their operation from wherever left

NotifyAll() - Notifies all threads waiting on an object to start execution

If we use notify() when multiple threads are waiting, only one thread will wake up and start
the execution of the instructions
