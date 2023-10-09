package lab3.decorator;

public class EffectDecorator implements MediaEnhancer {
    @Override
    public void enhance() {
        System.out.println("Applying special effects");
    }
}
