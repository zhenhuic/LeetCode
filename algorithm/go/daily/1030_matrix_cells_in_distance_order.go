package main

import (
	"fmt"
	"sort"
)

// 桶排序
func allCellsDistOrderBucket(R int, C int, r0 int, c0 int) [][]int {
	maxDist := max(r0, R-r0-1) + max(c0, C - c0 - 1)
	buckets := make([][][]int, maxDist+1)

	for i := 0; i < R; i++ {
		for j := 0; j < C; j++ {
			dist := abs(i-r0) + abs(j-c0)
			buckets[dist] = append(buckets[dist], []int{i, j})
		}
	}

	ans := make([][]int, 0, R*C)
	for _, bucket := range buckets {
		ans = append(ans, bucket...)
	}
	return ans

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}


// 直接排序
func allCellsDistOrder(R int, C int, r0 int, c0 int) [][]int {
	ans := make([][]int, 0, R*C)
	for i := 0; i < R; i++ {
		for j := 0; j < C; j++ {
			ans = append(ans, []int{i, j})
		}
	}
	sort.Slice(ans, func(i, j int) bool {
		a, b := ans[i], ans[j]
		return abs(a[0]-r0)+abs(a[1]-c0) < abs(b[0]-r0)+abs(b[1]-c0)
	})
	return ans
}

func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}

func main() {
	res := allCellsDistOrderBucket(3, 3, 2, 0)
	fmt.Println(res)
}
