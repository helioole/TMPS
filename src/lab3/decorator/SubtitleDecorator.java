package lab3.decorator;

public class SubtitleDecorator implements MediaEnhancer {
    @Override
    public void enhance() {
        System.out.println("Adding subtitles");
    }
}
