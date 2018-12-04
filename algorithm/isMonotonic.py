def isMonotonic(self, A):
    """
    :type A: List[int]
    :rtype: bool
    """
    sorted_A = sorted(A)
    reversed_A = list(reversed(A))
    if sorted_A == A or sorted_A == reversed_A:
        return True
    else:
        return False
