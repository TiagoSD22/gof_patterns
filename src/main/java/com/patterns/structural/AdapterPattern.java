package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Adapter Pattern - Converts the interface of a class into another
 * interface clients expect.
 */
public final class AdapterPattern implements Demonstrable {
    
    // Target interface
    private interface MediaPlayer {
        void play(String audioType, String fileName);
    }
    
    // Adaptee
    private static final class AdvancedMediaPlayer {
        public void playVlc(String fileName) {
            Logger.log("Playing VLC file: " + fileName);
        }
        
        public void playMp4(String fileName) {
            Logger.log("Playing MP4 file: " + fileName);
        }
    }
    
    // Adapter
    private static final class MediaAdapter implements MediaPlayer {
        private final AdvancedMediaPlayer advancedPlayer;
        
        public MediaAdapter() {
            this.advancedPlayer = new AdvancedMediaPlayer();
        }
        
        @Override
        public void play(String audioType, String fileName) {
            switch (audioType.toLowerCase()) {
                case "vlc" -> advancedPlayer.playVlc(fileName);
                case "mp4" -> advancedPlayer.playMp4(fileName);
                default -> Logger.log("Invalid media type: " + audioType);
            }
        }
    }
    
    // Client
    private static final class AudioPlayer implements MediaPlayer {
        private final MediaAdapter mediaAdapter;
        
        public AudioPlayer() {
            this.mediaAdapter = new MediaAdapter();
        }
        
        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                Logger.log("Playing MP3 file: " + fileName);
            } else if (audioType.equalsIgnoreCase("vlc") || 
                       audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter.play(audioType, fileName);
            } else {
                Logger.log("Invalid media type: " + audioType);
            }
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Adapter Pattern");
        
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("vlc", "movie.vlc");
        player.play("mp4", "video.mp4");
        player.play("avi", "file.avi");
    }
}
