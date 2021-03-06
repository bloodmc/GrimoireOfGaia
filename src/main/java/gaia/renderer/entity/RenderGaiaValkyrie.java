package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaValkyrie;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderGaiaValkyrie extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Valkyrie.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaValkyrie(float shadowSize) {
        super(rend, new ModelGaiaValkyrie(), shadowSize);
        this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaValkyrie.rightarm));
        this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaValkyrie.leftarm));
	}

	public void transformHeldFull3DItemLayer() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
