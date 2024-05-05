package net.mocko.reforged.crafting;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.mocko.reforged.tools.item.ToolHandleItem;
import net.mocko.reforged.tools.item.ToolPartItem;
import net.mocko.reforged.registry.ModItems;
import net.mocko.reforged.material.MaterialHelper;

public class ModularToolRecipe extends CustomRecipe {

    public static final SimpleRecipeSerializer<?> SERIALIZER = new SimpleRecipeSerializer<>(ModularToolRecipe::new);

    public ModularToolRecipe(ResourceLocation id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingContainer container, Level level) {

        if (level.isClientSide()){
            return false;
        }

        ItemStack mainPartStack = ItemStack.EMPTY;
        ItemStack handleStack = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack input = container.getItem(i);
            if(!input.isEmpty()){
                if(input.getItem() instanceof ToolPartItem) {
                    if(!mainPartStack.isEmpty())
                    {
                        return false;
                    }
                    mainPartStack = input;
                }
                else if(input.getItem() instanceof ToolHandleItem){
                    if(!handleStack.isEmpty())
                    {
                        return false;
                    }
                    handleStack = input;
                }
            }
        }
        return !mainPartStack.isEmpty() && !handleStack.isEmpty();

    }

    @Override
    public ItemStack assemble(CraftingContainer container) {
        ItemStack sword = new ItemStack(ModItems.SWORD.get());
        ItemStack mainPartStack = ItemStack.EMPTY;
        ItemStack handleStack = ItemStack.EMPTY;

        for(int i = 0; i < container.getContainerSize(); ++i)
        {
            ItemStack input = container.getItem(i);
            if(!input.isEmpty()){
                if(mainPartStack.isEmpty() && input.getItem() instanceof ToolPartItem) {
                    if(!mainPartStack.isEmpty())
                    {
                        return ItemStack.EMPTY;
                    }

                    mainPartStack = input.copy();
                }
                else if (handleStack.isEmpty() && input.getItem() instanceof ToolHandleItem){
                    if(!handleStack.isEmpty())
                    {
                        return ItemStack.EMPTY;
                    }
                    handleStack = input.copy();
                }
            }
        }
        return !mainPartStack.isEmpty() && !handleStack.isEmpty() ? MaterialHelper.setMaterialsFromParts(sword,mainPartStack,handleStack) : ItemStack.EMPTY;

    }


    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public ItemStack getResultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }


}