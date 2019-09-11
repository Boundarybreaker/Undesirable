package space.bbkr.undesirable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateFactory;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ResettingPathBlock extends GrassBlock {
	public static IntProperty DESIRE_PROP = IntProperty.of("desiretramples", 0, 5);
	private Block transformTo;

	public ResettingPathBlock(Settings settings, Block transformTo) {
		super(settings);
		this.transformTo = transformTo;
	}

	@Override
	protected void appendProperties(StateFactory.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(DESIRE_PROP);
	}

	@Override
	public void onScheduledTick(BlockState state, World world, BlockPos pos, Random rand) {
		int convert = state.get(DESIRE_PROP);
		BlockState newState;
		if (convert <= 3) newState = transformTo.getDefaultState();
		else newState = Blocks.DIRT.getDefaultState();
		world.setBlockState(pos, newState);
	}

	@Override
	public boolean activate(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		int convert = state.get(DESIRE_PROP);
		BlockState newState;
		if (convert <= 3) newState = transformTo.getDefaultState();
		else newState = Blocks.DIRT.getDefaultState();
		world.setBlockState(pos, newState);
		return true;
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos posFrom, boolean boolean_1) {
		int convert = state.get(DESIRE_PROP);
		BlockState newState;
		if (convert <= 3) newState = transformTo.getDefaultState();
		else newState = Blocks.DIRT.getDefaultState();
		world.setBlockState(pos, newState);
	}
}
