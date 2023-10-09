package lab3.adapter;

import lab3.flyweight.MediaFactory;
import lab3.flyweight.MediaResource;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        MediaResource mediaResource = MediaFactory.getMediaResource(fileName, "audio");
        mediaResource.play();
    }
}