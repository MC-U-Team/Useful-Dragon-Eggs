package info.u_team.useful_dragon_eggs.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;

import info.u_team.useful_dragon_eggs.config.ServerConfig;
import net.minecraft.command.*;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class DragonEggsCommand {
	
	public static void register(CommandDispatcher<CommandSource> dispatcher) {
		dispatcher.register(Commands.literal("dragoneggs") //
				.then(Commands.literal("bedrock-breaking") //
						.requires(source -> source.hasPermissionLevel(2)) //
						.then(Commands.argument("value", BoolArgumentType.bool())).executes(context -> {
							return bedrockBreakingSet(context.getSource(), BoolArgumentType.getBool(context, "value"));
						})));
	}
	
	private static int bedrockBreakingSet(CommandSource source, boolean value) {
		final BooleanValue bedrockBreaking = ServerConfig.getInstance().bedrockBreaking;
		bedrockBreaking.set(value);
		bedrockBreaking.save();
		return 0;
	}
	
}
