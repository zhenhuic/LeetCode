def findShortestSubArray(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    counts = {}
    starts = {}
    ends = {}
    max_count = -sys.maxsize
    for i, num in enumerate(nums):
        if num not in starts:
            starts[num] = i
            counts[num] = 1
        ends[num] = i
        counts[num] += 1
        max_count = max(max_count, counts[num])
    ans = sys.maxsize
    for num, count in counts.items():
        if count == max_count:
            ans = min(ans, ends[num] - starts[num] + 1)
    return ans