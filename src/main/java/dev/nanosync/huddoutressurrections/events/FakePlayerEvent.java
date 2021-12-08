package dev.nanosync.huddoutressurrections.events;

import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FakePlayerEvent {
    @SubscribeEvent
    public void onBlockPlacer(BlockEvent.EntityPlaceEvent event){
        if (!event.getWorld().isRemote()) return;
        if (event.getEntity() instanceof FakePlayer) {
            event.setCanceled(false);
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event){
        if (!event.getWorld().isRemote()) return;
        if (event.getPlayer() instanceof FakePlayer){
            event.setCanceled(false);
        }
    }
}
