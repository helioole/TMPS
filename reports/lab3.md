# Laboratory Work Nr.3

### Course: Software Design Techniques and Mechanisms
### Topic: Structural Design Patterns
### Author: Racovcena Irina
### Group: FAF-212

------
## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Design patterns which were implemented in this project:

* Adapter
* Decorator
* Facade
* Flyweight

## Implementation

### Adapter
**Adapter** is a structural design pattern that allows objects with incompatible interfaces to collaborate.

In my project the `MediaAdapter` class acts as an adapter pattern. 
It allows different media types (audio and video) to be played through 
a common interface, `MediaPlayer`. When you create a `MediaAdapter`, 
it internally delegates the media playback to the appropriate `AudioPlayer` 
or `VideoPlayer` depending on the media type.

Example in code:

```java
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

```

### Decorator
**Decorator** is a structural design pattern that lets you attach new 
behaviors to objects by placing these objects inside special wrapper 
objects that contain the behaviors.

I used Decorator pattern for enhancing media playback. 
The `MediaEnhancer` interface represents the decorators, and 
concrete decorators like `SubtitleDecorator`, `SpeedAdjustDecorator`, 
and `EffectDecorator` add different enhancements to the media playback. 
These decorators can be combined and applied to a media player to enhance 
the playback experience.

Example in code:

```java
public interface MediaEnhancer {
    void enhance();
}
```

```java
public class EffectDecorator implements MediaEnhancer {
    @Override
    public void enhance() {
        System.out.println("Applying special effects");
    }
}

```

```java
public class SpeedAdjustDecorator implements MediaEnhancer {
    @Override
    public void enhance() {
        System.out.println("Adjusting playback speed");
    }
}
```

```java
public class SubtitleDecorator implements MediaEnhancer {
    @Override
    public void enhance() {
        System.out.println("Adding subtitles");
    }
}
```

```java
public class MediaPlayerFacade {
    ...

    public void playWithEnhancement(String fileName) {
        mediaPlayer.play(fileName);
        if (enhancer != null) {
            enhancer.enhance();
        }
    }
}
```

### Facade

**Facade** is a structural design pattern that provides a simplified interface to a 
library, a framework, or any other complex set of classes.

The Facade pattern provides a simplified interface `MediaPlayerFacade` 
that abstracts the complexity of interacting with different media types and enhancements. 
Clients can interact with the facade to play media with or without enhancements, 
without needing to know the underlying system.

Example in code:

```java
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
```

### Flyweight

**Flyweight** is a structural design pattern that lets you fit more objects into 
the available amount of RAM by sharing common parts of state between multiple 
objects instead of keeping all of the data in each object.

The `MediaResource` class represents shared media resources and the `MediaFactory` 
class manages and shares these resources. When you request a media resource using 
`MediaFactory`, it checks if an instance for the same media file and type exists and reuses 
it if available, minimizing memory usage.

Example in code:
```java
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

```

```java
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
```

## Conclusion

In this laboratory work, I explored and implemented several 
important structural design patterns, specifically the Adapter, 
Decorator, Facade, and Flyweight patterns.Each of these patterns serves 
distinct purposes in software design and can be applied to solve 
specific problems efficiently.
These patterns provide valuable tools for designing software systems 
that are both flexible and efficient.