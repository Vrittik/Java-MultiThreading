Stop(), suspend() and resume() are deprecated because they do not release the lock and
stops/suspends threads abruptly, deadlock can happen in these cases.

join() - If I want one thread to complete its execution, join is used