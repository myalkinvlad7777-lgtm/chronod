package chrono.chronod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronod implements ModInitializer {
    public static final String MOD_ID = "chronod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block CHRONO_BLOCK = new Block(AbstractBlock.Settings.create().strength(1, 5f));

    @Override
    public void onInitialize() {
        Identifier blockId = Identifier.of(MOD_ID, "chronod_block");

        Registry.register(Registries.BLOCK, blockId, CHRONO_BLOCK);
        Registry.register(Registries.ITEM, blockId, new BlockItem(CHRONO_BLOCK, new Item.Settings()));

        LOGGER.info("Проект загружен успешно");
    }
}
