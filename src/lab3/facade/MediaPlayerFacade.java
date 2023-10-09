package lab3.facade;

import lab3.adapter.MediaAdapter;
import lab3.adapter.MediaPlayer;
import lab3.decorator.EffectDecorator;
import lab3.decorator.MediaEnhancer;
import lab3.decorator.SpeedAdjustDecorator;
import lab3.decorator.SubtitleDecorator;

public class MediaPlayerFacade {
    private MediaPlayer mediaPlayer;
    private MediaEnhancer enhancer;

    public MediaPlayerFacade(String mediaType, String enhancement) {
        mediaPlayer = new MediaAdapter(mediaType);
        switch (enhancement.toLowerCase()) {
            case "subtitle":
                enhancer = new SubtitleDecorator();
                break;
            case "speed":
                enhancer = new SpeedAdjustDecorator();
                break;
            case "effect":
                enhancer = new EffectDecorator();
                break;
            default:
                enhancer = null;
        }
    }

    public void playWithEnhancement(String fileName) {
        mediaPlayer.play(fileName);
        if (enhancer != null) {
            enhancer.enhance();
        }
    }
}