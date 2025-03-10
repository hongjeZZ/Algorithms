import java.util.*;

class Solution {
    
    static class Song {
        int id, play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, play));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> bestAlbum = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);

            songs.sort((a, b) -> (b.play == a.play) ? a.id - b.id : b.play - a.play);

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }

        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
}