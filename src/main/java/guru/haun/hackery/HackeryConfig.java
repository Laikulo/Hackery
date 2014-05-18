package guru.haun.hackery;


import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * Created by KJ4IPS on 5/18/2014.
 */
public class HackeryConfig extends Configuration {

    public boolean glitchShaders;
    public int idEnchInfect;
    public int idEnchSpread;
    public int idEnchQuest;

    public HackeryConfig(File file) {

        super(file);
        this.load();

        Property propShaders = this.get("Saftey","Shaders","true");
        propShaders.comment = "Disable this if you are sensitive to flashing lights!!!";
        glitchShaders = propShaders.getBoolean(false);

        Property propEnchInfect = this.get("Enchantments","Infect",59);
        idEnchInfect = propEnchInfect.getInt();

        Property propEnchSpread = this.get("Enchantments","Contagion",60);
        idEnchSpread = propEnchSpread.getInt();

        Property propEnchQuest = this.get("Enchantments", "Quest Item",58);
        idEnchQuest = propEnchQuest.getInt();

        this.save();


    }

}
