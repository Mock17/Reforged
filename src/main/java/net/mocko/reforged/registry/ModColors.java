package net.mocko.reforged.registry;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.mocko.reforged.Reforged;
import net.mocko.reforged.client.ColorHandler;
import net.mocko.reforged.tools.item.ModularSwordItem;

@Mod.EventBusSubscriber(modid = Reforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModColors {

    @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tintIndex) -> ColorHandler.getColor(stack), ModItems.SWORD_HEAD.get(),ModItems.HANDLE.get());
        event.register(ModularSwordItem::getColor, ModItems.SWORD.get());
        }
}

