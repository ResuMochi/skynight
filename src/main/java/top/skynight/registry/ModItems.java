package top.skynight.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import top.skynight.Skynight;
import top.skynight.item.FabricItem;
import top.skynight.item.Rb_pickaxeItem;

public class ModItems {

    // TODO:完善这里的文档
    public static final Item THE_FIRST_ITEM = registerItem("fabric",
            new FabricItem(new FabricItemSettings().maxCount(16)),
            ItemGroups.INGREDIENTS/* 原版：原材料 */, ModItemGroups.GROUP_INDENT);

    public static final ToolItem THE_RBPICKAXE_ITEM = registerToolItem("rb_pickaxe",
            new Rb_pickaxeItem(ModToolsMaterial.RB_PICKAXE, 3,
                    -2.8f/*
                          * 这里出于未知原因，若这里传入0，则游戏内显示的攻击速度是4，若输入1，则游戏内显示的是5（也就是4+1）
                          * 所以这里传入 -2.8，那么在游戏内就会是1.2了，跟原版镐子相同的攻击速度。
                          */
                    , new FabricItemSettings()),
            ModItemGroups.GROUP_INDENT);

    public static final Item SCRAP_ITEM = registerItem("scrap",
            new Item(new FabricItemSettings().maxCount(64)),
            ModItemGroups.GROUP_INDENT);

    /*
     * 这里的写法是从 https://www.bilibili.com/video/BV1Vj411S71d/ 里学来的
     * 但是放到这里有问题，所以下面的写法是来自 https://space.bilibili.com/191676613 大佬的
     * 感谢以上两位前辈！
     */
    @SafeVarargs
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups) {
        Item registerItem = Registry.register(Registries.ITEM, new Identifier(Skynight.MOD_ID, name),
                item);
        for (RegistryKey<ItemGroup> itemGroup : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> {
                entries.add(registerItem);
            });
        } // 下面的写法除了变量类型不同几乎没变化
        return registerItem;
    }

    /*
     * 这是上面方法的变体方法，除了变量类型不同几乎没变化
     */
    @SafeVarargs
    public static ToolItem registerToolItem(String name, MiningToolItem item, RegistryKey<ItemGroup>... itemGroups) {
        ToolItem registerItem = Registry.register(Registries.ITEM, new Identifier(Skynight.MOD_ID, name),
                item);
        for (RegistryKey<ItemGroup> itemGroup : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> {
                entries.add(registerItem);
            });
        }
        return registerItem;
    }

    /**
     * 这是一个创建item时的辅助方法：快速创建item
     * 使用此方法可以快速返回 {@code new Item(new FabricItemSettings())}
     * <p>
     * 注意！用此方法（包括其变体）创建的item没有工具提示（tooltip），若有需要，
     * 必须创一个新Item容器，重写appendTooltip方法
     * <p>
     * 此方法还有一个可自主设置最大堆叠数的变体方法{@code newItemMaxCount(int size)}
     */
    public static Item newItem() {
        return new Item(new FabricItemSettings());
    }

    /**
     * 这是{@code newItem()}的变体
     * <p>
     * 调用时可以改变物品堆叠上限
     * 
     */
    public static Item newItemMaxCount(int size) {
        return new Item(new FabricItemSettings().maxCount(size));
    }

    public static void registerModItems() {
        FuelRegistry.INSTANCE.add(ModItems.THE_FIRST_ITEM, 1500);
        CompostingChanceRegistry.INSTANCE.add(ModItems.THE_FIRST_ITEM, (float) 1);
    }

}
