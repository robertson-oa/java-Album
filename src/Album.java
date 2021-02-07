import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name, artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }
    public boolean addSong(String titleOfSong, double durationOfSong){
        Song newSong= new Song(titleOfSong, durationOfSong);
        if(findSong(titleOfSong) == null){
            songs.add(newSong);
            return true;
        }
        else return false;
    }
    private Song findSong(String titleOfSong){
        for(int i = 0; i < songs.size(); i++){
            if(songs.get(i).getTitle().equals(titleOfSong)) {
                return songs.get(i);
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumberOfSong, LinkedList<Song> playlist){
        if(trackNumberOfSong < songs.size() && trackNumberOfSong > -1){
            playlist.add(songs.get(trackNumberOfSong));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(String titleOfSong, LinkedList<Song> playlist){
        if(findSong(titleOfSong) != null){
            playlist.add(findSong(titleOfSong));
            return true;
        }
        return false;
    }
    public void printSongs(){
        for(Song song: songs){
            System.out.println(song.toString());
        }
    }
}
