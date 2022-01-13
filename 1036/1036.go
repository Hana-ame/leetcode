package main

import "fmt"

func isEscapePossible(blocked [][]int, source []int, target []int) bool {
	m := make(map[uint64]bool, 200)
	for i := len(blocked) - 1; i >= 0; i-- {
		m[uint64(blocked[i][0])|uint64(blocked[i][1]<<20)] = true
	}
	// fmt.Println(m)

	cx := make(chan int, 10000000)
	cy := make(chan int, 10000000)
	cx <- source[0]
	cy <- source[1]
	addchan(cx, cy, <-cx, <-cy)
	visitnum := len(blocked) * len(blocked)
	visited := make(map[uint64]bool, len(blocked)*len(blocked))
	for visitnum > 0 && len(cx) > 0 {
		x := <-cx
		y := <-cy
		if x == source[0] && y == source[1] {
			// go addchan(cx, cy, x, y)
			continue
		}
		if x == target[0] && y == target[1] {
			// go addchan(cx, cy, x, y)
			return true
			// continue
		}
		if x < 0 || y < 0 || x > 999999 || y > 999999 {
			continue
		}
		if visited[uint64(x)|uint64(y<<20)] == true || m[uint64(x)|uint64(y<<20)] == true {
			continue
		}

		addchan(cx, cy, x, y)
		visited[uint64(x)|uint64(y<<20)] = true
		visitnum--
	}
	fmt.Println(visitnum)
	if visitnum != 0 {
		return false
	}

	for len(cx) > 0 {
		<-cx
		<-cy
	}

	cx <- target[0]
	cy <- target[1]
	addchan(cx, cy, <-cx, <-cy)
	visitnum = len(blocked) * len(blocked)
	visited = make(map[uint64]bool, len(blocked)*len(blocked))
	for visitnum > 0 && len(cx) > 0 {
		x := <-cx
		y := <-cy
		if x == target[0] && y == target[1] {
			// go addchan(cx, cy, x, y)
			continue
		}

		if x < 0 || y < 0 || x > 999999 || y > 999999 {
			continue
		}
		if visited[uint64(x)|uint64(y<<20)] == true || m[uint64(x)|uint64(y<<20)] == true {
			continue
		}

		addchan(cx, cy, x, y)
		visited[uint64(x)|uint64(y<<20)] = true
		visitnum--
	}
	fmt.Println(visitnum)
	if visitnum != 0 {
		return false
	}

	return true

}

func addchan(cx chan int, cy chan int, x int, y int) {
	cx <- x + 1
	cy <- y
	cx <- x - 1
	cy <- y
	cx <- x
	cy <- y + 1
	cx <- x
	cy <- y - 1
}

func main() {
	a := [][]int{{691938, 300406}, {710196, 624190}, {858790, 609485}, {268029, 225806}, {200010, 188664}, {132599, 612099}, {329444, 633495}, {196657, 757958}, {628509, 883388}}
	b := []int{655988, 180910}
	c := []int{267728, 840949}
	r := isEscapePossible(a, b, c)
	fmt.Println(r)
}
