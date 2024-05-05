package net.mocko.reforged.tools.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.mocko.reforged.material.ModMaterials;
import net.mocko.reforged.material.MaterialHelper;
import net.mocko.reforged.tools.nbt.ToolNBTHelper;

import javax.annotation.Nullable;
import java.util.List;

public class ModularSwordItem extends SwordItem {



    public ModularSwordItem(Properties properties){
        super(ModMaterials.DEFAULT,0,0,properties);
    }

    public static int getColor(ItemStack stack, int tintIndex) {

        if(tintIndex == 0)
        {
            CompoundTag compoundTag = stack.getOrCreateTag();
            return ToolNBTHelper.getHandleMaterialFromNBT(compoundTag).getColor();
        }
        else if(tintIndex == 1)
        {
            CompoundTag compoundTag = stack.getOrCreateTag();
            return ToolNBTHelper.getMainMaterialFromNBT(compoundTag).getColor();
        }
        else
        {
            return 0xFFFFFF;
        }
    }

/*
    @Override
    public float getDamage(ItemStack tool)
    {
        return MaterialHelper.getMainMaterial(tool).getUses();
    }
*/

    @Override
    public int getMaxDamage(ItemStack tool)
    {
        return MaterialHelper.getMainMaterial(tool).getUses();
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            String currentMainMaterial = "Main: " + pStack.getTag().getString("reforged.main_material");
            pTooltipComponents.add(Component.literal(currentMainMaterial).withStyle(Style.EMPTY.withColor(MaterialHelper.getMainMaterial(pStack).getColor())));

            String currentHandleMaterial = "Handle: " + pStack.getTag().getString("reforged.handle_material");

            pTooltipComponents.add(Component.literal(currentHandleMaterial).withStyle(Style.EMPTY.withColor(MaterialHelper.getHandleMaterial(pStack).getColor())));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
