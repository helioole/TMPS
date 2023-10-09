package lab3;

import lab3.facade.MediaPlayerFacade;

public class MultimediaPlayerApp {
    public static void main(String[] args) {
        MediaPlayerFacade audioPlayer = new MediaPlayerFacade("audio","subtitle");
        audioPlayer.playWithEnhancement("song.mp3");

        MediaPlayerFacade videoPlayer = new MediaPlayerFacade("video", "speed");
        videoPlayer.playWithEnhancement("movie.mp4");
    }
}
