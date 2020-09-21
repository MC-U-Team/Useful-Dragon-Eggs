package info.u_team.useful_dragon_eggs.init;

import org.apache.commons.lang3.tuple.Pair;

import info.u_team.u_team_core.api.construct.*;
import info.u_team.u_team_core.util.registry.BusRegister;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsMod;
import info.u_team.useful_dragon_eggs.event.UsefulDragonEggsFallHandler;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.network.FMLNetworkConstants;

@Construct(modid = UsefulDragonEggsMod.MODID)
public class UsefulDragonEggsCommonConstruct implements IModConstruct {
	
	@Override
	public void construct() {
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));
		
		BusRegister.registerForge(UsefulDragonEggsCommands::registerForge);
		BusRegister.registerForge(UsefulDragonEggsFallHandler::registerForge);
	}
}