package net.pufferlab.antiquities.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.pufferlab.antiquities.Config;

public class TileEntityGlobe extends TileEntityMetaFacing {

    public float rotation;
    public float speed;

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        this.rotation = tag.getFloat("rotation");
        this.speed = tag.getFloat("speed");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setFloat("rotation", this.rotation);
        tag.setFloat("speed", this.speed);
    }

    public void addSpeed() {
        if (this.speed < Config.globeMaxSpeed) {
            this.speed = this.speed + Config.globeSpeedAddition;
        }
    }

    @Override
    public void updateEntity() {
        if (worldObj.isRemote) {
            if (this.speed > 0) {
                this.speed = this.speed - Config.globeSpeedDeceleration;
            } else {
                this.speed = 0;
            }
            this.rotation = (this.rotation + this.speed) % 360.0F;
        }
    }
}
