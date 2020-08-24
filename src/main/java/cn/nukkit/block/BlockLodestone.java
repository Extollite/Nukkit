package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityLodestone;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemCompassLodestone;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.level.Sound;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.BlockColor;
import cn.nukkit.utils.MainLogger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author joserobjr
 */
@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockLodestone extends BlockSolid implements BlockEntityHolder<BlockEntityLodestone> {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockLodestone() {
        // Does nothing
    }
    
    @Override
    public int getId() {
        return LODESTONE;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public Class<? extends BlockEntityLodestone> getBlockEntityClass() {
        return BlockEntityLodestone.class;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public String getBlockEntityType() {
        return BlockEntity.LODESTONE;
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        return BlockEntityHolder.setBlockAndCreateEntity(this) != null;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (player == null || item.isNull() || item.getId() != ItemID.COMPASS && item.getId() != ItemID.LODESTONE_COMPASS) {
            return false;
        }
        
        boolean decrement = !player.isCreative();
        
        ItemCompassLodestone compass;
        if (item instanceof ItemCompassLodestone) {
            compass = (ItemCompassLodestone) item;
            decrement = false;
        } else {
            compass = (ItemCompassLodestone) Item.get(ItemID.LODESTONE_COMPASS);
        }
        try {
            compass.setTrackingPosition(getLocation());
        } catch (Exception e) {
            MainLogger.getLogger().warning("Could not create a lodestone compass to "+getLocation()+" for "+player.getName(), e);
            return false;
        }
        
        if (decrement) {
            item.count--;
        }
        
        for (Item failed : player.getInventory().addItem(compass)) {
            player.getLevel().dropItem(player.getPosition(), failed);
        }
        
        getLevel().addSound(player.getPosition(), Sound.LODESTONE_COMPASS_LINK_COMPASS_TO_LODESTONE);

        Server.getInstance().getPositionTrackingService().forceRecheck(player);
        
        return true;
    }

    @Override
    public String getName() {
        return "Lodestone";
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 3.5;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new Item[]{ toItem() };
        }
        return new Item[0];
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.IRON_BLOCK_COLOR;
    }

    @Override
    public boolean sticksToPiston() {
        return false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }
}
