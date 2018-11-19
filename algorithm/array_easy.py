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
        front,  rear = 0, (len(nums) - 1)
        front_sum, rear_sum = nums[front], nums[rear]
        while front < rear:
            if front_sum < rear_sum:
                front += 1
                front_sum += nums[front]
            elif front_sum == rear_sum and rear - front == 2:
                return front + 1
            else:
                rear -= 1
                rear_sum += nums[rear]
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
            if L[1][1] != 5:
                return False
            for l in L:
                for v in l:
                    if v > 9 or v < 1:
                        return False
            a = L[0][0] + L[2][2]
            b = L[0][2] + L[2][0]
            c = L[0][1] + L[2][1]
            d = L[1][0] + L[1][2]
            if a == b == c == d:
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
                if square_varify(grid[i:i + 3, j:j + 3]):
                    count += 1
        return count

    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort(reverse=True)
        res = []
        for i, num in enumerate(nums):
            if i > 0 and nums[i - 1] == num:
                continue
            b, r = i + 1, len(nums) - 1
            while b < r:
                sum = num + nums[b] + nums[r]
                if sum == 0:
                    res.append([num, nums[b], nums[r]])
                    b += 1
                    r -= 1
                    while b < r and nums[b] == nums[b - 1]:
                        b += 1
                    while b < r and nums[r] == nums[r + 1]:
                        r -= 1
                elif sum > 0:
                    b += 1
                else:
                    r -= 1
        return res

    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        nrs = sys.maxsize
        nrs_sum = 0
        for i, v in enumerate(nums):
            b, r = i + 1, len(nums) - 1
            while b < r:
                sum = v + nums[b] + nums[r]
                dif = sum - target
                dif_abs = abs(dif)
                if dif == 0:
                    return target
                elif dif < 0:
                    b += 1
                else:
                    r -= 1
                if dif_abs < nrs:
                    nrs = dif_abs
                    nrs_sum = sum
        return nrs_sum

    def maxDistToClosest(self, seats):
        """
        :type seats: List[int]
        :rtype: int
        """
        count = sum(seats)
        if count == 1:
            i = seats.index(1)
            return max(i, len(seats) - i - 1)
        first = seats.index(1)
        rev = list(reversed(seats))
        last = len(seats) - rev.index(1) - 1
        f = first
        max_dis = 0
        for i, v in enumerate(seats):
            if v == 1:
                dis = i - f
                if dis > max_dis:
                    max_dis = dis
                f = i
        return max(first, int(max_dis / 2), (len(seats) - last - 1))

    def transpose(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        R, C = len(A), len(A[0])
        ans = [[None] * R for _ in range(C)]
        for r, row in enumerate(A):
            for c, val in enumerate(row):
                ans[c][r] = val
        return ans

    def fairCandySwap(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        A.sort()
        B.sort()
        p1, p2 = 0, 0
        A_sum, B_sum = sum(A), sum(B)
        while p1 < len(A) and p2 < len(B):
            exd_A_sum = A_sum - A[p1] + B[p2]
            exd_B_sum = B_sum - B[p2] + A[p1]
            if exd_A_sum == exd_B_sum:
                return [A[p1], B[p2]]
            elif exd_A_sum > exd_B_sum:
                p1 += 1
            else:
                p2 += 1

    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        # def any_sum(nums, h_idx, r_idx, n, target):
        #     if n == 2:
        pass

    def isMonotonic(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        sorted_A = sorted(A)
        reversed_A = list(reversed(A))
        if sorted_A == A or sorted_A == reversed_A:
            return True
        else:
            return False

    def sortArrayByParity(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        h, r = 0, len(A) - 1
        while h < r:
            if A[h] % 2 == 1 and A[r] % 2 == 0:
                A[h], A[r] = A[r], A[h]
            elif A[h] % 2 != 1:
                h += 1
            elif A[r] % 2 != 0:
                r -= 1
        return A

    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """

        def swap(nums, i, j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp

        def reverse(nums, start):
            i = start
            j = len(nums) - 1
            while i < j:
                swap(nums, i, j)
                i += 1
                j -= 1

        i = len(nums) - 2
        while i >= 0 and nums[i + 1] <= nums[i]:
            i -= 1
        if i >= 0:
            j = len(nums) - 1
            while j >= 0 and nums[j] <= nums[i]:
                j -= 1
            swap(nums, i, j)

        reverse(nums, i + 1)


