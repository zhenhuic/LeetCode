def isOneBitCharacter(self, bits):
    """
    :type bits: List[int]
    :rtype: bool
    """
    i = 0
    while i < len(bits) - 1:
        if bits[i] == 0:
            i += 1
            continue
        else:
            if i + 1 < len(bits) - 1:
                i += 2
            else:
                return False
    return True
