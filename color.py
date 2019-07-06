class Solution:
    def maxConnected(self, grid):
        maxCount = 0
        for y in range(0, len(grid)):
            for x in range (0, len(grid[y])):
                count = self._traverse(grid, x, y,{})
                maxCount = max(count,maxCount)
        return maxCount

    def _traverse(self, grid, x, y, seen):
        return self._traverseHelper(grid, x, y, 0, seen)

    def _traverseHelper(self, grid, x, y, count, seen):
        key = "%s,%s" % (x,y)
        if seen.get(key) != None:
            return 0
        seen[key] = True
        color = grid[x][y]
        neightbors = self._getNeighbors(grid, x, y)
        sum = 1
        for point in neightbors:
            i = point[0]
            j = point[1]
            if grid[j][i] != color:
                continue
            seen[key] = True
            sum += self._traverseHelperIterative(grid, i, j, 1, seen)
        return sum

    def _traverseHelperIterative(self, grid, x, y, count, seen):
        color = grid[y][x]
        sum = 0
        stack = []
        stack.append([x,y])
        while (len(stack) > 0):
            p = stack.pop()
            item_x = p[0]
            item_y = p[1]
            key = "%s,%s"%(item_x,item_y)
            if seen.get(key) != None:
                continue
            seen[key] = True
            sum = sum + 1
            neighbors = self._getNeighbors(grid, item_x,item_y)
            for point in neighbors:
                stack.append([point[0],point[1]])
        return sum

    def _getNeighbors(self, grid, x, y):
        coords = []
        neightbors = [
            [-1,0],
            [0,-1],
            [1,0],
            [0,1],
        ]
        for n in neightbors:
            coordsX = x + n[0]
            coordsY = y + n[1]
            if coordsX <0 or coordsY<0 or coordsX >= len(grid[0]) or coordsX >= len(grid) :
                continue
            coords.append([coordsX,coordsY])
        return coords

grid = [
    ['r','g','b'],
    ['r','r','r'],
    ['g','g','r']
]

print(Solution().maxConnected(grid))
