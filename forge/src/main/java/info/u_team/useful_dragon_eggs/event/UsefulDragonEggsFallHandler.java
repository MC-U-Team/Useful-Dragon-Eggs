package info.u_team.useful_dragon_eggs.event;

import info.u_team.useful_dragon_eggs.config.ServerConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;

public class UsefulDragonEggsFallHandler {
	
	private static void onEntityJoinWorld(EntityJoinLevelEvent event) {
		final Level level = event.getLevel();
		
		if (level.isClientSide()) {
			return;
		}
		
		final Entity entity = event.getEntity();
		
		if (!(entity instanceof FallingBlockEntity fallingBlockEntity)) {
			return;
		}
		
		if (!ServerConfig.getInstance().bedrockBreaking.get()) {
			return;
		}
		
		final Block block = fallingBlockEntity.getBlockState().getBlock();
		
		if (block != Blocks.DRAGON_EGG || !(block instanceof DragonEggBlock)) {
			return;
		}
		
		// Replicate old lazy chunk behavior
		
		final BlockPos pos = fallingBlockEntity.blockPosition();
		
		if (level.isAreaLoaded(pos, 32)) {
			return;
		}
		
		event.setCanceled(true);
		
		level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		
		BlockPos fallPos;
		
		for (fallPos = pos; level.isEmptyBlock(fallPos) && FallingBlock.isFree(level.getBlockState(fallPos)) && fallPos.getY() > 0; fallPos = fallPos.below()) {
		}
		
		if (fallPos.getY() > 0) {
			level.setBlock(fallPos, Blocks.DRAGON_EGG.defaultBlockState(), 2);
		}
	}
	
	public static void registerForge(IEventBus bus) {
		bus.addListener(EventPriority.HIGHEST, UsefulDragonEggsFallHandler::onEntityJoinWorld);
	}
	
}
