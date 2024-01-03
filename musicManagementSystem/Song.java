public class Song implements Comparable<Song> {
    private String title, artist;
    private int likes, year;

    public Song(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        likes = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getLikes() {
        return likes;
    }

    public int getYear() {
        return year;
    }

    public void like() {
        likes += 1;
    }

    public boolean compare(Song anotherSong) {
        return likes > anotherSong.getLikes();
    }

    public void play() {
        System.out.println(String.format("The song Title: %s, Artist: %s, Year: %d is playing!", title, artist, year));
    }

    @Override
    public int compareTo(Song that) {
        if (this.getLikes() < that.getLikes()) {
            return 1;
        } else if (this.getLikes() == that.getLikes()) {
            if (this.getArtist() != that.getArtist()) {
                return this.getArtist().compareTo(that.getArtist());
            } else {
                return this.getTitle().compareTo(that.getTitle());
            }
        } else {
            return -1;
        }
    }

}