package info.u_team.useful_dragon_eggs.init;

import info.u_team.u_team_core.api.construct.Construct;
import info.u_team.u_team_core.api.construct.ModConstruct;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsMod;
import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Construct(modid = UsefulDragonEggsMod.MODID)
public class UsefulDragonEggsForgeCommonConstruct implements ModConstruct {
	
	@Override
	public void construct() {
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class, () -> new DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (remoteVersion, network) -> true));
		// BusRegister.registerForge(UsefulDragonEggsCommands::registerForge);
	}
}