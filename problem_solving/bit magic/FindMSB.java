/**
 * FindMSB: https://www.codingninjas.com/studio/problem-details/find-msb-in-o-1_1112570#:~:text=03-,Approach,-Approach%3A%20When
  Approach: When the size of the integer is fixed (32 bits in this case), we can try to set all the bits of N by making bitwise OR operations after performing logical right shift operations (>>).

Logical right shift (>>) operation takes two numbers such as a >> b. Then it shifts the bits of a to b places towards the right. For example, if a = 11 and b = 1, then the binary representation of a is 1011. So after performing a >> b, all the bits of a are shifted one bit towards the right and the MSB(Most Significant Bit) is filled with 0. So, now a becomes 0101, and the decimal value is 5.

Now let’s understand the algorithm by taking N = 256. So, the binary representation of N is 100000000. We can make N = N | N >> 1. Now N = 384 and the binary representation is 110000000. So, by doing the above step, we are making sure that 2 bits from MSB including the MSB are set.

Then we will make N = N | N >> 2. Now, N = 480 and the binary representation is 111100000. So, 4 bits from MSB will be set. 

Similarly, we will do N = N | N >> 4 and 8 bits from MSB will be set. After N = N | N >> 8, 16 bits from MSB will be set. And finally, after N = N | N >> 16, all the bits from the MSB will be set. Note that, if the number of bits of a number is less than 16, then the step N = N | N >> 16, doesn’t change anything.

So, now all the bits of N are set. Now increase N by 1, so that only the bit just before the original bit is set. For example, if N = 7, the binary representation of N is 111. If we increase N by 1, then N becomes 8 and the binary representation is 1000. So, the bit just before the original bit is set. Finally, right shift N by 1 and return the answer.
 */

/*
 Simple explanation: Given a number, somehow, SET all the bits to the right of MSB including MSB.
 This will max out the limit for that MSB length.
 The next number will be have only one SET bit, placed to left of MSB and would have unset rest of the bits.
 Now, right shift that only set bit by one place.
 Now only the MSB of original number is set. Retun the MSB set number. 

 Let N = 5:
 => 5 => 101
 5|(5 >> 1) => 101 | 010 = 111 => 7
 7 | (7 >> 2) => 111 | 001 = 111 => 7
 7 | (7 >> 4) => 111 | 000 = 111 => 7
 7 | (7 >> 8) => 111 | 000 => 111 => 7
 7 | (7 >> 16) => 111 | 000 => 111 => 7

 Notice the new number didn't change on (N|(N>>(2^k))) once all the bits to the MSB were set. For some numbers it'll max out very soon like here it maxed out at first step only. But, for numbers like 2**(32-1), it would max out on the last iteration(i.e. N|(N>>16)). So, to cover every number we always go till N >> 16 step.

*/

// import java.lang.Math;

public class FindMSB {
  static int findMSB(int n){
    // set all the bits to the right of MSB
    n = n|(n>>1);
    n = n|(n>>2);
    n = n|(n>>4);
    n = n|(n>>8);
    n = n|(n>>16);
    // covered for 32 bit integers. Add further steps for higher numbers.

    // jump to next number and right shift it by one
    return (n+1)>>1;
  }
  public static void main(String[] args) {
    System.out.println(findMSB(7));
    System.out.println(findMSB(8));
    System.out.println(findMSB(6));
    System.out.println(findMSB((int)Math.pow(2, 8)));
    System.out.println(findMSB((int)Math.pow(2, 8)-1));
  }
}