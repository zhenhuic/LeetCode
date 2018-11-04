import collections
import sys


class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_sorted = nums.copy()
        nums_sorted.sort()
        n = len(nums)
        i, j = 0, n - 1
        while i < n and nums[i] == nums_sorted[i]:
            i += 1
        while j >= 0 and nums[j] == nums_sorted[j]:
            j -= 1
        ans = j - i + 1
        return ans if ans >= 0 else 0

    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int996
        :rtype: bool
        """
        for index, value in enumerate(flowerbed):
            if self._point_judge(flowerbed, index):
                n -= 1
                flowerbed[index] = 1
        return True if n <= 0 else False

    def _point_judge(self, flowerbed, index):
        size = len(flowerbed) - 1
        if flowerbed[index]:
            return False
        if (flowerbed[index] == 0) and (index - 1 < 0 or flowerbed[index - 1] == 0) and (
                index + 1 > size or flowerbed[index + 1] == 0):
            return True
        else:
            return False

    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums.sort()
        n = len(nums)
        ans = max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3])

    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        n = len(nums)
        max_sum = sum(nums[0:k - 1])
        for i in range(0, n - k + 1):
            j = i + k
            temp = sum(nums[i:j])
            if temp > max_sum:
                max_sum = temp
        return max_sum / k

    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        record = {}
        for i, num in enumerate(nums):
            if num in record and i - record[num] <= k:
                return True
            record[num] = i
        return False

    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        c = collections.Counter(nums)
        count = 0
        if k < 0:
            return 0
        if k == 0:
            for item in c.keys():
                if c[item] > 1:
                    count += 1
            return count
        else:
            for item in c.keys():
                if item + k in c:
                    count += 1
            return count

    def imageSmoother(self, M):
        """
        :type M: List[List[int]]
        :rtype: List[List[int]]
        """

        def getGray(M, x, y):
            total, count = 0.0, 0
            for i in range(-1, 2):
                for j in range(-1, 2):
                    xx = i + x
                    yy = j + y
                    if 0 <= xx < len(M) and 0 <= yy < len(M[0]):
                        total += M[xx][yy]
                        count += 1
            return total / count

        ans = [[0] * len(M[0])] * len(M)
        for i in range(len(M)):
            for j in range(len(M[0])):
                ans[i][j] = getGray(M, i, j)
        return ans

    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        def isIncrease(numz):
            if numz.copy().sort().equal(numz):
                return True
            else:
                return False

        for i in range(len(nums) - 1):
            temp = nums[i]
            nums[i] = nums[i + 1]
            if isIncrease(nums):
                return True
            else:
                nums[i] = temp
        nums[-1] = nums[-2]
        if isIncrease(nums):
            return True
        else:
            return False

    def findLengthOfLCIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 2:
            return len(nums)
        i, count = 0, 0
        for j, num in enumerate(nums):
            if j == 0:
                continue
            if num <= nums[j - 1]:
                if count < j - i:
                    count = j - i
                i = j
        if nums[-1] > nums[-2]:
            if count < len(nums) - i:
                count = len(nums) - i
        return count if i != 0 else len(nums)

    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        pass

    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counts = {}
        starts = {}
        ends = {}
        max_count = -sys.maxsize
        for i, num in enumerate(nums):
            if num not in starts:
                starts[num] = i
                counts[num] = 1
            ends[num] = i
            counts[num] += 1
            max_count = max(max_count, counts[num])
        ans = sys.maxsize
        for num, count in counts.items():
            if count == max_count:
                ans = min(ans, ends[num] - starts[num] + 1)
        return ans

    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        front,  rear= 0, (len(nums) - 1)
        front_sum, rear_sum= nums[front], nums[rear]
        while front < rear:
            if front_sum < rear_sum:
                front_sum += nums[++front]
            elif front_sum == rear_sum and rear - front == 2:
                return front + 1
            else:
                rear_sum += nums[--rear]
        return -1

    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        i = 0
        while i < len(bits) - 1:
            if bits[i] == 0:
                i += 1
                continue
            else:
                if i + 1 < len(bits) - 1:
                    i += 2
                else:
                    return False
        return True

    def pivot_index(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return -1
        total = sum(nums)
        if total - nums[0] == 0:
            return 0
        temp = 0
        i = 0
        while i < len(nums) - 1:
            temp += nums[i]
            if temp == (total - nums[i + 1]) / 2:
                return i + 1
            i += 1
        return -1

    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        pass

    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        ans = []
        S = list(S)
        if not S:
            return ans
        start = 0
        for i, v in enumerate(S):
            if v != S[start]:
                if i - start >= 3:
                    ans.append([start, i - 1])
                start = i
        return ans

    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def square_varify(L):
            a = L[0][0] + L[2][2]
            b = L[0][2] + L[2][0]
            if a == b:
                return True
            else:
                return False

        import numpy as np
        grid = np.array(grid)

        if len(grid) < 3 or len(grid[0]) < 3:
            return 0

        count = 0
        for i in range(len(grid) - 2):
            for j in range(len(grid[0]) - 2):
                m = grid[i:i + 3, j: j+3]
                if square_varify(m):
                    count += 1
        return count

