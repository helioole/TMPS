package lab3.adapter;

import lab3.flyweight.MediaFactory;
import lab3.flyweight.MediaResource;

public class VideoPlayer implements MediaPlayer {
    @Override
    public void play(String fileName) {
        MediaResource mediaResource = MediaFactory.getMediaResource(fileName, "video");
        mediaResource.play();
    }
}