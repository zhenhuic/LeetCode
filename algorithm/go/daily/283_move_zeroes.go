package main

import "fmt"

// 283. 移动零
func moveZeroes(nums []int) {
	left, right, n := 0, 0, len(nums)
	for right < n {
		for left < n && nums[left] != 0 {
			left++
		}
		if right <= left {
			right = left + 1
		}
		for right < n && nums[right] == 0 {
			right++
		}
		if right >= n {
			break
		}
		nums[left], nums[right] = nums[right], 0
	}
}

func main() {
	nums := []int{1}
	//nums := []int{0,1,0,3,12}
	moveZeroes(nums)
	fmt.Print(nums)
}
