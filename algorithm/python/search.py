def search(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    try:
        ans = nums.index(target)
        return ans
    except Exception:
        return -1
