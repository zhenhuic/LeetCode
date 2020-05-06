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
