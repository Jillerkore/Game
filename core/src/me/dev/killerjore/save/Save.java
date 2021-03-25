package me.dev.killerjore.save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.attacker.movable.Player;
import me.dev.killerjore.ui.inventory.Inventory;
import me.dev.killerjore.ui.inventory.InventorySlot;
import me.dev.killerjore.ui.save.SaveText;
import me.dev.killerjore.world.WorldManager;

import java.io.*;

public class Save {

    private static Save instance;
    public static Save getInstance() { if (instance == null) instance = new Save(); return instance; }

    private FileHandle handle;
    private GameData data;

    private boolean initialized;

    public boolean isInitialized() { return initialized; }
    public GameData getData() { return data; }

    private Save() {
        initialize();
    }

    private void initialize() {
        handle = Gdx.files.local("player.sav");
        data = new GameData();
        if (!handle.exists()) {
            initialized = false;
            data.init();
        }else {
            initialized = true;
            try {
                load();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void save() throws IOException {
        Player player = EntityManager.getInstance().getPlayer();

        // Loads everything into save object
        data.setHealth(player.getHealth());
        data.setMaxHealth(player.getMaxHealth());
        data.setStamina(player.getStamina());
        data.setMaxStamina(player.getMaxStamina());
        data.setPlayerX((int)player.getOffsetX());
        data.setPlayerY((int)player.getOffsetY());
        data.setWorldType(WorldManager.getInstance().getCurrentWorldType());
        InventorySlot[] slot = Inventory.getInstance().getInventorySlots();
        InventorySlot[] slot1 = Inventory.getInstance().getHotbarSlots();
        for (int i = 0; i < slot.length; i++) {
            data.getInventoryItems()[i].setId(-1);
            if (slot[i].getHoldingItem() != null) {
                data.getInventoryItems()[i].setId(slot[i].getHoldingItem().getId());
            }
            if (i < slot1.length) {
                data.getHotbarItems()[i].setId(-1);
                if (slot1[i].getHoldingItem() != null) {
                    data.getHotbarItems()[i].setId(slot1[i].getHoldingItem().getId());
                }
            }

        }

        // Deploys the object into player.sav file
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(data);
        oos.flush();
        byte[] data = bos.toByteArray();
        handle.writeBytes(data, false);

        SaveText.getInstance().setRender(180);

    }
    private void load() throws IOException, ClassNotFoundException {
        byte[] bytes = handle.readBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInput in = new ObjectInputStream(bis);
        Object data = in.readObject();

        this.data = (GameData) data;

    }
}
