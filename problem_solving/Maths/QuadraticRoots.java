class QuadraticRoots{
  static void printQuadraticRoots(int a, int b, int c){
    double secPart = Math.sqrt((b*b) - (4*a*c));
    System.out.println((b*b) - (4*a*c));
    System.out.println(secPart);
    int x1 = (int)(((-b) - secPart)/(2*a));
    int x2 = (int)(((-b) + secPart)/(2*a));
    System.out.println((int)((-b) - secPart));
    System.out.println((int)((-b) + secPart));
    // System.out.println((-b) + secPart);
    System.out.print(Math.max(x1,x2) + " ");
    System.out.println(Math.min(x1,x2));
  }
  
  public static void main(String[] args) {
    printQuadraticRoots(1, -7, 12);
    printQuadraticRoots(752, 904, 164);
  }
}