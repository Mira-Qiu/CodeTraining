import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1. Arrays and Strings
 * <Hash Tables>
 * [1] a data structure maps keys to values for highly efficient loopup.
 * [2] Implementation of a hash table, the hash table has a underlying array and a hash function.
 *      when you want to insert an object and its key, the hash function maps the key to an integer,
 *      which indicates the index in the array. The object is then sotred at that index.
 * [3]make array smaller and store objects in a linked list as index hash(key) % array_length.
 *      lookup time O(logn) --> binary search tree.
 */

 class HashTableExample{
     public HashMap<Integer, Student> buildMap(Student[] students){
         HashMap<Integer, Student> map = new HashMap<>();
         for (Student s : students)
         map.put(s.getId(), s);
         return map;
     }
 }

 /**
  * <ArrayList (Dynamically Resizing Array)>
  *  [1]resizes itself as needed while still providing O(1) access.
    *[2] A typical implementation is that when the array is full, the array doubles in sizes.
    *   each doubling takes O(n) time,amortized time is still O(1).
  */

  class ArrayListExample{
      public ArrayList<String> merge(String[] words, String[] more){
          ArrayList<String> sentence = new ArrayList<>();
          for (String w : words) sentence.add(w);
          for (String w: more) sentence.add(w);
          return sentence;
      }
  }

  /**
   * <StringBuffer>
   * [1] StringBuffer simply creates an array of all the strings, copying them back to a string only when necessary.
   *  Concatenating a list of strings below.
   * 
   */
class StringBufferExample{
    //O(n^2)
    public String joinWords(String[] words){
        String sentence = "";
        for (String w: words)
            sentence = sentence + w;
        return sentence;
    }
    public String joinwords2(String[] words){
        StringBuffer sentence = new StringBuffer();
        for(String w : words)
            sentence.append(w);
        return sentence.toString();
    }
}

// Interview Questions
/**
 *  1.1 Implement an algorithm to determine if a string has all unique characters. 
 *      What if you cannot use additional data structures?
 */

/**
 *  SOLUTIONS:
 *  [1] Asking if the string is an ASCII string or a unicode string(show an eye for detail and deep understanding of computer science)
 *  [2] Assume for ASCII, if not, we would need to increase the storage size, rest of logic would be the same.
 *  [3] 
 * 
 */
