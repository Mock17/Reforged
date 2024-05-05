package net.mocko.reforged.registry;

import net.minecraft.world.item.crafting.ArmorDyeRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mocko.reforged.Reforged;
import net.mocko.reforged.crafting.ModularToolRecipe;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reforged.MOD_ID);

    public static final RegistryObject<SimpleRecipeSerializer> MODULAR_TOOL_RECIPE
            = SERIALIZERS.register("modular_tool", () -> new SimpleRecipeSerializer<>(ModularToolRecipe::new));

    public static void register(IEventBus eventBus)
    {
        SERIALIZERS.register(eventBus);
    }

}
