def largeGroupPositions(self, S):
    """
    :type S: str
    :rtype: List[List[int]]
    """
    ans = []
    S = list(S)
    if not S:
        return ans
    start = 0
    for i, v in enumerate(S):
        if v != S[start]:
            if i - start >= 3:
                ans.append([start, i - 1])
            start = i
    return ans
