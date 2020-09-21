package info.u_team.useful_dragon_eggs.init;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class UsefulDragonEggsCommands {
	
	private static void onRegisterCommands(RegisterCommandsEvent event) {
	}
	
	public static void registerForge(IEventBus bus) {
		bus.addListener(UsefulDragonEggsCommands::onRegisterCommands);
	}
	
}
