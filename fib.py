class Solution:
    def fib(self, n):
        if n == 0:
            return 0
        if n == 1:
            return 1
        return self.fib(n - 1) + self.fib(n - 2)
    
    def fibIterative(self, n):
        stack = []
        stack.append(n)
        sum = 0
        while (len(stack) > 0):
            n = stack.pop()
            if n == 0:
                sum += 0
            elif n == 1:
                sum += 1
            else:
                stack.append(n - 1)
                stack.append(n - 2)
        return sum
    
    def fibMemo(self, n, cache = {}):
        if n not in cache.keys():
            cache[n] = self._fibMemoHelper(n, cache)
        return cache[n]
    def _fibMemoHelper(self,n, cache):
        if n < 2:
            return n
        else :
            return self.fibMemo(n -1, cache) + self.fibMemo(n - 2, cache)

print(Solution().fibMemo(10))
#print(Solution().fibIterative(4))
