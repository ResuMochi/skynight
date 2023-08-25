package top.skynight.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block/*这个包要反编译mc源码才能导入！ */;
/* 反编译： .\gradlew genSources
 * 运行这条命令需要64位（x64）的Java！
 */
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import top.skynight.Skynight;

public class ModBlocks {

    // public static final Block NA_BLOCK = registerBlock(
    // "na_block",
    // // 妈的找这一行找半天 ——2023-08-23
    // new
    // Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE).strength(0.4F).requiresTool()),
    // ModItemGroups.GROUP_INDENT);

    /**
     * 不知名方块
     */
    public static final Block NA_BLOCK = registerBlock(
            "na_block",
            newBlockRT(BlockSoundGroup.STONE/* 材质，这里是石头 */, 3f/* 硬度 */),
            ModItemGroups.GROUP_INDENT);

    @SafeVarargs
    public static Block registerBlock/* 注册方块 */(String name, Block block, RegistryKey<ItemGroup>... itemGroups) {
        ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()), itemGroups);
        return Registry.register(Registries.BLOCK, new Identifier(Skynight.MOD_ID, name), block);
    }

    /**
     * 这是一个构建新方块的辅助函数，传入BlockSoundGroup和方块硬度即可快捷构建
     * <p>
     * 如果使用了这个方法，那么要在{@code resources\data\minecraft\tags\blocks\mineable\}下编辑相应的json文件
     * <p>
     * 分别是：
     * <p>
     * axe.json 斧头；
     * <p>
     * hoe.json 锄头；
     * <p>
     * pickaxe.json 镐子；
     * <p>
     * shovel.json 铲子。
     * <p>
     * 这个函数构建的方块需要工具，即 {@code requiresTool()}
     * <p>
     * 还有一个孪生方法：不需要工具的版本
     * 
     * @see top.skynight.registry.ModBlocks#newBlock()
     */
    public static Block newBlockRT(BlockSoundGroup block_sound_group, float strength) {
        /*
         * 在Fabric Wiki 中给出的方法是用不了的，好像缺了什么东西，但Fabric的源码里又没有详细的文档（可以说是大部分时候连个注释都没有）
         * 但最终在一位b站用户发出来的截图里找到了这行代码，我才得以解决问题······
         */
        return new Block(FabricBlockSettings.create().sounds(block_sound_group).strength(strength).requiresTool());
    }

    /**
     * 这是一个构建新方块的辅助函数，传入BlockSoundGroup和方块硬度即可快捷构建
     * 这个是不需要工具的版本
     * 
     * @param block_sound_group
     * @param strength
     * @return
     */
    public static Block newBlock(BlockSoundGroup block_sound_group, float strength) {
        return new Block(FabricBlockSettings.create().sounds(block_sound_group).strength(strength));
    }

    public static void registerModBlocks() {
    }

}
