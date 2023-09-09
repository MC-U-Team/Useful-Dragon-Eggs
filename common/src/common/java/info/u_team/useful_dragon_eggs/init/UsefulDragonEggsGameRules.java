package info.u_team.useful_dragon_eggs.init;

import info.u_team.u_team_core.api.registry.GameRuleRegister;
import info.u_team.u_team_core.api.registry.LazyEntry;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsReference;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;

public class UsefulDragonEggsGameRules {
	
	public static final GameRuleRegister GAME_RULES = GameRuleRegister.create();
	
	public static final LazyEntry<GameRules.Key<BooleanValue>> RULE_DO_BREAK_BEDROCK = GAME_RULES.register(UsefulDragonEggsReference.MODID, "doBreakBedrock", GameRules.Category.MISC, () -> GameRules.BooleanValue.create(true));
	
	public static final LazyEntry<GameRules.Key<BooleanValue>> RULE_DO_RESPAWN_DRAGON_EGG = GAME_RULES.register(UsefulDragonEggsReference.MODID, "doRespawnDragonEgg", GameRules.Category.MISC, () -> GameRules.BooleanValue.create(true));
	
	static void register() {
		GAME_RULES.register();
	}
}
