package main

import (
	"fmt"
	"sort"
)

func countOnes(n int) (c int) {
	for ; n > 0; n = n & (n - 1) {
		c += 1
	}
	return
}

// 1、暴力解法
func sortByBits(arr []int) []int {
	sort.Slice(arr, func(i, j int) bool {
		x, y := arr[i], arr[j]
		cx, cy := countOnes(x), countOnes(y)
		return cx < cy || cx == cy && x < y
	})
	return arr
}


var bitCnt = [10001]int{}

func init() {
	for i := 1; i <= 1e4; i++ {
		bitCnt[i] = bitCnt[i >> 1] + (i & 1)
	}
}

// 2、递推预处理
func sortByBitsBull(arr []int) []int {
	sort.Slice(arr, func(i, j int) bool {
		x, y := arr[i], arr[j]
		cx, cy := bitCnt[x], bitCnt[y]
		return cx < cy || cx == cy && x < y
	})
	return arr
}



func main() {
	fmt.Print(sortByBitsBull([]int{0,1,2,3,4,5,6,7,8}))
}

