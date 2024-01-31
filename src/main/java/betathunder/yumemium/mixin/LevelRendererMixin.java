package betathunder.yumemium.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

	@Overwrite
	public static int getLightColor(BlockAndTintGetter p_109542_, BlockPos p_109543_) {
		return 0;
	}
}
