package quantum.ignoreservermods;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(IgnoreServerMods.MODID)
public class IgnoreServerMods
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ignore_server_mods";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public IgnoreServerMods()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
