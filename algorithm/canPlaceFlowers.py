def canPlaceFlowers(self, flowerbed, n):
    """
    :type flowerbed: List[int]
    :type n: int996
    :rtype: bool
    """
    def point_judge(flowerbed, index):
        size = len(flowerbed) - 1
        if flowerbed[index]:
            return False
        if (flowerbed[index] == 0) and (index - 1 < 0 or flowerbed[index - 1] == 0) and (
                index + 1 > size or flowerbed[index + 1] == 0):
            return True
        else:
            return False

    for index, value in enumerate(flowerbed):
        if point_judge(flowerbed, index):
            n -= 1
            flowerbed[index] = 1
    return True if n <= 0 else False
