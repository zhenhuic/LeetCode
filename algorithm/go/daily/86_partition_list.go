package main

// 86. 分隔链表
func partition(head *ListNode, x int) *ListNode {
	smallHead := &ListNode{}
	small := smallHead
	largeHead := &ListNode{}
	large := largeHead
	var cur, temp *ListNode = head, nil
	for cur != nil {
		if cur.Val < x {
			small.Next = cur
			small = small.Next
		} else {
			large.Next = cur
			large = large.Next
		}
		temp = cur.Next
		cur.Next = nil
		cur = temp
	}
	small.Next = largeHead.Next
	return smallHead.Next
}
