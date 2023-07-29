package info.u_team.useful_dragon_eggs.init;

import info.u_team.useful_dragon_eggs.command.DragonEggsCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class UsefulDragonEggsCommands {
	
	private static void onRegisterCommands(RegisterCommandsEvent event) {
		DragonEggsCommand.register(event.getDispatcher());
	}
	
	public static void registerForge(IEventBus bus) {
		bus.addListener(UsefulDragonEggsCommands::onRegisterCommands);
	}
	
}
