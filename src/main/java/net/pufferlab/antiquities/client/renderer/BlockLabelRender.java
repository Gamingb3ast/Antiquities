package net.pufferlab.antiquities.client.renderer;

import net.pufferlab.antiquities.client.models.ModelFurniture;
import net.pufferlab.antiquities.client.models.ModelLabel;

public class BlockLabelRender extends BlockFurnitureRender {

    ModelLabel model = new ModelLabel();

    public BlockLabelRender(int blockComplexRenderID) {
        super(blockComplexRenderID);
    }

    @Override
    public ModelFurniture[] getModelObj() {
        return new ModelLabel[] { model };
    }

    @Override
    public boolean hasBigInventoryModel() {
        return true;
    }

    @Override
    public float getOffsetX() {
        return 0.25F;
    }

    @Override
    public float getOffsetY() {
        return 0.25F;
    }

}
