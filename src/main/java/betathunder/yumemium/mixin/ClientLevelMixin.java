package betathunder.yumemium.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

@Mixin(ClientLevel.class)
public class ClientLevelMixin {

	@Overwrite
	public Vec3 getSkyColor(Vec3 p_171661_, float p_171662_) {
		return new Vec3(0.5, 0.5, 0.5);
	}
}
