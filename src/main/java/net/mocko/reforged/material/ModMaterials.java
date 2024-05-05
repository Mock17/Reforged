package net.mocko.reforged.material;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModMaterials implements Tier {

    DEFAULT(1,1, 1, 1, 1,1, 1, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Default", 0x000000),
    IRON(2,2, 250, 6.0F, 2,2.0F, 14,BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Iron",0xeae5e5),
    GOLD(3,2, 100, 6.0F, 2,2.0F, 14,BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Gold",0xffb90f),
    COPPER(4,2, 260, 6.0F, 2,2.0F, 14,BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Copper",0xb87333),
    NETHERITE(5,2, 1200, 6.0F, 2,2.0F, 14,BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Netherite",0x43363d),
    ENDERITE(6,2, 1500, 6.0F, 2,2.0F, 14,BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Enderite",0x134f5c),
    STEEL(7,2, 400, 6.0F, 4,2.0F, 14,BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT), "Steel",0x666666);


    private final String name;
    private final int color;
    private final float multiplier;
    private final int ID;
    private final int level;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    @NotNull
    private final TagKey<Block> tag;
    @NotNull
    private final Supplier<Ingredient> repairIngredient;

    ModMaterials(int ID, int level, int uses, float speed, float multiplier, float attackDamageBonus, int enchantmentValue,
                   @NotNull TagKey<Block> tag, @NotNull Supplier<Ingredient> repairIngredient, String name, int color)
    {
        this.ID = ID;
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.multiplier = multiplier;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.tag = tag;
        this.repairIngredient = repairIngredient;
        this.name = name;
        this.color = color;
    }

    public String getName()
    {
        return this.name;
    }

    public int getID(){
        return this.ID;
    }


    @Override
    public int getUses() {
        return this.uses;
    }


    @Override
    public float getSpeed()
    {
        return this.speed;
    }

    public float getMultiplier(){
        return this.multiplier;
    }

    @Override
    public float getAttackDamageBonus()
    {
        return this.attackDamageBonus;
    }

    @Override
    public int getLevel()
    {
        return this.level;
    }

    @Override
    public int getEnchantmentValue()
    {
        return this.enchantmentValue;
    }

    @NotNull
    public TagKey<Block> getTag()
    {
        return this.tag;
    }

    @NotNull
    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairIngredient.get();
    }

    @Override
    public String toString()
    {
        return "ForgeTier[" +
                "level=" + level + ", " +
                "uses=" + uses + ", " +
                "speed=" + speed + ", " +
                "attackDamageBonus=" + attackDamageBonus + ", " +
                "enchantmentValue=" + enchantmentValue + ", " +
                "tag=" + tag + ", " +
                "repairIngredient=" + repairIngredient + ']';
    }

    public int getColor() {
        return color;
    }

    /*
    public static ModMaterials fromNBT(CompoundTag compoundTag, String tagName){
        ModMaterials material = ModMaterials.DEFAULT; //DEFAULT IN CASE OF ERROR
        if(compoundTag != null && compoundTag.contains(tagName)){
                material = ModMaterials.valueOf(tagName);
        }
        return material;
    }
    */




}
