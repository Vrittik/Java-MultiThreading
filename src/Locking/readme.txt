Synchronized depends on object and makes the block synchronized only for a
particular object and the threads using it.

For a block to be synchronized for all the threads and all the objects
so that only one thread and one object can access the critical block of code
These locking strategies are used

Types of locking
1. Reentrant lock
2. ReadWrite lock
3. Stamped lock
4. Semaphore lock

Reentrant lock
Can create ReentrantLock object and in the method which we want to be synchronized for
all the object, we can pass reentrant lock object and use lock.lock() and lock.unlock().

Read write lock
In this lock, there are two types of lock, read lock and write lock
Read lock is shared lock, other shared lock can be put onto it but not exclusive lock
Write lock is exclusive lock, no other locks can be acquired on the block locked by write.

Stamped lock
Optimistic locking, Read write lock and optimistic read
In stamped lock, we get a stamp once we perform an operation. We can validate the stamp later
before committing, this is useful if we want to avoid dirty read.

Semaphore lock
It's exactly the same as Reentrant lock but it has a permit parameter for creating its object,
the number we provide in that parameter is the number of threads that can access the block unlike
in Reentrant, only one thread can access a block.