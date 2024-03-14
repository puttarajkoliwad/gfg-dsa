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
2. `0xFF`: **0x** indicates it's hexa-decimal representation. **F** indicated **first four set bits** here. Similarly, **FF** indicates first 8 set bits.