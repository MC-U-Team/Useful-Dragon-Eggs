package info.u_team.useful_dragon_eggs.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;

import info.u_team.useful_dragon_eggs.config.ServerConfig;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class DragonEggsCommand {
	
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("dragoneggs") //
				.then(Commands.literal("bedrock-breaking") //
						.requires(source -> source.hasPermission(2)) //
						.executes(context -> {
							return bedrockBreakingGet(context.getSource());
						}) //
						.then(Commands.argument("value", BoolArgumentType.bool()) //
								.executes(context -> {
									return bedrockBreakingSet(context.getSource(), BoolArgumentType.getBool(context, "value"));
								}))));
	}
	
	private static int bedrockBreakingGet(CommandSourceStack source) {
		final BooleanValue bedrockBreaking = ServerConfig.getInstance().bedrockBreaking;
		source.sendSuccess(() -> Component.literal("Value bedrock-breaking is currently set to: " + bedrockBreaking.get()), false);
		return 0;
	}
	
	private static int bedrockBreakingSet(CommandSourceStack source, boolean value) {
		final BooleanValue bedrockBreaking = ServerConfig.getInstance().bedrockBreaking;
		bedrockBreaking.set(value);
		source.sendSuccess(() -> Component.literal("Value bedrock-breaking is now set to: " + bedrockBreaking.get()), true);
		return 0;
	}
	
}
