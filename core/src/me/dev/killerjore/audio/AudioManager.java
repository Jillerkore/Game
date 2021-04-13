package me.dev.killerjore.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {

    private final String baseDirectory = "audio/sfx/", baseDirectoryMusic = "audio/";
    private static AudioManager instance;
    private AssetManager audioAsset;

    public Sound
            attackSwing,
            magicCast,
            inGameMusic,
            interface1,
            interface2,
            interface3,
            interface4,
            interface5,
            armorLight,
            beads,
            bottle,
            bubble,
            bubble2,
            bubble3,
            chainmail1,
            chainmail2,
            cloth,
            clothHeavy,
            coin,
            weapon;

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
        audioAsset.load(baseDirectory + "inventory/armor-light.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/beads.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/bottle.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/bubble.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/bubble2.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/bubble3.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/chainmail1.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/chainmail2.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/cloth.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/cloth-heavy.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/coin.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/coin2.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/metal-ringing.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/metal-small1.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/metal-small2.ogg", Sound.class);
        audioAsset.load(baseDirectory + "inventory/metal-small3.ogg", Sound.class);
        audioAsset.load(baseDirectoryMusic + "ingameTheme.mp3", Sound.class);
        audioAsset.load(baseDirectoryMusic + "titleScreen.mp3", Sound.class);
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

        beads = audioAsset.get(baseDirectory + "inventory/beads.ogg", Sound.class);
        bottle = audioAsset.get(baseDirectory + "inventory/bottle.ogg", Sound.class);
        bubble = audioAsset.get(baseDirectory + "inventory/bubble.ogg", Sound.class);
        bubble2 = audioAsset.get(baseDirectory + "inventory/bubble2.ogg", Sound.class);
        bubble3 = audioAsset.get(baseDirectory + "inventory/bubble3.ogg", Sound.class);
        chainmail1 = audioAsset.get(baseDirectory + "inventory/chainmail1.ogg", Sound.class);
        chainmail2 = audioAsset.get(baseDirectory + "inventory/chainmail2.ogg", Sound.class);
        cloth = audioAsset.get(baseDirectory + "inventory/cloth.ogg", Sound.class);
        clothHeavy = audioAsset.get(baseDirectory + "inventory/cloth-heavy.ogg", Sound.class);
        coin = audioAsset.get(baseDirectory + "inventory/coin.ogg", Sound.class);
        weapon = audioAsset.get(baseDirectory + "combat/sword-unsheathe3.ogg", Sound.class);

    }

    public void dispose() {
        audioAsset.dispose();
    }

}
