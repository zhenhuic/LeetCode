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