package info.u_team.useful_dragon_eggs.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import info.u_team.useful_dragon_eggs.init.UsefulDragonEggsGameRules;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.dimension.end.EndDragonFight;

@Mixin(EndDragonFight.class)
abstract class EndDragonFightMixin {
	
	@Shadow
	@Final
	private ServerLevel level;
	
	@Shadow
	private boolean previouslyKilled;
	
	@Redirect(method = "setDragonKilled", at = @At(value = "FIELD", opcode = Opcodes.GETFIELD, target = "Lnet/minecraft/world/level/dimension/end/EndDragonFight;previouslyKilled:Z"))
	private boolean usefuldragoneggs$setDragonKilled$previouslyKilled(EndDragonFight endDragonFight) {
		if (level.getGameRules().getBoolean(UsefulDragonEggsGameRules.RULE_DO_RESPAWN_DRAGON_EGG.get())) {
			return false;
		}
		return previouslyKilled;
	}
	
}
