/**
*
*   leetcode 403. Frog jump
*/

class Solution {
    public boolean canCross(int[] stones) {
        for (int i = 3; i < stones.length;i++){
            if(stones[i] > stones[i - 1] * 2)
                return false;
        }
        
        //recorde stone postions in a hashSet, easy to check position later
        HashSet<Integer> stone = new HashSet();
        for (int s : stones)
            stone.add(s);
        
        //Note: whether we can get to the last stone
        int lastStone = stones[stones.length - 1];
        
        // Need to know 2 positions : 1. current position, 2. jump distance
        Stack<Integer> position = new Stack();
        Stack<Integer> jump = new Stack();
        //We know the first position is 0, and the first step is 1 (but we choose 0 to start)
        //because, we can calculate current jump, current jump -1, and current jump + 1;
        position.add(0);
        jump.add(0);
        
        //Now, let frog jump!
        //we will try all the position of the posibility avalible. and ALL posibily jumps for that position 
        while(!position.isEmpty()){
            int currentPosition = position.pop();
            int currentJump = jump.pop();
            
            //try all the posibily jumps
            for (int i = currentJump - 1; i <= currentJump + 1; i++){
                //we do not want jump backwards
                if(i <= 0)
                    continue;
                else{
                    
                    int nextPosition = currentPosition + i;
                    //Great! The frog jumped. Let frog check :
                    //1. did he get the last stone?
                    //2. did he get to another stone?
                    if (nextPosition == lastStone) // question 1: lastStone?
                        return true; // Beautiful!
                                           
                        // question 2: wheather landed another stone? if we did
                        // 2 things: 1. record the position he at
                        //           2. and record the jump we took to get there
                        // here we need to check whether there is stones avalible
                    else if (stone.contains(nextPosition)){
                        position.add(nextPosition);
                        jump.add(i);// i is the steps we took.
                    }
                }
            }
        }
        
        return false;
    }
}
