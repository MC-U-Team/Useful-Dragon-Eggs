package info.u_team.useful_dragon_eggs.init;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import info.u_team.u_team_core.api.event.CommonEvents;
import info.u_team.u_team_core.api.registry.LazyEntry;
import info.u_team.useful_dragon_eggs.UsefulDragonEggsReference;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.GameRules.BooleanValue;
import net.minecraft.world.level.GameRules.Key;

public class UsefulDragonEggsGameRules {
	
	public static final LazyEntry<GameRules.Key<BooleanValue>> RULE_DO_BREAK_BEDROCK = new LazyEntry<GameRules.Key<BooleanValue>>() { // TODO rework
		
		private Supplier<GameRules.Key<BooleanValue>> value = Suppliers.memoize(() -> GameRules.register(UsefulDragonEggsReference.MODID + ":doBreakBedrock", GameRules.Category.MISC, GameRules.BooleanValue.create(true)));
		
		@Override
		public Key<BooleanValue> get() {
			return value.get();
		}
		
		@Override
		public boolean isPresent() {
			return true;
		}
	};
	
	static void register() {
		CommonEvents.registerRegister(key -> {
			if (key == Registries.BLOCK) {
				RULE_DO_BREAK_BEDROCK.get(); // Register for now this way. TODO rework
			}
		});
	}
}
