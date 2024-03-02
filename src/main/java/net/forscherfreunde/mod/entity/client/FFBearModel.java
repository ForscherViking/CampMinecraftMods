package net.forscherfreunde.mod.entity.client;

import net.forscherfreunde.mod.entity.custom.FFBearEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FFBearModel<T extends FFBearEntity> extends SinglePartEntityModel<T> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg4;
	private final ModelPart leg3;
	private final ModelPart leg2;
	private final ModelPart leg1;
	public FFBearModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leg4 = root.getChild("leg4");
		this.leg3 = root.getChild("leg3");
		this.leg2 = root.getChild("leg2");
		this.leg1 = root.getChild("leg1");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 39).cuboid(-6.5F, -5.0F, -4.0F, 13.0F, 10.0F, 9.0F, new Dilation(0.0F))
		.uv(51, 0).cuboid(-3.5F, 0.0F, -6.0F, 7.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 5).cuboid(-8.5F, -8.0F, -1.0F, 5.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(3.5F, -8.0F, -1.0F, 5.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 11.5F, -17.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 10.0F, 0.0F));

		ModelPartData rotation = body.addChild("rotation", ModelPartBuilder.create().uv(0, 0).cuboid(-9.5F, -13.0F, -6.5F, 19.0F, 26.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData leg4 = modelPartData.addChild("leg4", ModelPartBuilder.create().uv(62, 48).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(5.5F, 15.0F, -9.0F));

		ModelPartData leg3 = modelPartData.addChild("leg3", ModelPartBuilder.create().uv(0, 58).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.5F, 15.0F, -9.0F));

		ModelPartData leg2 = modelPartData.addChild("leg2", ModelPartBuilder.create().uv(38, 54).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(5.5F, 15.0F, 9.0F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(44, 39).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.5F, 15.0F, 9.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return this.body;
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}