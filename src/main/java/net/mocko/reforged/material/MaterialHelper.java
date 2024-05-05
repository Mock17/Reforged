package net.mocko.reforged.material;

import com.google.common.collect.ImmutableMultimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.mocko.reforged.attribute.ToolAttributes;
import net.mocko.reforged.material.ModMaterials;
import net.mocko.reforged.tools.item.ToolHandleItem;
import net.mocko.reforged.tools.item.ToolPartItem;
import net.mocko.reforged.tools.nbt.ToolNBTHelper;

import java.util.Locale;

public class MaterialHelper {

    public static ModMaterials getMainMaterial(ItemStack stack)
    {
        CompoundTag compoundTag = stack.getOrCreateTag();
        return ToolNBTHelper.getMainMaterialFromNBT(compoundTag);
    }

    public static ModMaterials getHandleMaterial(ItemStack stack)
    {
        CompoundTag compoundTag = stack.getOrCreateTag();
        return ToolNBTHelper.getHandleMaterialFromNBT(compoundTag);
    }

    public static ItemStack setMaterialsFromParts(ItemStack tool, ItemStack mainPartStack, ItemStack handleStack)
    {
        ModMaterials mainMaterial = ModMaterials.DEFAULT;
        ModMaterials handleMaterial = ModMaterials.DEFAULT;
        CompoundTag materialTag = mainPartStack.getOrCreateTag();

        if(materialTag != null && materialTag.contains("reforged.material"))
        {
            CompoundTag mainMaterialTag = tool.getOrCreateTag();
            mainMaterialTag.putString("reforged.main_material", materialTag.getString("reforged.material"));
            mainMaterial = ModMaterials.valueOf(materialTag.getString("reforged.material").toUpperCase(Locale.ROOT));
            tool.setTag(mainMaterialTag);
        }

        materialTag = handleStack.getOrCreateTag();
        if(materialTag != null && materialTag.contains("reforged.material"))
        {
            CompoundTag handleMaterialTag = tool.getOrCreateTag();
            handleMaterialTag.putString("reforged.handle_material", materialTag.getString("reforged.material"));
            handleMaterial = ModMaterials.valueOf(materialTag.getString("reforged.material").toUpperCase(Locale.ROOT));
            tool.setTag(handleMaterialTag);
        }



        tool.addAttributeModifier(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(ToolAttributes.DYNAMIC_SPEED_MODIFIER,
                        "Weapon Modifier",
                        mainMaterial.getAttackDamageBonus()*handleMaterial.getMultiplier(),
                        AttributeModifier.Operation.ADDITION),
                EquipmentSlot.MAINHAND);


        return tool;
    }



}
