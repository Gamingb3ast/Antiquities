package net.pufferlab.antiquities;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.pufferlab.antiquities.blocks.*;
import net.pufferlab.antiquities.entity.EntitySeat;
import net.pufferlab.antiquities.itemblocks.ItemBlockMeta;
import net.pufferlab.antiquities.tileentities.*;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {

    public static Block chair;
    public static Block table;
    public static Block shelf_0;
    public static Block shelf_1;
    public static Block shelf_2;
    public static Block shelf_3;
    public static Block shelf_4;
    public static Block shelf_5;
    public static Block jar;
    public static Block rack;
    public static Block chair_bop;
    public static Block table_bop;
    public static Block shelf_0_bop;
    public static Block shelf_1_bop;
    public static Block shelf_2_bop;
    public static Block shelf_3_bop;
    public static Block shelf_4_bop;
    public static Block shelf_5_bop;
    public static Block jar_bop;
    public static Block rack_bop;

    public static Block chair_tc;
    public static Block table_tc;
    public static Block shelf_0_tc;
    public static Block shelf_1_tc;
    public static Block shelf_2_tc;
    public static Block shelf_3_tc;
    public static Block shelf_4_tc;
    public static Block shelf_5_tc;
    public static Block jar_tc;
    public static Block rack_tc;

    public static Block pedestal;
    public static Block globe;
    public static Block clock;
    public static Block pile;

    public void preInit(FMLPreInitializationEvent event) {
        chair = new BlockChair(Constants.woodTypes);
        table = new BlockTable(Constants.woodTypes);
        shelf_0 = new BlockShelf(0, Constants.woodTypes);
        shelf_1 = new BlockShelf(1, Constants.woodTypes);
        shelf_2 = new BlockShelf(2, Constants.woodTypes);
        shelf_3 = new BlockShelf(3, Constants.woodTypes);
        shelf_4 = new BlockShelf(4, Constants.woodTypes);
        shelf_5 = new BlockShelf(5, Constants.woodTypes);
        jar = new BlockJar(Constants.woodTypes);
        rack = new BlockRack(Constants.woodTypes);

        if (Loader.isModLoaded("BiomesOPlenty")) {
            chair_bop = new BlockChair(Constants.bopWoodTypes);
            table_bop = new BlockTable(Constants.bopWoodTypes);
            shelf_0_bop = new BlockShelf(0, Constants.bopWoodTypes);
            shelf_1_bop = new BlockShelf(1, Constants.bopWoodTypes);
            shelf_2_bop = new BlockShelf(2, Constants.bopWoodTypes);
            shelf_3_bop = new BlockShelf(3, Constants.bopWoodTypes);
            shelf_4_bop = new BlockShelf(4, Constants.bopWoodTypes);
            shelf_5_bop = new BlockShelf(5, Constants.bopWoodTypes);
            jar_bop = new BlockJar(Constants.bopWoodTypes);
            rack_bop = new BlockRack(Constants.bopWoodTypes);
        }
        if (Loader.isModLoaded("Thaumcraft")) {
            chair_tc = new BlockChair(Constants.thaumcraftWoodTypes);
            table_tc = new BlockTable(Constants.thaumcraftWoodTypes);
            shelf_0_tc = new BlockShelf(0, Constants.thaumcraftWoodTypes);
            shelf_1_tc = new BlockShelf(1, Constants.thaumcraftWoodTypes);
            shelf_2_tc = new BlockShelf(2, Constants.thaumcraftWoodTypes);
            shelf_3_tc = new BlockShelf(3, Constants.thaumcraftWoodTypes);
            shelf_4_tc = new BlockShelf(4, Constants.thaumcraftWoodTypes);
            shelf_5_tc = new BlockShelf(5, Constants.thaumcraftWoodTypes);
            jar_tc = new BlockJar(Constants.thaumcraftWoodTypes);
            rack_tc = new BlockRack(Constants.thaumcraftWoodTypes);
        }
        pedestal = new BlockPedestal(Constants.stoneTypes);
        globe = new BlockGlobe();
        clock = new BlockClock();
        pile = new BlockPile();
        register(TileEntityChair.class, "chair");
        register(TileEntityTable.class, "table");
        register(TileEntityShelf.class, "shelf");
        register(TileEntityJar.class, "jar");
        register(TileEntityRack.class, "rack");
        register(TileEntityPedestal.class, "pedestal");
        register(TileEntityGlobe.class, "globe");
        register(TileEntityClock.class, "clock");
        register(TileEntityPile.class, "pile");

        register(chair, "chair");
        register(shelf_0, "shelf");
        register(shelf_1, "shelf_1");
        register(shelf_2, "shelf_2");
        register(shelf_3, "shelf_3");
        register(shelf_4, "shelf_4");
        register(shelf_5, "shelf_5");
        register(table, "table");
        register(jar, "jar");
        register(rack, "rack");

        if (Loader.isModLoaded("BiomesOPlenty")) {
            register(chair_bop, "chair_bop");
            register(shelf_0_bop, "shelf_bop");
            register(shelf_1_bop, "shelf_bop_1");
            register(shelf_2_bop, "shelf_bop_2");
            register(shelf_3_bop, "shelf_bop_3");
            register(shelf_4_bop, "shelf_bop_4");
            register(shelf_5_bop, "shelf_bop_5");
            register(table_bop, "table_bop");
            register(jar_bop, "jar_bop");
            register(rack_bop, "rack_bop");
        }

        if (Loader.isModLoaded("Thaumcraft")) {
            register(chair_tc, "chair_tc");
            register(shelf_0_tc, "shelf_tc");
            register(shelf_1_tc, "shelf_tc_1");
            register(shelf_2_tc, "shelf_tc_2");
            register(shelf_3_tc, "shelf_tc_3");
            register(shelf_4_tc, "shelf_tc_4");
            register(shelf_5_tc, "shelf_tc_5");
            register(table_tc, "table_tc");
            register(jar_tc, "jar_tc");
            register(rack_tc, "rack_tc");
        }

        register(pedestal, "pedestal");
        register(globe, "globe");
        register(clock, "clock");
        register(pile, "pile");
    }

    public void init() {
        int id = 0;
        EntityRegistry
            .registerModEntity(EntitySeat.class, "EntitySeatAntiquities", id++, Antiquities.instance, 64, 20, true);
    }

    public void register(Class<? extends TileEntity> tileEntityClass, String id) {
        GameRegistry.registerTileEntity(tileEntityClass, Antiquities.MODID + "_" + id);
    }

    public void register(Block block, String name) {

        if (block instanceof BlockMetaContainer) {
            GameRegistry.registerBlock(block, ItemBlockMeta.class, name);
        } else {
            if (block instanceof BlockPile) {
                GameRegistry.registerBlock(block, null, name);
            } else {
                GameRegistry.registerBlock(block, name);
            }
        }
    }
}
