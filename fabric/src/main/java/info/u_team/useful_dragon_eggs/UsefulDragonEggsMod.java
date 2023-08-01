package info.u_team.useful_dragon_eggs;

import info.u_team.u_team_core.util.annotation.AnnotationManager;
import net.fabricmc.api.ModInitializer;

public class UsefulDragonEggsMod implements ModInitializer {
	
	public static final String MODID = UsefulDragonEggsReference.MODID;
	
	@Override
	public void onInitialize() {
		AnnotationManager.callAnnotations(MODID);
	}
}
