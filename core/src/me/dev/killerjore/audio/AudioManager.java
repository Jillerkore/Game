package me.dev.killerjore.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

    private final String baseDirectory = "audio/sfx/";
    private static AudioManager instance;
    private AssetManager audioAsset;

    public Sound attackSwing, magicCast, spellCast, swordUnsheathe;

    public static AudioManager getInstance() { if (instance == null) instance = new AudioManager(); return instance; }

    private AudioManager() {
        audioAsset = new AssetManager();
        audioAsset.load(baseDirectory + "combat/swing.ogg", Sound.class);
        audioAsset.finishLoading();

        initializeAudioVariables();
    }

    private void initializeAudioVariables() {
        attackSwing = audioAsset.get(baseDirectory + "combat/swing.ogg");
    }

    public void dispose() {
        attackSwing.dispose();
        audioAsset.dispose();
    }

}
