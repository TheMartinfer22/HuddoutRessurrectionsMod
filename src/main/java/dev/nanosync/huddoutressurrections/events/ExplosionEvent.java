package dev.nanosync.huddoutressurrections.events;


import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ExplosionEvent {
    @SubscribeEvent
    public void onExplosion(net.minecraftforge.event.world.ExplosionEvent event){
        event.getExplosion().clearAffectedBlockPositions();
    }
}
