import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MusicManager {
    private Set<Song> allSongs;

    public MusicManager() {
        allSongs = new HashSet<>();
    }

    public void addSong(Song s) {
        if (allSongs.contains(s)) {
            System.out.println("The song is already in the set!");
        }
        allSongs.add(s);
    }

    public List<Song> makePlayList(String a) {
        // List<Song> listForArtist = new ArrayList<>();
        // for (Song s : allSongs) {
        // if (s.getArtist().equals(a)) {
        // listForArtist.add(s);
        // }
        // }
        List<Song> listForArtist = allSongs.stream()
                .filter(s -> s.getArtist().equals(a))
                .toList();
        return listForArtist;
    }

    public boolean remove(int y) {
        boolean hasRemoved = false;
        for (Song s : allSongs) {
            if (s.getYear() == y) {
                allSongs.remove(s);
                hasRemoved = true;
            }
        }
        return hasRemoved;
    }

    public Map<String, Integer> artistSongs() {
        Map<String, Integer> artistsWithSongQuantity = new HashMap<>();
        for (Song s : allSongs) {
            String artist = s.getArtist();
            int songQuantity = 1;
            if (artistsWithSongQuantity.containsKey(artist)) {
                songQuantity += artistsWithSongQuantity.get(artist);
            }
            artistsWithSongQuantity.put(artist, songQuantity);
        }
        return artistsWithSongQuantity;
    }

    public void playWithAds(List<Song> l) {
        for (int i = 0; i < l.size(); i++) {
            l.get(i).play();
            if ((i + 1) % 5 == 0) {
                System.out.println("playing advertisements");
            }
        }
    }

    public Song findMostPopular(List<Song> l) {
        Song songWithHighstLike = l.get(0);
        for (Song s : l) {
            if (s.compare(songWithHighstLike)) {
                songWithHighstLike = s;
            }
        }
        return songWithHighstLike;
    }

    public void playTopHits(List<Song> l) {
        // Collections.sort(l);
        // l.sort((s1, s2) ->
        // Integer.valueOf(s2.getLikes()).compareTo(Integer.valueOf(s1.getLikes())));
        int songQuantity = 20;
        if (l.size() >= songQuantity) {
            l.sort((s1, s2) -> s2.getLikes() - s1.getLikes());
        } else {
            songQuantity = l.size();
        }
        for (int i = 0; i < songQuantity; i++) {
            l.get(i).like();
            l.get(i).play();
            l.remove(i);
            i--;
            songQuantity--;
        }
    }

    public static void main(String[] args) {
        Song a = new Song("hi1", "aiali", 2010);
        Song b = new Song("hi2", "aiali", 2011);
        Song c = new Song("hi3", "jiali", 2011);
        Song d = new Song("hi4", "jiali", 2011);
        Song e = new Song("hi5", "jiali", 2011);
        Song f = new Song("hi6", "jiali", 2011);
        Song g = new Song("hi7", "jiali", 2011);
        a.like();
        b.like();
        b.like();
        g.like();
        g.like();
        g.like();
        MusicManager m = new MusicManager();
        List<Song> l = new ArrayList<>(Arrays.asList(a, b, c, d, e, f, g));
        m.playTopHits(l);
    }

}
