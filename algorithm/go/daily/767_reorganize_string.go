package main

func reorganizeString(S string) string {
	n := len(S)
	if n < 1 {
		return ""
	}
	cnt := [26]int{}
	for _, ch := range S {
		idx := ch - 'a'
		cnt[idx]++
		if cnt[idx] > (n+1)/2 {
			return ""
		}
	}
	ans := make([]byte, n)
	evenIdx, oddIdx, halfLen := 0, 1, n/2
	for i, c := range cnt {
		ch := byte(i + 'a')
		for c > 0 && c <= halfLen && oddIdx < n {
			ans[oddIdx] = ch
			oddIdx += 2
			c--
		}
		for c > 0 {
			ans[evenIdx] = ch
			evenIdx += 2
			c--
		}
	}
	return string(ans)
}
