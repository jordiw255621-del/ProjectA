// The actual app file to be ran

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        Artist artist1 = new Artist("bob", "bob@gmail.com", "pop");
        Booking booking1 = new Booking(artist1, 10);
        booking1.addSong(new Song("coolsong", artist1));
        booking1.addSong(new Song("awesomesong", artist1));
        booking1.addSong(new Song("badsong", artist1));
        booking1.printSongProgram();

        booking1.rearrangeSongOrder(1, 2);
        booking1.printSongProgram();
        main.makeBooking(booking1);
        main.displayBookings();
    }
}
