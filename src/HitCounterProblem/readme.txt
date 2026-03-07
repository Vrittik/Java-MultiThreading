Problem: Hit Counter (Sliding Window)

The goal of this problem is to design a system that counts how many hits
occurred in the last 5 minutes (300 seconds).

The system supports two operations:

hit(timestamp)
→ Records a hit at a given timestamp

count(timestamp)
→ Returns the number of hits in the last 5 minutes from the given timestamp


Example:

hit(1)
hit(2)
hit(3)

count(4) → returns 3

Because all hits happened within the last 300 seconds.


-----------------------------------------------------

Brute Force Solution

The simplest approach is to store every hit timestamp in a list.

Whenever a hit occurs:
→ Add the timestamp to the list

When count(timestamp) is called:
→ Iterate through the list
→ Count timestamps that fall within the last 300 seconds

Timestamp list will be like this
{1,1,1,2,3,4,4,5,5,5,5,5 ..................}
Means at 1st second 3 hits, at 2nd second 1 hit, at 3rd 1, at 4th 1, at 5th 4 and so on
Result will be the total number of hits < currentTimeStamp - 300

Problems with this approach:
1) Memory usage becomes huge if traffic is high
2) count() operation becomes slow because we scan the entire list

Complexity:

hit()   → O(1)
count() → O(N)



-----------------------------------------------------

Optimized Solution (Queue / Sliding Window)

Instead of storing all hits forever, we only keep hits from the last 5 minutes.

When a hit arrives:
→ Add it to a queue

When count() is called:
→ Remove timestamps older than 300 seconds
→ Return queue size

Pseudo structure:

Queue<Integer> hits

hit(t):
    queue.add(t)

count(t):
    while(queue.peek() <= t - 300)
        queue.poll()

    return queue.size()


Advantages:

Old hits are automatically removed
Memory usage stays bounded

Complexity:

hit()   → O(1)
count() → O(1) amortized


-----------------------------------------------------

Best Solution (Circular Array / Time Buckets)

Observation:

We only care about a fixed window of 300 seconds.

Instead of storing every hit, we maintain 300 buckets,
each bucket representing one second.

Two arrays are maintained:

timeStamp[300]
hits[300]

Each index corresponds to a second in the sliding window.

Index is calculated using modulo:

index = timestamp % 300

This creates a circular buffer.


-----------------------------------------------------

Hit Operation

When a hit occurs:

1) Calculate index using modulo
2) Check if the bucket belongs to the current timestamp
3) If it is an old bucket, reset it
4) Increment the hit count

Pseudo logic:

index = timestamp % 300

if timeStamp[index] != timestamp
    timeStamp[index] = timestamp
    hits[index] = 1
else
    hits[index]++


Complexity:

hit() → O(1)



-----------------------------------------------------

Count Operation

To calculate the number of hits in the last 5 minutes:

Loop through all buckets.

If the timestamp stored in the bucket is within the window,
add the hits.

Pseudo logic:

count = 0

for i in 0..299
    if currentTimestamp - timeStamp[i] < 300
        count += hits[i]

return count


Complexity:

count() → O(300)

Since 300 is constant, this is effectively O(1).


-----------------------------------------------------

Further Optimization

If count() is called very frequently, scanning 300 buckets repeatedly
may become expensive.

A better approach is to maintain a running total of hits in the window.

Whenever a bucket expires:

→ subtract its old hits from the total

Whenever a hit occurs:

→ increment the total

Then count() simply returns the running total.

count() → O(1)


-----------------------------------------------------

Concurrency Problem

If multiple threads call hit() at the same time, race conditions occur.

Example:

Two threads update the same bucket simultaneously.

Possible issues:

• Lost updates
• Incorrect total hit count
• Bucket reset conflicts


-----------------------------------------------------

Thread Safe Solution

To solve concurrency problems we use:

1) AtomicIntegerArray for hit counters
2) AtomicInteger for total hits
3) Fine grained locking per bucket


Instead of one global lock, we create 300 locks:

ReentrantLock[300]

Each bucket has its own lock.

This technique is called lock striping.

Only threads accessing the same bucket compete for the lock.


Advantages:

• Higher parallelism
• Minimal lock contention
• Correct results under concurrency


Complexity:

hit()   → O(1)
count() → O(1)
memory  → O(window size)


-----------------------------------------------------

Concepts Demonstrated

This implementation demonstrates:

• Sliding window algorithms
• Circular buffer design
• Time bucket aggregation
• Thread safety
• Lock striping
• Atomic operations
• Concurrent system design


-----------------------------------------------------

Real World Applications

Similar designs are used in:

• API rate limiters
• Traffic monitoring systems
• Metrics collectors (Prometheus)
• Analytics pipelines
• Distributed monitoring systems


The key idea is to convert a time based problem into a
fixed size circular structure to achieve constant time operations.