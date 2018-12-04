def fairCandySwap(self, A, B):
    """
    :type A: List[int]
    :type B: List[int]
    :rtype: List[int]
    """
    A.sort()
    B.sort()
    p1, p2 = 0, 0
    A_sum, B_sum = sum(A), sum(B)
    while p1 < len(A) and p2 < len(B):
        exd_A_sum = A_sum - A[p1] + B[p2]
        exd_B_sum = B_sum - B[p2] + A[p1]
        if exd_A_sum == exd_B_sum:
            return [A[p1], B[p2]]
        elif exd_A_sum > exd_B_sum:
            p1 += 1
        else:
            p2 += 1
