package dev.nanosync.huddoutressurrections.mixin;

import net.minecraft.client.MainWindow;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

//@Mixin(MainWindow.class)
public class FrameBufferOptifineMixin {
//    @Redirect(method = "updateFramebufferSize", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwGetFramebufferSize(J[I[I)V"))
//    public void fix(long handle, int[] width, int[] height) {
//        if (!Boolean.parseBoolean(System.getProperty("dev.nanosync.huddoutressurrections.fix", "true"))) {
//            GLFW.glfwGetFramebufferSize(handle, width, height);
//            return;
//        }
//
//        boolean isIconified = GLFW.glfwGetWindowAttrib(handle, GLFW.GLFW_ICONIFIED) == GLFW.GLFW_TRUE;
//        if (isIconified) GLFW.glfwRestoreWindow(handle);
//        GLFW.glfwGetFramebufferSize(handle, width, height);
//        if (isIconified) GLFW.glfwIconifyWindow(handle);
//    }
}
