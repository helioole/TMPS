package lab3.flyweight;

import java.util.HashMap;
import java.util.Map;

public class MediaFactory {
    private static Map<String, MediaResource> mediaResources = new HashMap<>();

    public static MediaResource getMediaResource(String fileName, String type) {
        String key = fileName + "_" + type;
        if (!mediaResources.containsKey(key)) {
            mediaResources.put(key, new MediaResource(fileName, type));
        }
        return mediaResources.get(key);
    }
}
