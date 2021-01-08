package main

// 189. 旋转数组
func rotate(nums []int, k int)  {
	if k <= 0 {
		return
	}
	length := len(nums)
	move := k % length
	if move <= length / 2 {
		tempArr := make([]int, move)
		copy(tempArr, nums[length-move:])
		for i := length - move - 1; i >= 0; i-- {
			nums[i+move] = nums[i]
		}
		copy(nums[:move], tempArr)
	} else {
		tempArr := make([]int, length-move)
		copy(tempArr, nums[:length-move])
		for i := length-move; i < length; i++ {
			nums[i-(length-move)] = nums[i]
		}
		copy(nums[move:], tempArr)
	}
}
