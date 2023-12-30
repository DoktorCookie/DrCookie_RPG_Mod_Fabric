package net.drcookie.drcookies_rpg_mod.item.custom;

import net.drcookie.drcookies_rpg_mod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }


    //overwrites the otherwise empty useOnBlock function
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        //Checks if the use is server side -> see the "!"
        if (!context.getWorld().isClient()) {

            //Variable saves the clicked blocks position
            BlockPos positionClicked = context.getBlockPos();

            //saves the player entity
            PlayerEntity player = context.getPlayer();

            //to determine if a block was found
            boolean foundBlock = false;

            // for loop runs from -64 to current Y level (64 blocks more than the pure Pos Y)
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {

                //evaluated block state, from the clicked position i steps down, one block at a time
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                //determines if the block is valuable using a self-ridden helper function
                if (isValuableBlock(state)) {

                    //helper function to output found blocks coordinates and name
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());

                    foundBlock = true;

                    //breaks the loop after first blocks was found
                    break;
                }


                }

            if(!foundBlock) {
                player.sendMessage(Text.literal("No Valuables Found :("));

            }

        }

        //damages the item in the player hand by 1 (damage is invoked on the getStack object I think)
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    //helper function to output found blocks coordinates and name
    //player value is needed to send the message to the specific player
    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {

        //overlay: shown in the middle or as chat message
        player.sendMessage(Text.literal( "Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")" ), false );

    }

    //helper function to determine if the block is "valuable", if the block should be detected.
    //Functions through evaluating the found Block State
    private boolean isValuableBlock(BlockState state) {

        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
        //Tag version doesn't work anymore
        //return state.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);

    }

    //Adds a custom Tooltip, needs a custom item class
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.drcookies_rpg_mod.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
