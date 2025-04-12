// https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-week-preparation-kit&playlist_slugs%5B%5D=one-week-day-one

/*
	i/p: 1 2 3 4 5
	o/p: 10, 14
*/

package main

import (
	"fmt"
	"bufio"
	"strings"
	"strconv"
	"os"
	"slices"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	strArr := strings.Split(strings.TrimSpace(readLine(reader)), " ")

	var arr []int32

	for i:=0; i<len(strArr); i++ {
		temp, err := strconv.ParseInt(strArr[i], 10, 32)

		if err != nil {
			fmt.Println("Unable convert string to int: ", err)
			panic(err)
		}

		arr = append(arr, int32(temp))
	}

	miniMaxSum(arr)
}

func readLine(reader *bufio.Reader) string {
	line, _, err := reader.ReadLine()

	if err != nil {
		return ""
	}

	return strings.TrimRight(string(line), "\r\n")
}

func miniMaxSum(arr []int32) {
	min, max, sum := slices.Min(arr), slices.Max(arr), int32(0)
	for i :=0; i<len(arr); i++ {
		sum += arr[i]
	}

	fmt.Println(sum-max, sum-min)
}