package lab3.decorator;

public class SpeedAdjustDecorator implements MediaEnhancer {
    @Override
    public void enhance() {
        System.out.println("Adjusting playback speed");
    }
}
