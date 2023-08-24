package top.skynight.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import top.skynight.registry.ModBlocks;
import top.skynight.registry.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NA_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.THE_FIRST_ITEM, Models.GENERATED);

        /*
         * 这是是设置 ModItems.THE_RBPICKAXE_ITEM 的模型类型，当前设置的是 Models.HANDHELD，像原版的稿子那样拿在手上
         * 如果设置成 Models.GENERATED 的话就会像物品一样拿在手上
         * 这里修改后，要同步修改rb_pickaxe的json文件，不然不生效
         */
        itemModelGenerator.register(ModItems.THE_RBPICKAXE_ITEM, Models.HANDHELD);

    }

}
