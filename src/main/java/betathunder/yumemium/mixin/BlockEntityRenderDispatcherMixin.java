package betathunder.yumemium.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import com.mojang.blaze3d.vertex.PoseStack;

import betathunder.yumemium.Config;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;

@Mixin(BlockEntityRenderDispatcher.class)
public class BlockEntityRenderDispatcherMixin {

	private final static Minecraft INSTANCE = Minecraft.getInstance();

	@Overwrite
	private static <T extends BlockEntity> void setupAndRender(BlockEntityRenderer<T> blockEntRend, T blockEntity,
			float p_112287_, PoseStack pose, MultiBufferSource buffSrc) {
		BlockPos blockPos = blockEntity.getBlockPos();
		double dist = INSTANCE.gameRenderer.getMainCamera().getPosition().distanceToSqr(blockPos.getCenter());

		int c = 15728880;
		/*
		 * Level level = blockEntity.getLevel(); if (level != null) { c =
		 * LevelRenderer.getLightColor(level, blockPos); } else { c = 15728880; }
		 */

		if (dist < Config.blockEntityDistance) {
			blockEntRend.render(blockEntity, p_112287_, pose, buffSrc, c, OverlayTexture.NO_OVERLAY);
			return;
		}

		BlockRenderDispatcher blockRendDisp = INSTANCE.getBlockRenderer();

		/*
		 * switch (blockState.getRenderShape()) { // put something to represent
		 * invisible blockentities case INVISIBLE: blockState =
		 * Blocks.STONE.defaultBlockState(); break; case MODEL: case
		 * ENTITYBLOCK_ANIMATED: default: break; }
		 */

		if (dist < Config.blockIndicatorDistance) {
			blockRendDisp.renderSingleBlock(Blocks.GLASS.defaultBlockState(), pose, buffSrc, 0, 0,
					net.minecraftforge.client.model.data.ModelData.EMPTY, null);
		}
	}
}
