def pivotIndex(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    front, rear = 0, (len(nums) - 1)
    front_sum, rear_sum = nums[front], nums[rear]
    while front < rear:
        if front_sum < rear_sum:
            front += 1
            front_sum += nums[front]
        elif front_sum == rear_sum and rear - front == 2:
            return front + 1
        else:
            rear -= 1
            rear_sum += nums[rear]
    return -1
