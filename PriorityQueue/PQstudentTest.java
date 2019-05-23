public class PQstudentTest{
  
  public static void main(String[] args){
    Queue<Integer> q1 = new PriorityQueue<>();
    q1.add(2);
    q2.add(1);
    q3.add(3);
    
    while(!q1.isEmpty()){
     Integer i = q1.poll();
      System.out.println(i);
    }
    
    Comparator<Student> comparator = new Comparator<Student>(){
     @Override
      public int compare(Student t1, Student t2){
        return(t1.id - t2.id);
      }
    };
    
    Queue<Student> q2 = new PriorityQueue<Student>(Comparator);
    q2.add(new Student(2,"B"));
    q2.add(new Student(1,"A"));
    q2.add(new Student(3,"C"));
    
    while (!q2.isEmpty()){
     Student s = q2.poll();
     System.out.println(s.toString());
    }
  }
  
  public static class Student{
   private int id;
   private String name;
   
   public Student(int id, String name){
     this.id = id;
     this.name = name;
   }
    
   public String toString(){
     return id + "-" + name;
   }
  }
}

/** out put:
1
2
3
1-A
2-B
3-C
**/
