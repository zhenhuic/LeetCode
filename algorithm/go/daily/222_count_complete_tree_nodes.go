package main

// Definition for a binary tree node.
type TreeNode struct {
    Val int
    Left *TreeNode
    Right *TreeNode
}

// 222. 完全二叉树的节点个数
func countNodes(root *TreeNode) int {
	if root != nil {
		return countNodes(root.Left) + countNodes(root.Right) + 1
	} else {
		return 0
	}
}
