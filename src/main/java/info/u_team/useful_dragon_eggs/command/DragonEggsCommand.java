package info.u_team.useful_dragon_eggs.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;

import net.minecraft.command.*;

public class DragonEggsCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("dragoneggs") //
				.then(Commands.literal("bedrock-breaking") //
						.requires(source -> source.hasPermissionLevel(2)) //
						.then(Commands.argument("value", BoolArgumentType.bool())).executes(context -> {
							return bedrockBreaking(context.getSource(), BoolArgumentType.getBool(context, "value"));
						})));
	}
	
	private static int bedrockBreaking(CommandSource source, boolean value) {
		return 0;
	}
	
}
