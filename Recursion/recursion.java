1. recursion : an approach to solving problems using a function that calls itself as a subsroutine.
- base case
- recurrence relation

// print a string in reverse order.

first, we can define the desired functions as *printReverse(str[0,....[n-1])*,
  step 1 : printReverse(str[0,...[n-1]): print printReverse(str[1,...[n-1]) in reverse order;
  step 2 : print(str[0]): print the first character in the string.
class solution{
 private void printReverse(char[] str){
  helper(0, str); 
 }
  private void helper(int index, char[] str){
   if (str == nul || index >= str.length) return;
    helper(index + 1, str);
    System.out.println(str[index]);
  }
}
                                                             
