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