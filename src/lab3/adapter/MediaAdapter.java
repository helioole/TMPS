package lab3.adapter;
public class MediaAdapter implements MediaPlayer {
    private MediaPlayer mediaPlayer;

    public MediaAdapter(String mediaType) {
        if (mediaType.equalsIgnoreCase("audio")) {
            mediaPlayer = new AudioPlayer();
        } else if (mediaType.equalsIgnoreCase("video")) {
            mediaPlayer = new VideoPlayer();
        }
    }

    @Override
    public void play(String fileName) {
        mediaPlayer.play(fileName);
    }
}
