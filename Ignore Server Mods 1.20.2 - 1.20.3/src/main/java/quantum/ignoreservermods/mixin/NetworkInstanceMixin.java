package quantum.ignoreservermods.mixin;

import net.neoforged.neoforge.network.NetworkInstance;
import net.neoforged.neoforge.network.NetworkRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import quantum.ignoreservermods.Config;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

@Mixin(NetworkRegistry.class)
public class NetworkInstanceMixin {

    @Inject(method = "listRejectedVanillaMods",at = @At(value = "HEAD"))
    private static void fix(BiFunction<NetworkInstance, String, Boolean> testFunction, CallbackInfoReturnable<List<String>> cir){
        if (Config.IgnoreVanillaServerValue)
            cir.setReturnValue(Collections.emptyList());
    }
}
