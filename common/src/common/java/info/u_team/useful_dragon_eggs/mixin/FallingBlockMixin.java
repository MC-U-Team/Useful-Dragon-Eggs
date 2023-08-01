package info.u_team.useful_dragon_eggs.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import info.u_team.useful_dragon_eggs.init.UsefulDragonEggsGameRules;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(FallingBlock.class)
abstract class FallingBlockMixin {
	
	@Inject(method = "tick", cancellable = true, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/FallingBlockEntity;fall(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/entity/item/FallingBlockEntity;"))
	private void usefuldragoneggs$tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random, CallbackInfo callback) {
		if (!level.getGameRules().getBoolean(UsefulDragonEggsGameRules.RULE_DO_BREAK_BEDROCK.get())) {
			return;
		}
		final Block block = state.getBlock();
		if (block != Blocks.DRAGON_EGG || !(block instanceof DragonEggBlock)) {
			return;
		}
		
		// Replicate old lazy chunk behavior
		if (isAreaLoaded(level, pos, 32)) {
			return;
		}
		callback.cancel();
		
		level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		
		BlockPos fallPos;
		for (fallPos = pos; level.isEmptyBlock(fallPos) && FallingBlock.isFree(level.getBlockState(fallPos)) && fallPos.getY() > 0; fallPos = fallPos.below()) {
		}
		
		if (fallPos.getY() > 0) {
			level.setBlock(fallPos, Blocks.DRAGON_EGG.defaultBlockState(), 2);
		}
	}
	
	@SuppressWarnings("deprecation")
	@Unique
	private final boolean isAreaLoaded(Level level, BlockPos pos, int range) {
		return level.hasChunksAt(pos.offset(-range, -range, -range), pos.offset(range, range, range));
	}
	
}
