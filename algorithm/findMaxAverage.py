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