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