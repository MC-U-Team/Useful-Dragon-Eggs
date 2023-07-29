package info.u_team.useful_dragon_eggs.init;

import info.u_team.u_team_core.api.construct.Construct;
import info.u_team.u_team_core.api.construct.ModConstruct;
import info.u_team.u_team_core.util.registry.BusRegister;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsMod;
import info.u_team.useful_dragon_eggs.config.ServerConfig;
import info.u_team.useful_dragon_eggs.event.UsefulDragonEggsFallHandler;
import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.network.NetworkConstants;

@Construct(modid = UsefulDragonEggsMod.MODID)
public class UsefulDragonEggsCommonConstruct implements ModConstruct {
	
	@Override
	public void construct() {
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class, () -> new DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (remoteVersion, network) -> true));
		ModLoadingContext.get().registerConfig(Type.SERVER, ServerConfig.CONFIG);
		
		BusRegister.registerForge(UsefulDragonEggsCommands::registerForge);
		BusRegister.registerForge(UsefulDragonEggsFallHandler::registerForge);
	}
}