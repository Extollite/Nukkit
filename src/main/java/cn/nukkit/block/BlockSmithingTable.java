package cn.nukkit.block;

import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

public class BlockSmithingTable extends BlockSolid {

    public BlockSmithingTable() {
    }

    @Override
    public int getId() {
        return SMITHING_TABLE;
    }

    @Override
    public String getName() {
        return "Smithing Table";
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public double getResistance() {
        return 12.5;
    }

    @Override
    public double getHardness() {
        return 2.5;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WOOD_BLOCK_COLOR;
    }

    @Override
    public int getBurnChance() {
        return 5;
    }

    @Override
    public boolean canHarvestWithHand() {
        return true;
    }
}