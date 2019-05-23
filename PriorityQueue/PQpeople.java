public class PriorityQueueTest{
  public static void main(String args[]){
    PriorityQueue<People> queue = new PriorityQueue<>(l1, new Comparator<People>() {
                                                                public int compare(People p1, People p2){
                                                                  return p2.age - p1.age;
                                                                }
    });
    
    for (int i = 1; i <= 10; i++){
      queue.add(new People("Jimmy" + i, (new Random().nextInt(100))));
    }
    while (!queue.isEmpty()){
      System.out.println(queue.poll().toString());
    }
  }
}
                
class People {
  String name;
  int age;
  public People(String name, int age){
    this.name = name;
    this.age = age;
  }
  public String toString(){
    return "Name: " + name + " Age: " + age;
  }
}
               
