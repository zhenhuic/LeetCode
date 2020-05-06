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
