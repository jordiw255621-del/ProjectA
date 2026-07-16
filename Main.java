class SeatingView {
  int[][] seats;

  SeatingView() {
    seats = new int[10][10];
    seats[3][6] = 1;
  }

  public void printSeating() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(seats[i][j] + " ") ;
      }
      System.out.println();
    }
  }
}
class Main {
  public static void main(String[] args) {
    SeatingView seating = new SeatingView();
    seating.printSeating();
  }

}
