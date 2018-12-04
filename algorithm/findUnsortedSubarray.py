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
