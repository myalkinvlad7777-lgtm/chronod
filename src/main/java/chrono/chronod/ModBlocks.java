package chrono.chronod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ColoredFallingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // Хроно-песок: падающий блок с физикой обычного песка.
    // Прочность выше обычного песка (0.5), добывается только алмазной лопатой, слабо светится.
    public static final Block CHRONOD_BLOCK = Registry.register(
            Registries.BLOCK,
            Identifier.of(Chronod.MOD_ID, "chronod_block"),
            new ColoredFallingBlock(new ColorCode(0x8E6FC9),
                    AbstractBlock.Settings.copy(Blocks.SAND)
                            .strength(3.0f, 6.0f)
                            .luminance(state -> 8)
                            .requiresTool()));

    public static final Item CHRONOD_BLOCK_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of(Chronod.MOD_ID, "chronod_block"),
            new BlockItem(CHRONOD_BLOCK, new Item.Settings()));

    public static void initialize() {
    }
}
