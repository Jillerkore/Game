package me.dev.killerjore.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

    private final String baseDirectory = "audio/sfx/", baseDirectoryMusic = "audio/";
    private static AudioManager instance;
    private AssetManager audioAsset;

    public Sound attackSwing,
            magicCast,
            spellCast,
            swordUnsheathe,
            inGameMusic,
            interface1,
            interface2,
            interface3,
            interface4,
            interface5,
            interface6;

    public static AudioManager getInstance() { if (instance == null) instance = new AudioManager(); return instance; }

    private AudioManager() {
        audioAsset = new AssetManager();
        audioAsset.load(baseDirectory + "combat/swing.ogg", Sound.class);
        audioAsset.load(baseDirectory + "combat/magic1.ogg", Sound.class);
        audioAsset.load(baseDirectory + "combat/sword-unsheathe3.ogg", Sound.class);
        audioAsset.load(baseDirectory + "combat/sword-unsheathe4.ogg", Sound.class);
        audioAsset.load(baseDirectory + "combat/sword-unsheathe5.ogg", Sound.class);
        audioAsset.load(baseDirectory + "interface/interface1.ogg", Sound.class);
        audioAsset.load(baseDirectory + "interface/interface2.ogg", Sound.class);
        audioAsset.load(baseDirectory + "interface/interface3.ogg", Sound.class);
        audioAsset.load(baseDirectory + "interface/interface4.ogg", Sound.class);
        audioAsset.load(baseDirectory + "interface/interface5.ogg", Sound.class);
        audioAsset.load(baseDirectoryMusic + "ingameTheme.mp3", Sound.class);
        audioAsset.finishLoading();

        initializeAudioVariables();
    }

    private void initializeAudioVariables() {
        attackSwing = audioAsset.get(baseDirectory + "combat/swing.ogg");
        magicCast = audioAsset.get(baseDirectory + "combat/magic1.ogg");
        inGameMusic = audioAsset.get(baseDirectoryMusic + "ingameTheme.mp3");
        interface1 = audioAsset.get(baseDirectory + "interface/interface1.ogg", Sound.class);
        interface2 = audioAsset.get(baseDirectory + "interface/interface2.ogg", Sound.class);
        interface3 = audioAsset.get(baseDirectory + "interface/interface3.ogg", Sound.class);
        interface4 = audioAsset.get(baseDirectory + "interface/interface4.ogg", Sound.class);
        interface5 = audioAsset.get(baseDirectory + "interface/interface5.ogg", Sound.class);
    }

    public void dispose() {
        attackSwing.dispose();
        audioAsset.dispose();
    }

}
