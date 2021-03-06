package twilightforest.client.texture.type;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import team.chisel.ctm.api.texture.ICTMTexture;
import team.chisel.ctm.api.texture.TextureType;
import team.chisel.ctm.api.util.TextureInfo;
import team.chisel.ctm.client.model.AbstractCTMBakedModel;
import team.chisel.ctm.client.texture.ctx.TextureContextCTM;
import team.chisel.ctm.client.texture.render.TextureCTM;
import team.chisel.ctm.client.texture.type.TextureTypeCTM;
import team.chisel.ctm.client.util.CTMLogic;
import twilightforest.client.texture.render.CTMLogicSouth;

import javax.annotation.Nonnull;

@TextureType("ctm_tf_south")
public class TextureTypeCTMSouth extends TextureTypeCTM {

	@Override
	public ICTMTexture<? extends TextureTypeCTM> makeTexture(TextureInfo info) {
		return new TextureCTM<TextureTypeCTM>(this, info);
	}

	@Override
	public TextureContextCTM getBlockRenderContext(BlockState state, IBlockAccess world, BlockPos pos, ICTMTexture<?> tex) {
		return new TextureContextCTM(state, world, pos, (TextureCTM<?>) tex) {
			@Override
			protected CTMLogic createCTM(@Nonnull BlockState state) {
				IBakedModel model = Minecraft.getInstance().getBlockRendererDispatcher().getModelForState(state);
				if (model instanceof AbstractCTMBakedModel) {
					return CTMLogicSouth.getInstance().ignoreStates(((AbstractCTMBakedModel) model).getModel().ignoreStates());
				}
				return CTMLogicSouth.getInstance();
			}
		};
	}
}