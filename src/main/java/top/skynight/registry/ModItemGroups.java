package top.skynight.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import top.skynight.Skynight;

public class ModItemGroups {

    // 这里构建一个注册物品组所需的RegistryKey
    public static RegistryKey<ItemGroup> GROUP_INDENT = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            new Identifier(Skynight.MOD_ID));

    public static void registerItemGroup() {
        // 注册物品组
        Registry.register(Registries.ITEM_GROUP, GROUP_INDENT, ItemGroup.create(ItemGroup.Row.TOP, 3)
                // 显示的物品组名称
                .displayName(Text.translatable("itemGroup.group_indent"))
                // 物品组图标
                .icon(() -> new ItemStack(ModItems.THE_FIRST_ITEM))
                /*
                 * 添加物品到物品组里面
                 * 一般来讲不需要在这里添加，注册物品时给定组就好了
                 */
                .entries((displayContext, entries) -> {
                    // entries.add(ModItems.THE_FIRST_ITEM);
                }).build());
    }
}
