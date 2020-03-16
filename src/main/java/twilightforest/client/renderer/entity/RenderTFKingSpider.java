package twilightforest.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.util.ResourceLocation;
import twilightforest.TwilightForestMod;
import twilightforest.entity.EntityTFKingSpider;

public class RenderTFKingSpider<T extends EntityTFKingSpider> extends SpiderRenderer<T> {

	private static final ResourceLocation textureLoc = TwilightForestMod.getModelTexture("kingspider.png");

	public RenderTFKingSpider(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	public ResourceLocation getEntityTexture(T entity) {
		return textureLoc;
	}

	@Override
	protected void scale(T entity, MatrixStack stack, float partialTicks) {
		float scale = 1.9F;
		stack.scale(scale, scale, scale);
	}
}
