public class Song {
   private String name;
   private Artist artist;

   Song(String name, Artist artist) {
      this.name = name;
      this.artist = artist;
   }

   Song(String name, String artistName) {
      this.name = name;
      this.artist.setName(artistName);
   }

   public String getName() {
      return this.name;
   }

   public Artist getArtist() {
      return this.artist;
   }

   public String toString() {
      return this.artist.getName() + " - " + this.name;
   }

}
