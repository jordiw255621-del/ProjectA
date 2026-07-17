import java.util.ArrayList;
import java.util.List;

class SeatingView {
  int[][] seats;

  SeatingView() {
    seats = new int[10][10];
    seats[3][6] = 1;
  }

  public void printSeating() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(seats[i][j] + " ");
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

class Timeline { //represents all the events in chronological order e.g [Event1, Event2]
  List<Event> timeline;

  Timeline() {
    this.timeline = new ArrayList<>();
  }

}

class Event {
  String name;
  Artist artist;
  int date;

}

class Artist {
  String name;
}
