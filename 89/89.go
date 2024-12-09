func grayCode(n int) []int {
	nn := 1 << n
	// int mask = nn-1;
	res := make([]int, nn)

	for i := 0; i < nn; i++ {
		res[i] = i ^ (i >> 1)
	}
	return res
}