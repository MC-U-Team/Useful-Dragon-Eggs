package info.u_team.useful_dragon_eggs.init;

import info.u_team.u_team_core.api.construct.Construct;
import info.u_team.u_team_core.api.construct.ModConstruct;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsReference;

@Construct(modid = UsefulDragonEggsReference.MODID)
public class UsefulDragonEggsCommonConstruct implements ModConstruct {
	
	@Override
	public void construct() {
		UsefulDragonEggsGameRules.register();
	}
}