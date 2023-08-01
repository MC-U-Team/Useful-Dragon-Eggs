package info.u_team.useful_dragon_eggs;

import info.u_team.u_team_core.util.annotation.AnnotationManager;
import info.u_team.u_team_core.util.verify.JarSignVerifier;
import net.minecraft.world.level.dimension.end.EndDragonFight;
import net.minecraftforge.fml.common.Mod;

@Mod(UsefulDragonEggsMod.MODID)
public class UsefulDragonEggsMod {
	
	public static final String MODID = UsefulDragonEggsReference.MODID;
	
	public UsefulDragonEggsMod() {
		JarSignVerifier.checkSigned(MODID);
		
		AnnotationManager.callAnnotations(MODID);
		
		System.out.println(EndDragonFight.class);
	}
}
