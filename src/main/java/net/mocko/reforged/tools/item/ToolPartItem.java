package net.mocko.reforged.tools.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.mocko.reforged.material.ModMaterials;
import net.mocko.reforged.tools.nbt.ToolNBTHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ToolPartItem extends Item {

    public ToolPartItem(Item.Properties properties){
        super(properties);
     }

    public static void setMaterial(ItemStack stack, ModMaterials material)
    {
        CompoundTag compoundTag = stack.getOrCreateTag();
        compoundTag.putString("reforged.material", material.getName());
        stack.setTag(compoundTag);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            String currentMaterial = pStack.getTag().getString("reforged.material");
            pTooltipComponents.add(Component.literal(currentMaterial).withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void fillItemCategory(CreativeModeTab p_41391_, NonNullList<ItemStack> p_41392_) {
        if (this.allowedIn(p_41391_)) {
            for(ModMaterials material: ModMaterials.values())
            {
                ItemStack stack = new ItemStack(this);
                setMaterial(stack,material);
                p_41392_.add(stack);
            }
        }
    }
}
