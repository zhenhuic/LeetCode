def sortArrayByParity(self, A):
    """
    :type A: List[int]
    :rtype: List[int]
    """
    h, r = 0, len(A) - 1
    while h < r:
        if A[h] % 2 == 1 and A[r] % 2 == 0:
            A[h], A[r] = A[r], A[h]
        elif A[h] % 2 != 1:
            h += 1
        elif A[r] % 2 != 0:
            r -= 1
    return A
