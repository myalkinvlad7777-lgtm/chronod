package chrono.chronod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chronod implements ModInitializer {
    public static final String MOD_ID = "chronod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        LOGGER.info("Проект загружен успешно");
    }
}
