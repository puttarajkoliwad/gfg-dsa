// Given a number, count the number of digits in it and print it out

public class CountDigits{

  static int countDigits(int num){
    int count = 0;
    int res = num;
    while(num > 0){
      num %= 10;
      count++;
    }
    return count;
  }
  public static void main(String[] args) {
    // int num = 456;
    System.out.println("Hello");
    System.out.println(countDigits(45678));
  }
}