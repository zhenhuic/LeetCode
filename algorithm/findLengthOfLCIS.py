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