package space.bbkr.undesirable;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Undesirable implements ModInitializer {
	public static final String MODID = "desire-paths";

	public static final Block DIRT_COARSE_INTER = new ResettingPathBlock(FabricBlockSettings.copy(Blocks.DIRT).ticksRandomly().dropsLike(Blocks.DIRT).build(), Blocks.DIRT);
	public static final Block GRASS_DIRT_INTER = new ResettingPathBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK).ticksRandomly().dropsLike(Blocks.GRASS_BLOCK).build(), Blocks.GRASS_BLOCK);
	public static final Block PODZOL_DIRT_INTER = new ResettingPathBlock(FabricBlockSettings.copy(Blocks.PODZOL).ticksRandomly().dropsLike(Blocks.PODZOL).build(), Blocks.PODZOL);
	public static final Block MYCELIUM_DIRT_INTER = new ResettingPathBlock(FabricBlockSettings.copy(Blocks.MYCELIUM).ticksRandomly().dropsLike(Blocks.MYCELIUM).build(), Blocks.MYCELIUM);

	@Override
	public void onInitialize() {
		register("dirt_coarse_inter", DIRT_COARSE_INTER);
		register("grass_dirt_inter", GRASS_DIRT_INTER);
		register("podzol_dirt_inter", PODZOL_DIRT_INTER);
		register("mycelium_dirt_inter", MYCELIUM_DIRT_INTER);
	}

	public static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
	}
}
