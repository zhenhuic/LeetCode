def numMagicSquaresInside(self, grid):
    """
    :type grid: List[List[int]]
    :rtype: int
    """

    def square_varify(L):
        if L[1][1] != 5:
            return False
        for l in L:
            for v in l:
                if v > 9 or v < 1:
                    return False
        a = L[0][0] + L[2][2]
        b = L[0][2] + L[2][0]
        c = L[0][1] + L[2][1]
        d = L[1][0] + L[1][2]
        if a == b == c == d:
            return True
        else:
            return False

    import numpy as np
    grid = np.array(grid)
    if len(grid) < 3 or len(grid[0]) < 3:
        return 0
    count = 0
    for i in range(len(grid) - 2):
        for j in range(len(grid[0]) - 2):
            if square_varify(grid[i:i + 3, j:j + 3]):
                count += 1
    return count
