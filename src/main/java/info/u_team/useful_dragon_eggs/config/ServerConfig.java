package info.u_team.useful_dragon_eggs.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;

public class ServerConfig {
	
	public static final ForgeConfigSpec CONFIG;
	private static final ServerConfig INSTANCE;
	
	static {
		Pair<ServerConfig, ForgeConfigSpec> pair = new Builder().configure(ServerConfig::new);
		CONFIG = pair.getRight();
		INSTANCE = pair.getLeft();
	}
	
	public static ServerConfig getInstance() {
		return INSTANCE;
	}
	
	public final BooleanValue bedrockBreaking;
	
	private ServerConfig(Builder builder) {
		builder.comment("Server configuration settings").push("server");
		bedrockBreaking = builder.comment("Allow breaking bedrock with dragon eggs in lazy chunks (y=0 is excluded)").define("bedrockBreaking", true);
		builder.pop();
	}
	
}
