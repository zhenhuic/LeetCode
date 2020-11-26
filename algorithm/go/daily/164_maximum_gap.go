package main

func maximumGap(nums []int) (ans int) {
	n := len(nums)
	if n < 2 {
		return
	}
	buf := make([]int, n)
	maxValue := max1(nums...)
	for exp := 1; exp <= maxValue; exp *= 10 {
		cnt := [10]int{}
		for _, v := range nums {
			digit := v / exp % 10
			cnt[digit]++
		}
		for i := 1; i < 10; i++ {
			cnt[i] += cnt[i-1]
		}
		for i := n - 1; i >= 0; i-- {
			digit := nums[i] / exp % 10
			buf[cnt[digit]-1] = nums[i]
			cnt[digit]--
		}
		copy(nums, buf)
	}
	for i := 1; i < n; i++ {
		ans = max1(ans, nums[i]-nums[i-1])
	}
	return
}

func max1(nums ...int) int {
	m := nums[0]
	for _, n := range nums[1:] {
		if n > m {
			m = n
		}
	}
	return m
}
