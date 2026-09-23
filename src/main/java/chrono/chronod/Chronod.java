package chrono.chronod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class Chronod implements ModInitializer {
    public static final String MOD_ID = "chronod";

    public static final Block CHRONO_BLOCK = new Block(AbstractBlock.Settings.create().strength(1,5f));

    @Override
    public void onInitialize() {
        Identifier blockId = Identifier.of(MOD_ID, "chronod_block");

        Registry.register(Registries.BLOCK, blockId, CHRONO_BLOCK);
        Registry.register(Registries.ITEM, blockId, new BlockItem(CHRONO_BLOCK, new Item.Settings()));

    }
    //d
}
