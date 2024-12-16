// https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one

/*
input:
	6
	-4 3 -9 0 4 1

o/p:
	0.500000
	0.333333
	0.166667

explaination:
	There are 3 positive numbers, 2 negative numbers, and 1 zero in the array.
	The proportions of occurrence of positives, negatives and zeros are in output respectively.
*/

package main

import (
	"bufio"
	"fmt"
	// "io"
	"os"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	n, err := strconv.Atoi(strings.TrimSpace(readLine(reader)))

	if err != nil {
		fmt.Println("Error reading array length!")
		panic(err)
	}

	tempArr := strings.Split(strings.TrimSpace(readLine(reader)), " ")

	var arr []int
	for i:= 0; i < n; i++ {
		arrItem, err := strconv.Atoi(tempArr[i])

		if err != nil {
			fmt.Println("Error converting array element")
			panic(err)
		}
		arr = append(arr, arrItem)
	}

	plusMinus(arr)
}

func readLine(reader *bufio.Reader) string {
	line, _, err := reader.ReadLine()

	if err != nil {
		return ""
	}

	return strings.TrimRight(string(line), "\r\n")
}

func plusMinus(arr []int) {
	var pc, nc, zc int

	for i := range arr {
		if arr[i] > 0 {
			pc++
		}else if arr[i] < 0 {
			nc++
		}else {
			zc++
		}
	}

	n := len(arr)

	fmt.Printf("%.6f\n", float64(pc)/float64(n))
	fmt.Printf("%.6f\n", float64(nc)/float64(n))
	fmt.Printf("%.6f\n", float64(zc)/float64(n))
}