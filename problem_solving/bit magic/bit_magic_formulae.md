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
