package main

import (
	"errors"
	"fmt"
	"strconv"
)

func isAdditiveNumber(num string) bool {
	for pt1 := 1; pt1 <= 18 && pt1 < len(num); pt1++ {
		for pt2 := pt1 + 1; pt2 <= 18 && pt2 < len(num); pt2++ {
			p1 := pt1
			p2 := pt2
			a, b := num[0:p1], num[p1:p2]
			s, err := stringAdd(a, b)
			if err != nil {
				continue
			}
			if len(s)+p2 > len(num) {
				continue
			}
			for s == num[p2:p2+len(s)] {
				p1 = p2
				p2 = p2 + len(s)
				// fmt.Println(p1, p2)
				if p2 == len(num) {
					return true
				}
				a, b = b, s
				// if num[p2] == '0' || num[p1] == '0' {
				// 	break
				// }
				s, err = stringAdd(a, b)
				if err != nil {
					break
				}
				if len(s)+p2 > len(num) {
					break
				}
			}
		}
	}
	return false
}
func stringAdd(a string, b string) (s string, err error) {
	ua, err := string2uint64(a)
	if err != nil {
		return
	}
	ub, err := string2uint64(b)
	if err != nil {
		return
	}
	us := ua + ub
	s = strconv.FormatUint(us, 10)
	return
}

func string2uint64(s string) (r uint64, err error) {
	if len(s) > 1 && s[0] == '0' {
		err = errors.New("")
		return
	}
	r, err = strconv.ParseUint(s, 10, 64)
	return
}

func main() {
	fmt.Println(stringAdd("999999999999999999", "999999999999999999"))
	fmt.Println(isAdditiveNumber("101"))
	fmt.Println(isAdditiveNumber("1023"))

}
