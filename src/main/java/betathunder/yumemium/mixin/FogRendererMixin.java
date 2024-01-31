package betathunder.yumemium.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;

@Mixin(FogRenderer.class)
public class FogRendererMixin {

	@Overwrite
	public static void setupColor(Camera p_109019_, float p_109020_, ClientLevel p_109021_, int p_109022_,
			float p_109023_) {
	}
}
