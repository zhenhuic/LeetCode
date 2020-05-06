def imageSmoother(self, M):
    """
    :type M: List[List[int]]
    :rtype: List[List[int]]
    """

    def getGray(M, x, y):
        total, count = 0.0, 0
        for i in range(-1, 2):
            for j in range(-1, 2):
                xx = i + x
                yy = j + y
                if 0 <= xx < len(M) and 0 <= yy < len(M[0]):
                    total += M[xx][yy]
                    count += 1
        return total / count

    ans = [[0] * len(M[0])] * len(M)
    for i in range(len(M)):
        for j in range(len(M[0])):
            ans[i][j] = getGray(M, i, j)
    return ans