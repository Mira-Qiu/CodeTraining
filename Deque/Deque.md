一个线性 colection, 支持在两端插入和移除. deque "double ended queue"。
大多数 Deque 实现对于他们能包含的元素数没有固定限制，但此接口既能支持有容量限制的双端队列，也支持没有固定大小限制的双端队列。

此接口定义在双端队列两端访问元素的方法。提供插入，移除和检查元素的方法。每种方法都存在两种形式： 一种形式在操作失败时抛出异常，另一种返回一个特殊值
（null / false）。插入操作的后一种形式是转为使用有容量限制的Deque实现设计的。

 method |head (throws)  | speical   | last (throws) | special
------------ | ------------- | ------------- | ------------- | -------------
插入 |addFirst(e) | offerFirst(e) | addLast(e) | offerLast(e)
移除 |removeFirst() | pollfirst() | removeLast()| pollLast()
检查 |getFirst() | peekFirst() | getLast() | peekLast()

* 此接口扩展了Queue接口。在双端队列作用时，讲得到 FIFO。将元素添加到双端队列的末尾， 从双端队列的开始移除元素。
* 也可用 LIFO 堆栈。**应优先使用此接口尾部是遗留Stack类**。 
* 此接口提供了两种移除内部元素的方法 **removeFirstOccurrence & removeLastOccurrence**.
