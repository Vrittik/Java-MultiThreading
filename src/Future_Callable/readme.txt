Future is the output of the thread pool executor submit call
It has a generic type parameter Future<?>

Thread pool executor expects either callable or runnable

The main difference between callable and runnable is that
callable can return a value whereas runnable cannot return

The Generic parameter is used to catch the return value and so it takes the return
type of the callable

like if callable returns String, it will be Future<String>


There are methods in future like, .get() -> Blocks parent thread until execution completes
.isDone()  etc