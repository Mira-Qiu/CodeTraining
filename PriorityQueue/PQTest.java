
//自己指定比较器进行排序

Queue<Interger> pq = new PriorityQueue<>(l1, new comparator<Integer>(){
                public int compare compare(Integer i1, Integer i2( {
                      return i2-i1;
                                                    }
                                                    });
