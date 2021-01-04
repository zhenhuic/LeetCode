package main

import "fmt"

// 509. 斐波那契数
func fib(n int) int {
	if n < 2 {
		return n
	}
	p, q := 0, 1
	for i := 2; i <= n; i++ {
		p, q = q, p + q
	}
	return q
}

func main() {
	fmt.Print(fib(3))
}
