package com.diego.modone.block;

import com.diego.modone.modone;
import com.diego.modone.util.Registration;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f,10f)
                    .sound(SoundType.METAL)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)));
    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f,10f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.STONE)));
    public static final RegistryObject<Block> COPPER_STAIRS = register("copper_stairs",
            () -> new StairsBlock(() -> ModBlocks.COPPER_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> COPPER_FENCE = register("copper_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> COPPER_FENCE_GATE = register("copper_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> COPPER_BUTTON = register("copper_button",
            () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)));



    //En desarrollo
    public static final RegistryObject<Block> COPPER_DOOR = register("copper_door",
            () -> new DoorBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6f).notSolid()));
    public static final RegistryObject<Block> COPPER_TRAPDOOR = register("copper_trapdoor",
            () -> new TrapDoorBlock(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2).setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(6f).notSolid()));

    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE = register("copper_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,AbstractBlock.Properties.create(Material.IRON)));
    public static final RegistryObject<Block> COPPER_SLAB = register("copper_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)));
    //
    public static void register(){}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T>block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name,() -> new BlockItem(toReturn.get(),
                new Item.Properties().group(modone.COURSE_TAB)));
        return toReturn;
    }
}
