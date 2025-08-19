package net.pufferlab.antiquities.client.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.pufferlab.antiquities.blocks.BlockShelf;
import net.pufferlab.antiquities.client.models.ModelShelf;
import net.pufferlab.antiquities.client.models.ModelShelfFull;
import net.pufferlab.antiquities.client.models.ModelShelfLong;
import net.pufferlab.antiquities.tileentities.TileEntityShelf;

import org.lwjgl.opengl.GL11;

public class TileEntityShelfRenderer extends TileEntitySpecialRenderer {

    ModelShelfFull model0 = new ModelShelfFull();
    ModelShelf model1 = new ModelShelf();
    ModelShelfLong model2 = new ModelShelfLong();
    private RenderManager renderManager = RenderManager.instance;
    private RenderItem itemRenderer = new RenderItem() {

        public byte getMiniBlockCount(ItemStack stack, byte original) {
            return 1;
        }

        public boolean shouldBob() {
            return false;
        }

        public boolean shouldSpreadItems() {
            return false;
        }
    };

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks) {
        World world = tileEntity.getWorldObj();
        TileEntityShelf shelf = (TileEntityShelf) tileEntity;
        Block block = world.getBlock(shelf.xCoord, shelf.yCoord, shelf.zCoord);
        if (!(block instanceof BlockShelf)) return;
        BlockShelf block2 = (BlockShelf) block;
        int metadata = world.getBlockMetadata(shelf.xCoord, shelf.yCoord, shelf.zCoord);
        String wood = block2.getType(metadata);

        this.itemRenderer.setRenderManager(renderManager);

        model0.setFacing(shelf.facingMeta);
        model1.setFacing(shelf.facingMeta);
        model2.setFacing(shelf.facingMeta);

        GL11.glEnable(GL11.GL_LIGHTING);
        ItemStack slot1 = shelf.getInventoryStack(0);
        ItemStack slot2 = shelf.getInventoryStack(1);
        ItemStack slot3 = shelf.getInventoryStack(2);
        ItemStack slot4 = shelf.getInventoryStack(3);

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
        if (block2.getShelfType() == 0) {
            model0.render(wood);
        } else if (block2.getShelfType() == 1) {
            model1.render(wood);
        } else if (block2.getShelfType() == 2) {
            model2.render(wood);
        }
        GL11.glPopMatrix();
        double x2 = x + 0.25F;
        double y2 = y + 0.15F;
        double z2 = z + 0.75F;
        double offsetX = 0.5F;
        double offsetY = 0.5F;
        double offsetZ = 0.0F;
        if (shelf.facingMeta == 2) {
            x2 = x + 0.75F;
            offsetX = 0.0F;
            offsetZ = -0.5F;
        }
        if (shelf.facingMeta == 3) {
            x2 = x + 0.75F;
            z2 = z + 0.25F;
            offsetX = -0.5F;
        }
        if (shelf.facingMeta == 4) {
            x2 = x + 0.25F;
            z2 = z + 0.25F;
            offsetX = 0.0F;
            offsetZ = 0.5F;
        }
        renderSlotItem(slot4, x2, y2, z2, shelf.facingMeta);
        renderSlotItem(slot3, x2 + offsetX, y2, z2 + offsetZ, shelf.facingMeta);
        renderSlotItem(slot1, x2 + offsetX, y2 + offsetY, z2 + offsetZ, shelf.facingMeta);
        renderSlotItem(slot2, x2, y2 + offsetY, z2, shelf.facingMeta);
    }

    public void renderSlotItem(ItemStack stack, double xAdjust, double yAdjust, double zAdjust, int facing) {
        GL11.glPushMatrix();
        if (stack != null) {
            EntityItem slotEntity = new EntityItem(null, 0.0D, 0.0D, 0.0D, stack);
            slotEntity.hoverStart = 0.0F;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslated(xAdjust, yAdjust, zAdjust);
            if (stack.getItem() != null) {
                GL11.glScalef(0.8F, 0.8F, 0.8F);
            }
            setFacing(facing);
            RenderItem.renderInFrame = true;
            this.itemRenderer.doRender(slotEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            RenderItem.renderInFrame = false;
        }
        GL11.glPopMatrix();
    }

    public void setFacing(int meta) {
        int meta2 = meta + 1;
        GL11.glRotatef(90 * meta2, 0, 1.0F, 0.0F);
    }

}
