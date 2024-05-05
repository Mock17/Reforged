package net.mocko.reforged.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mocko.reforged.Reforged;
import net.mocko.reforged.block.entity.ReforgingStationBlockEntity;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reforged.MOD_ID);

    public static final RegistryObject<BlockEntityType<ReforgingStationBlockEntity>> REFORGING_STATION =
            BLOCK_ENTITIES.register("reforging_station", () ->
                    BlockEntityType.Builder.of(ReforgingStationBlockEntity::new,
                            ModBlocks.REFORGING_STATION_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
