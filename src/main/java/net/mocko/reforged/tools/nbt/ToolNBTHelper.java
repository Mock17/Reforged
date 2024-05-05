package net.mocko.reforged.tools.nbt;

import net.minecraft.nbt.CompoundTag;
import net.mocko.reforged.material.ModMaterials;

import java.util.Locale;

public class ToolNBTHelper {


/*
Class for returning data stored in NBTs
*/


    public static ModMaterials fromNBT(CompoundTag compoundTag, String tagName){
        ModMaterials material = ModMaterials.DEFAULT; //DEFAULT IN CASE OF ERROR
        if(compoundTag != null && compoundTag.contains(tagName)){
            material = ModMaterials.valueOf(tagName);
        }
        return material;
    }


    public static ModMaterials getMainMaterialFromNBT(CompoundTag compoundTag){
        ModMaterials material = ModMaterials.DEFAULT; //DEFAULT IN CASE OF ERROR
        if(compoundTag != null && compoundTag.contains("reforged.main_material")){
            material = ModMaterials.valueOf(compoundTag.getString("reforged.main_material").toUpperCase(Locale.ROOT));
        }
        return material;
    }

    public static ModMaterials getHandleMaterialFromNBT(CompoundTag compoundTag){
        ModMaterials material = ModMaterials.DEFAULT; //DEFAULT IN CASE OF ERROR
        if(compoundTag != null && compoundTag.contains("reforged.handle_material")){
            material = ModMaterials.valueOf(compoundTag.getString("reforged.handle_material").toUpperCase(Locale.ROOT));
        }
        return material;
    }


    public static ModMaterials getPartMaterialFromNBT(CompoundTag compoundTag){
        ModMaterials material = ModMaterials.DEFAULT; //DEFAULT IN CASE OF ERROR
        if(compoundTag != null && compoundTag.contains("reforged.material")){
            material = ModMaterials.valueOf(compoundTag.getString("reforged.material").toUpperCase(Locale.ROOT));
        }
        return material;
    }
}




