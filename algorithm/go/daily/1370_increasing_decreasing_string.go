package main

// 1370. 上升下降字符串
func sortString(s string) string {
	cnt := [26]int{}
	for _, ch := range s {
		cnt[ch - 'a']++
	}
	n := len(s)
	ans := make([]byte, 0, n)
	for len(ans) < n {
		for i := 0; i < 26; i++ {
			if cnt[i] > 0 {
				ans = append(ans, byte('a' + i))
				cnt[i]--
			}
		}
		for i := 25; i >= 0; i-- {
			if cnt[i] > 0 {
				ans = append(ans, byte('a' + i))
				cnt[i]--
			}
		}
	}
	return string(ans)
}
