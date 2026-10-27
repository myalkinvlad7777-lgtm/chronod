package chrono.chronod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemGroups;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronod implements ModInitializer {
    public static final String MOD_ID = "chronod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> entries.add(ModBlocks.CHRONOD_BLOCK_ITEM));

        // Хроно-песок показывает игроку время суток, если по нему кликнуть пустой рукой
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            BlockState state = world.getBlockState(hitResult.getBlockPos());
            if (!state.isOf(ModBlocks.CHRONOD_BLOCK) || hand != Hand.MAIN_HAND
                    || !player.getStackInHand(hand).isEmpty()) {
                return ActionResult.PASS;
            }
            if (!world.isClient()) {
                long time = world.getTimeOfDay() % 24000;
                String part = time < 12000 ? "день" : "ночь";
                player.sendMessage(Text.literal("Хроно-песок: время мира " + time + " (" + part + ")"), false);
            }
            return ActionResult.SUCCESS;
        });

        LOGGER.info("Проект загружен успешно");
    }
}
