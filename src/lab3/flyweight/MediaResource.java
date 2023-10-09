package lab3.flyweight;

public class MediaResource {
    private String fileName;
    private String type;

    public MediaResource(String fileName, String type) {
        this.fileName = fileName;
        this.type = type;
    }

    public void play() {
        System.out.println("Playing " + type + ": " + fileName);
    }
}
