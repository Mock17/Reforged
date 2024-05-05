package net.mocko.reforged.client;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.mocko.reforged.tools.nbt.ToolNBTHelper;

public class ColorHandler {
    public static int getColor(ItemStack stack) {
        CompoundTag compoundTag = stack.getOrCreateTag();
        return ToolNBTHelper.getPartMaterialFromNBT(compoundTag).getColor();
    }
}
