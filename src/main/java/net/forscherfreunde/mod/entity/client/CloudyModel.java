package net.forscherfreunde.mod.entity.client;

import net.forscherfreunde.mod.entity.custom.CloudyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class CloudyModel<T extends CloudyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart koerper;
	private final ModelPart head;
	public CloudyModel(ModelPart root) {
		this.koerper = root.getChild("koerper");
		this.head = root.getChild("koerper").getChild("kopf");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData koerper = modelPartData.addChild("koerper", ModelPartBuilder.create().uv(0, 22).cuboid(-3.0F, -10.0F, -2.0F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -13.0F, -4.0F, 9.0F, 3.0F, 9.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-4.0F, -3.0F, -3.0F, 7.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData kopf = koerper.addChild("kopf", ModelPartBuilder.create().uv(20, 22).cuboid(-3.0F, -17.0F, 0.0F, 5.0F, 4.0F, 4.0F, new Dilation(0.0F))
		.uv(21, 12).cuboid(-2.0F, -15.0F, -2.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 22).cuboid(0.0F, -17.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(5, 0).cuboid(-2.0F, -17.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rechterarm = koerper.addChild("rechterarm", ModelPartBuilder.create().uv(27, 0).cuboid(-4.0F, -10.0F, -1.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(21, 16).cuboid(-7.0F, -9.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 15).cuboid(-7.0F, -8.0F, 0.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rechterarm2 = koerper.addChild("rechterarm2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -1.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 6).cuboid(-7.0F, -9.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-7.0F, -8.0F, 0.0F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 1.0F, 0.0F, 3.1416F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		koerper.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return koerper;
	}

	@Override
	public void setAngles(CloudyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
}