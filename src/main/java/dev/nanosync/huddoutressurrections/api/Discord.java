package dev.nanosync.huddoutressurrections.api;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Discord {
    public Discord(String appid) throws IOException {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        DiscordRPC lib = DiscordRPC.INSTANCE;

        lib.Discord_Initialize(appid, handlers, true, "");
        lib.Discord_UpdatePresence(setDiscordConfigurations());

        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                lib.Discord_RunCallbacks();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored) {}
            }
        }, "RPC-Callback-Handler").start();
    }

    private DiscordRichPresence setDiscordConfigurations() throws IOException, FileNotFoundException {
        DiscordRichPresence presence = new DiscordRichPresence();
        presence.startTimestamp = System.currentTimeMillis() / 1000;
        presence.largeImageKey = "huddout";
        presence.largeImageText = "https://nanosync.dev/huddoutdiscord";
        presence.smallImageKey = "";
        presence.smallImageText = "";
        presence.details = "|> \uD835\uDDA4\uD835\uDDC7\uD835\uDDCD\uD835\uDDCB\uD835\uDDBE \uD835\uDDBE\uD835\uDDC6 \uD835\uDDC7\uD835\uDDC8\uD835\uDDCC\uD835\uDDCC\uD835\uDDC8 \uD835\uDDCC\uD835\uDDBE\uD835\uDDCB\uD835\uDDCF\uD835\uDDC2\uD835\uDDBD\uD835\uDDC8\uD835\uDDCB, \uD835\uDDC1\uD835\uDDCD\uD835\uDDCD\uD835\uDDC9\uD835\uDDCC://\uD835\uDDC7\uD835\uDDBA\uD835\uDDC7\uD835\uDDC8\uD835\uDDCC\uD835\uDDD2\uD835\uDDC7\uD835\uDDBC.\uD835\uDDBD\uD835\uDDBE\uD835\uDDCF/\uD835\uDDC1\uD835\uDDCE\uD835\uDDBD\uD835\uDDBD\uD835\uDDC8\uD835\uDDCE\uD835\uDDCD\uD835\uDDBD\uD835\uDDC2\uD835\uDDCC\uD835\uDDBC\uD835\uDDC8\uD835\uDDCB\uD835\uDDBD";
        presence.state = "|> \uD835\uDC12\uD835\uDC1E\uD835\uDC2B\uD835\uDC2F\uD835\uDC22\uD835\uDC1D\uD835\uDC28\uD835\uDC2B \uD835\uDC1F\uD835\uDC1E\uD835\uDC22\uD835\uDC2D\uD835\uDC28 \uD835\uDC1C\uD835\uDC28\uD835\uDC26 \uD835\uDC1A\uD835\uDC26\uD835\uDC28\uD835\uDC2B \uD835\uDC29\uD835\uDC1E\uD835\uDC25\uD835\uDC1A \uD835\uDC0D\uD835\uDC1A\uD835\uDC27\uD835\uDC28\uD835\uDC12\uD835\uDC32\uD835\uDC27\uD835\uDC1C";
        return presence;
    }
}
