1. heap (不指定 comparator时默认为最小heap）
2. Queue可以根据元素的自然顺序排序，也可以根据 comparator来设置排序规则.
3. Queue' head 是指定排序方式的最小元素。如果多个元素都是最小值，则 head 是其中一个元素。
4. 新建对象时，可以指定一个初始容量，其容量会自动增加。


<h3>Note:</h3>
1. Queue 是 Array 实现，但是数组大小可以动态增加，容量无限。
2. Queue 的实现，不是同步的，不是线程安全的。如果多个线程中的任意线程从结构上修改了列表，则这个线程不应同时访问 PriorityQueue 实例。 保证线程安全
  可以用 PriorityBlockingQueue class
3. 不允许使用 null 
4. 插入方法（ offer(), poll(), remove(), add() )时间复杂度为 O(log n);
  remove (Object) and contains(Object) 时间复杂度为 O(n)
  检索方法 （peek(), element(), size()) 时间复杂度为 O(1)
5. iterator() 中提供的迭代器不保证以有序的方式遍历 PQ 中的元素；如果需要按顺序遍历，可用 Arrays.sort(pq.toArray())。
6. 可以在构造函数中指定如何排序。 如：
  PriorityQueue()
      使用默认的初始容量（11） 创建一个 PQ，并根据自然顺序来排序其元素（使用 Comparable).
  PriorityQueue(int initialCapacity)
      使用指定的初始容量创建一个 PQ ，并根据自然顺序来排序其元素（使用 Comparable).
  PriorityQueue(int initialCapacity, Comparator<? super E> comparator>
      使用指定的初始容量创建一个 PriorityQueue,并根据指定的比较器 comparator 来排序其元素。
 7. 此类及其迭代器实现了 Collection and Iterator 接口的所有可选 方法。
 
 PQ 对元素采用的是<b>堆排序</b>，head 是按指定排序方式的最小元素。堆排序只能保证根是最大（最小），整个堆并不是有序的。
 Iterator() 中提供的迭代器可能只是对整个数组的依次遍历。也就只能保证数组的第一个元素是最小的。
 
 
PriorityQueue 不允许空值，而且不支持 non-comparable 的对象，比如用户自定义的类。PQ 要求使用 Java Comparable & Comparator 接口给对象排序，并且在排序时会按照优先级处理其中的元素。

<h3>PQ 的实现原理</h3>
通过heap实现，完全二叉树（complete binary tree)实现的小顶堆（任意一个非叶子节点的权值，都不大于其左右子节点的权值），可以通过数组来作为PQ的底层实现。
Priority Queue represented as a balanced binary heap:
- the two children of queue[n] are queue[2*n + 1] and queue[2*(n+1)].
