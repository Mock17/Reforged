package net.mocko.reforged.tools.property;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.mocko.reforged.material.ModMaterials;
import net.mocko.reforged.material.MaterialHelper;

public class ToolPropertyHelper {

    public static int getUses(ItemStack tool) {
        return 1;
    }


    public static float getSpeed(ItemStack tool) {
        return 1.0f;
    }


    public static float getAttackDamageBonus(ItemStack tool) {
        ModMaterials mainMaterial = MaterialHelper.getMainMaterial(tool);
        ModMaterials handleMaterial = MaterialHelper.getHandleMaterial(tool);
        float main = mainMaterial.getAttackDamageBonus();
        float multiplier = handleMaterial.getMultiplier();
        final float propertyValue = main * multiplier;
        return propertyValue;
    }


    public static int getLevel(ItemStack tool) {
        return -1;
    }


    public static int getEnchantmentValue(ItemStack tool) {
        return 0;
    }


    public static Ingredient getRepairIngredient(ItemStack tool) {
        return Ingredient.EMPTY;
    }
}
