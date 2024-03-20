# General Bit Manipulation Formulae
Bitwise Operations are much faster than other arithmetic operations like **`+,-,*,/,%`**

## Bit Wise Operators
- Most of the programming languages have **6 Bitwise operators**

### Bitwise Operators in C++ and Ruby
1. OR (|)
2. AND (&)
3. NOT (~)
4. XOR (^)
5. Right Shift (>>): Signed Right Shift operator
  - Preserves the sign of the number
  - Userful for -ve numbers
6. Left Shift (<<)

### Bitwise Operators in Java and JavaScript
7. Un-signed Right Shift (>>>)
  - Negative numbers become positive numbers with shifted value

### 2's complement: 
Used to store negative numbers
- Invert all the bits and add 1
- 2's complement of 'X' would be `(2^n) - X`, where `n` is the number of bits.
- Leading bit is always 0 for the -ve numbers

### Formulae:

1. **N&(N-1)**: This operation will always unset the **LSB** in N.
2. **a^0 = a**
3. **a^b = b^a**: XOR operation is commutative
4. **a^(b^c) = (a^b)^c = (a^c)^b**: XOR operation is associative  
5. **a^a = 0**
6. **a&(~(a-1)) = Math.pow(2, LSB(a))**: 
  - Any given number 'N' when operated with `&` on the negation of it's predecessor i.e., `(~(N-1))`, will return a number having ONLY the `LSB` of `N` as set bit.
  - The predecessor`(k-1)` of any number `K` will have the LSB of `K` as UNSET and rest all other bits to its right will be SET.

    ```ruby
      N = 12 # 1100, (2nd bit is the LSB)
      (N-1) = 11 # 1011: see 2nd point in 6th formula
      ~(N-1) = 4 # 0100: Only the 2nd bit is SET, => Math(2, 2)
    ```
7. `0xFF`: **0x** indicates it's hexa-decimal representation. **F** indicated **first four set bits** here. Similarly, **FF** indicates first 8 set bits.

<br/>
<br/>

## From the GFG source
The Bitwise Algorithms are used to perform operations at bit-level or to manipulate bits in different ways. The bitwise operations are found to be much faster and are some times used to improve the efficiency of a program.

For example: To check if a number is even or odd. This can be easily done by using Bitwise-AND(&) operator. If the last bit of the operator is set than it is ODD otherwise it is EVEN. Therefore, if num & 1 not equals to zero than num is ODD otherwise it is EVEN.

 

### Bitwise Operators

The operators that works at Bit level are called bitwise operators. In general there are six types of Bitwise Operators as described below:
 

1. `& (bitwise AND)` Takes two numbers as operands and does AND on every bit of two numbers. **The result of AND is 1 only if both bits are 1**. Suppose A = 5 and B = 3, therefore `A & B = 1`.
2. `| (bitwise OR)` Takes two numbers as operands and does OR on every bit of two numbers. **The result of OR is 1 if any of the two bits is 1.** Suppose A = 5 and B = 3, therefore `A | B = 7`.
3. `^ (bitwise XOR)` Takes two numbers as operands and does XOR on every bit of two numbers. **The result of XOR is 1 if the two bits are different**. Suppose A = 5 and B = 3, therefore `A ^ B = 6`.
4. `<< (left shift)` Takes two numbers, left shifts the bits of the first operand, the second operand decides the number of places to shift.
5. `>> (right shift)` Takes two numbers, right shifts the bits of the first operand, the second operand decides the number of places to shift.
6. `~ (bitwise NOT)` Takes one number and inverts all bits of it. Suppose A = 5, therefore `~A = -6`.


### Important Facts about Bitwise Operators:
- The left shift and right shift operators cannot be used with negative numbers.
- The bitwise XOR operator is the most useful operator from technical interview perspective. We will see some very useful applications of the XOR operator later in the course.
- The bitwise operators should not be used in place of logical operators.
- The left-shift and right-shift operators are equivalent to multiplication and division by 2 respectively.
- The & operator can be used to quickly check if a number is odd or even. The value of expression (x & 1) would be non-zero only if x is odd, otherwise the value would be zero.
- Time and Auxiliary Space used will be - O(1) 
