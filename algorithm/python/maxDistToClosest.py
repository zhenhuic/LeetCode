def maxDistToClosest(self, seats):
    """
    :type seats: List[int]
    :rtype: int
    """
    count = sum(seats)
    if count == 1:
        i = seats.index(1)
        return max(i, len(seats) - i - 1)
    first = seats.index(1)
    rev = list(reversed(seats))
    last = len(seats) - rev.index(1) - 1
    f = first
    max_dis = 0
    for i, v in enumerate(seats):
        if v == 1:
            dis = i - f
            if dis > max_dis:
                max_dis = dis
            f = i
    return max(first, int(max_dis / 2), (len(seats) - last - 1))
