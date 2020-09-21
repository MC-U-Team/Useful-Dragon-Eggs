package info.u_team.useful_dragon_eggs.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.command.CommandSource;

public class DragonEggsCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(LiteralArgumentBuilder.literal("dragoneggs"));
	}
	
}
