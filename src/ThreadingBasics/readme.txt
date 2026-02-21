Process - It is an instance of the program being executed.
It has its own heap memory, threads etc. OS allocates the memory when the process is
created.

Thread - Smallest sequence of program instructions that are executed by a CPU
independently

When a process is created, it is created with one thread which is known as the main thread.

Each process has a jvm instance
Each process has a code segment, data segment and heap which is shared by all
the threads
Each thread has its own stack, counter and register


Code segment contains the compiled BYTECODE of the java program, Its readonly
Data segment contains the global and static variables, synchronization is required if
2 threads can possibly modify at the same time
Heap contains the objects created and are shared by each thread, Heap is shared by all the
threads but no 2 process shares the heap

Stack - Each thread has its own stack, it manages local variables, method calls
Register - When JIT compiler converts bytecode into native machine code, it uses
registers to store the intermediate results so that in event of context switching
it can pick up the results processed till now from the register and resume from there
Counter - It points to the instruction being executed, it increments after successful
completion of the instruction


MultiThreading
- Allows a program to run multiple threads at the same time
- Multiple threads share the same resource such as heap space but still can perform
task independently

MultiTasking
- Allows multiple process to run at the same time such as browsing google, running java program
- CPU switches between tasks so that user can run multiple tasks at the same time
- Each process has its own memory space


1. Thread creation
Can be Created by implementing Runnable interface or extending Thread class
Thread class itself extends runnable interface
It has methods like, run(), start(), stop(), init() etc..
If we implement Runnable, we have to override the method run()
Thread class takes Runnable obj as its parameter and has methods like above
Runnable is a functional interface (Interfacing having only one function)

We can extend Thread class or implement runnable interface to run a thread and java
has given these 2 types because if a class has to do jobs other than running the thread
Like implementing some methods then in that case we can implement runnable but since
multiple inheritance is not possible, then we cannot extend any other class after extending
thread. Multiple interfaces can be implemented though.

There is a limit to the number of threads that can be created
Each core is a CPU generally supports two threads
So a 8 core machine can have 16 threads which can execute tasks in parallel