package net.mocko.reforged.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mocko.reforged.Reforged;
import net.mocko.reforged.tools.item.ModularSwordItem;
import net.mocko.reforged.tools.item.ToolHandleItem;
import net.mocko.reforged.tools.item.ToolPartItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reforged.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<ToolPartItem> SWORD_HEAD = ITEMS.register( "sword_head",
            ()-> new ToolPartItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ToolHandleItem> HANDLE = ITEMS.register( "handle",
            ()-> new ToolHandleItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<ModularSwordItem> SWORD = ITEMS.register("sword",
            () -> new ModularSwordItem((new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT).stacksTo(1)));

}
