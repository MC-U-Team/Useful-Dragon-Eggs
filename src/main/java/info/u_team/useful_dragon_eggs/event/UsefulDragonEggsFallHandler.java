package info.u_team.useful_dragon_eggs.event;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class UsefulDragonEggsFallHandler {
	
	private static void onEntityJoinWorld(EntityJoinWorldEvent event) {
	}
	
	public static void registerForge(IEventBus bus) {
		bus.addListener(UsefulDragonEggsFallHandler::onEntityJoinWorld);
	}
	
}
