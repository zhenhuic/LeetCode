package main

import "fmt"

// 134. 加油站
func canCompleteCircuit(gas []int, cost []int) int {
	n := len(gas)
	for i := 0; i < n; i++ {
		fuel, j := 0, i
		for step := 0; step < n; step++ {
			if j == n {
				j = 0
			}
			fuel += gas[j]
			if fuel < cost[j] {
				j = -1
				break
			} else {
				fuel -= cost[j]
				j++
			}
		}
		if j != -1 {
			return i
		}
	}
	return -1
}

func main() {
	fmt.Print(canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}))
}
