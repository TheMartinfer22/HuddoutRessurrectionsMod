package dev.nanosync.huddoutressurrections.mixin;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraftforge.fml.client.ClientHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = ClientHooks.class, remap = false)
public class ForgeIncompatibleVersionMixin  {
    /**
     * @author focamacho - MyServerIsCompatible
     */
    @Overwrite
    public static void drawForgePingInfo(MultiplayerScreen gui, ServerData target, MatrixStack mStack, int x, int y, int width, int relativeMouseX, int relativeMouseY) {}
}
