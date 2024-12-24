package quantum.ignoreservermods.mixin;

import net.neoforged.neoforge.network.negotiation.NegotiationResult;
import net.neoforged.neoforge.network.registration.NetworkRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import quantum.ignoreservermods.Config;

@Mixin(NetworkRegistry.class)
public class NetworkInstanceMixin {

    @Redirect(method = "onVanillaNetworkConnectionEstablished",at = @At(value = "INVOKE", target = "Lnet/neoforged/neoforge/network/negotiation/NegotiationResult;success()Z"))
    private boolean fix(NegotiationResult instance){
        return Config.IgnoreVanillaServerValue || instance.success();
    }
}