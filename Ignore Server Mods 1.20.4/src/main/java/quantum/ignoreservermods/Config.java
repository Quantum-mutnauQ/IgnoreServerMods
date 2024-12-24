package quantum.ignoreservermods;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@Mod.EventBusSubscriber(modid = IgnoreServerMods.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue IgnoreVanillaServer = BUILDER
            .comment("Ignores if ter server has no NeoForge")
            .define("IgnoreVanillaServer", true);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean IgnoreVanillaServerValue=true;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        IgnoreVanillaServerValue=IgnoreVanillaServer.get();
    }
}
