package net.mocko.reforged.tools.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.mocko.reforged.tools.property.ToolPropertyHelper;

public interface IModularTool {

    default int getUses() {
        return 1;
    }


    default float getSpeed() {
        return 1.0f;
    }


    default float getAttackDamageBonus(ItemStack tool) {
        return ToolPropertyHelper.getAttackDamageBonus(tool);
    }


    default int getLevel() {
        return -1;
    }


    default int getEnchantmentValue() {
        return 0;
    }


    default Ingredient getRepairIngredient() {
        return Ingredient.EMPTY;
    }
}
