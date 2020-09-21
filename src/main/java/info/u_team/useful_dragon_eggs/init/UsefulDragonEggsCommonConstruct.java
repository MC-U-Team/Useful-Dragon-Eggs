package info.u_team.useful_dragon_eggs.init;

import info.u_team.u_team_core.api.construct.*;
import info.u_team.u_team_core.util.registry.BusRegister;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsMod;
import info.u_team.useful_dragon_eggs.event.UsefulDragonEggsFallHandler;

@Construct(modid = UsefulDragonEggsMod.MODID)
public class UsefulDragonEggsCommonConstruct implements IModConstruct {
	
	@Override
	public void construct() {
		BusRegister.registerForge(UsefulDragonEggsCommands::registerForge);
		BusRegister.registerForge(UsefulDragonEggsFallHandler::registerForge);
	}
}