package betathunder.dreamium.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.particle.Particle;

@Mixin(Particle.class)
public class ParticleMixin {

	@Overwrite
	protected int getLightColor(float p_107249_) {
		return 0;
	}

}
