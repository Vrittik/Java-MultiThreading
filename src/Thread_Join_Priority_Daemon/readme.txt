Stop(), suspend() and resume() are deprecated because they do not release the lock and
stops/suspends threads abruptly, deadlock can happen in these cases.

join() - If I want one thread to complete its execution, join is used

Thread priority -
Priorities are ranged from 1 to 10, 1 being lowest
JVM never guarantees thread priority, it just understands that a priority is provided
but it does not guarantee the execution will take place in that priority. May or
may not be executed in that order
Whenever we create a thread, it takes priority of the parent

Daemon thread -
Something running asynchronously (watcher thread)
thread.setDaemon(true) - this will be considered as a daemon thread

Whenever a user thread is working, daemon thread can run in parallel or asynchronously
but as soon as all the user threads are stopped, daemon thread will also be stopped
