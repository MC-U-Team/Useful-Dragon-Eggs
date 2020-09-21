package info.u_team.useful_dragon_eggs.event;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class UsefulDragonEggsFallHandler {
	
	private static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		final World world = event.getWorld();
		
		if (world.isRemote()) {
			return;
		}
		
		final Entity entity = event.getEntity();
		
		if (!(entity instanceof FallingBlockEntity)) {
			return;
		}
		
		final FallingBlockEntity fallingBlockEntity = (FallingBlockEntity) entity;
		final Block block = fallingBlockEntity.getBlockState().getBlock();
		
		if (block != Blocks.DRAGON_EGG || !(block instanceof DragonEggBlock)) {
			return;
		}
		
		// Replicate old lazy chunk behavior
		
		final BlockPos pos = fallingBlockEntity.getPosition();
		
		if (world.isAreaLoaded(pos, 32)) {
			return;
		}
		
		event.setCanceled(true);
		
		world.setBlockState(pos, Blocks.AIR.getDefaultState());
		
		BlockPos fallPos;
		
		for (fallPos = pos; world.isAirBlock(fallPos) && FallingBlock.canFallThrough(world.getBlockState(fallPos)) && fallPos.getY() > 0; fallPos = fallPos.down()) {
		}
		
		if (fallPos.getY() > 0) {
			world.setBlockState(fallPos, Blocks.DRAGON_EGG.getDefaultState(), 2);
		}
		
	}
	
	public static void registerForge(IEventBus bus) {
		bus.addListener(UsefulDragonEggsFallHandler::onEntityJoinWorld);
	}
	
}
