Concurrency can be achieved in 2 ways
1. Lock based concurrency - Reentrant, Read write, Stamped, semaphore
2. Lock free concurrency - CAS (Compare and swap) - AtomicInteger, AtomicBoolean,
AtomicReference, AtomicLong

The problem
        // Final count after the threads have completed their work = 341
        // This is not thread safe counter++, because
        // this involves 3 steps, load counter, increment it by 1 and then assign back
        // all these 3 operations are not atomic
        // it may be possible that 2 thread simultaneously load same counter value before
        // incrementing it, so loss of data can happen, but not guaranteed

Compare and swap (CAS)
Three step operation
1. Read the value from the memory
2. If the memory value is equal to the expected value (Input value)
3. Then performs the operation
4. Otherwise, the operation will return false
CAS operation is atomic, it's a low level operation, all modern CPU supports it

Atomic
Atomic variables uses CAS operation to modify the values, they keep on running the loop
until CAS operation succeeds, so that concurrency can be achieved.

do{
o = readFromMemory()
}
while(!CAS(o, v, ...)

0 = value from memory
v = expected value

It keeps on performing until CAS is success
Atomic is thread safe

Volatile
Volatile and atomic are different

volatile keyword is used to access the value of variables directly from memory but
it does not guarantee thread safety
Because operations on it performed exactly like normal increment
load counter, upgrade its value to 1 and then store it back.
It just that it happens on the memory directly

Each CPU core has its own L1, L2 cache and L3 cache is shared by all CPU cores
the memory is after L3 cache, variables are persisted in L1 cache of a CPU and keeps
on syncing with other CPU's L1 cache, but with volatile keyword, we only save
data to memory