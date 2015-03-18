package org.mcrest;

import com.sun.javafx.binding.Logging;
import org.mcrest.entity.Player;
import org.mcrest.entity.ServerStatus;
import org.mcrest.entity.World;
import org.mcrest.server.IServer;

import java.util.Collection;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class StubMCServer implements IServer {

    @Override
    public ServerStatus getServerStatus() {
        ServerStatus ss = new ServerStatus();
        ss.setName("MCStub");
        return ss;
    }

    @Override
    public Collection<? extends Player> getPlayers() {
        return null;
    }

    @Override
    public Collection<? extends World> getWorlds() {
        return null;
    }

    @Override
    public Collection<? extends Player> getOnlinePlayers() {
        return null;
    }

    @Override
    public Collection<? extends Player> getOfflinePlayers() {
        return null;
    }

    @Override
    public Player getPlayer(String playerName) {
        return null;
    }

    @Override
    public Logger getLogger() {
        Logger log = Logger.getLogger("UT");
        log.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        log.addHandler(handler);
        return log;
    }
}
