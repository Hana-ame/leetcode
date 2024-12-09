package main

import "fmt"

func main() {
	t := [][]int{{2, 1, 5}, {3, 3, 7}}
	r := carPooling(t, 4)
	fmt.Println(r)
}

func carPooling(trips [][]int, capacity int) bool {
	// m := make(map[int]int, 1001) // map写法
	m := [1001]int{0} // 更快一些
	for i := len(trips) - 1; i >= 0; i-- {
		m[trips[i][1]] += trips[i][0]
		m[trips[i][2]] -= trips[i][0]
	}
	p := 0
	for i := 0; i <= 1000; i++ {
		p += m[i]
		if p > capacity {
			return false
		}
	}
	return true
}
