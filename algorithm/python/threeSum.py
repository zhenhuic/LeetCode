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
