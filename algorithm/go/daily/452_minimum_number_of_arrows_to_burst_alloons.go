package main

import "sort"

// 452. 用最少数量的箭引爆气球
func findMinArrowShots(points [][]int) int {
	if len(points) == 0 {
		return 0
	}
	sort.Slice(points, func(i, j int) bool {
		return points[i][1] < points[j][1]
	})
	maxRight := points[0][1]
	ans := 1
	for _, p := range points {
		if p[0] > maxRight {
			ans++
			maxRight = p[1]
		}
	}
	return ans
}
