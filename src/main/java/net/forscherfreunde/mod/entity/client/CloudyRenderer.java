package net.forscherfreunde.mod.entity.client;

import net.forscherfreunde.mod.TestMod;
import net.forscherfreunde.mod.entity.custom.CloudyEntity;
import net.forscherfreunde.mod.entity.custom.PorcupineEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CloudyRenderer extends MobEntityRenderer<CloudyEntity, CloudyModel<CloudyEntity>> {

    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID, "textures/entity/cloudy.png");
    public CloudyRenderer(EntityRendererFactory.Context context) {
        super(context, new CloudyModel<>(context.getPart(ModModelLayers.EntityModels.get("cloudy_model"))), 0.6f);
    }

    @Override
    public Identifier getTexture(CloudyEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CloudyEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {

        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
