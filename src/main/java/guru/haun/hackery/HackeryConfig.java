package guru.haun.hackery;


import net.minecraft.potion.Potion;
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
    public int idEffectGlitch;
    public String gfPotionReq;
    public String gpPotionEff;

    public HackeryConfig(File file) {

        super(file);
        this.load();

        Property propShaders = this.get("Safety","Shaders",true);
        propShaders.comment = "Disable this if you are sensitive to flashing lights!!!";
        glitchShaders = propShaders.getBoolean(false);

        Property propEnchInfect = this.get("Enchantments","Infect",59);
        idEnchInfect = propEnchInfect.getInt();

        Property propEnchSpread = this.get("Enchantments","Contagion",60);
        idEnchSpread = propEnchSpread.getInt();

        Property propEnchQuest = this.get("Enchantments", "Quest Item",58);
        idEnchQuest = propEnchQuest.getInt();

        Property propPotionId = this.get("Potions", "glitchfestEffectId", 30);
        if(propPotionId.getInt() >= Potion.potionTypes.length){
            HackeryMod.logger.error("The specified potion ID is out of range, {} was given, but the highest allowed is {}! Fix the config!",propPotionId.getInt(), Potion.potionTypes.length-1);
            throw new RuntimeException();
        }
        propPotionId.comment = "The potion ID that hackery will use for glitchfest";
        idEffectGlitch = propPotionId.getInt();

        Property propPotionReq = this.get("Brewing","glitchfestPotionRequirement", " 0 & 1 & !2 & 3 & 10 & 3+6");
        gfPotionReq = propPotionReq.getString();

        Property propPotionEff = this.get("Brewing","glitchPowderPotionEffect","+0+1-2+3+10+13&4-4");
        gpPotionEff = propPotionEff.getString();

        this.save();


    }

}
