package top.skynight.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/*
 * 这个文件新建了一个 ToolMaterial 的容器
 * 
 * 那么什么叫做：“这个文件新建了一个 ToolMaterial 的容器”？
 *  
 * 这个容器（ModTools）在用途上与 ToolMaterial 是一摸一样的，区别在于 ToolMaterial 是一块白板
 * 干不了任何事情，这个时候我们创建一个 ToolMaterial 的容器 ModTools，并在 ModTools 内实现（写上）
 * 与 ToolMaterial 相同的、对应的方法，就能使用了。
 * 
 * 不具体但是形象地比喻，那应该是：ToolMaterial 是一具灵魂，若赋予这个灵魂一具肉体则成了 ModTools 。
 * 
 * 下文带有 @Override 标签的方法实现了 ToolMaterial 的方法。这是什么意思呢？
 * 
 * 按住 Ctrl 点进 ToolMaterial 看它源码，会发现里面有五个空的方法，
 * 与本文件实现的方法是一模一样的（无论名称还是类型），也必须是一摸一样的，不然会报错，
 * 唯一不相同的是本文件里的方法有内容（有返回值）。
 * 
 * 其实这样写（仅仅做一个容器，但是大方阔笔写上涵盖度超级广的名字：ModTools）是不恰当的，因为一个
 * 容器可能只适合一个给工具用。而若是添加了很多个工具，则需要创建更多的 ToolMaterial 容器了
 * 
 * 所以为了方便，我们需要创建一个 ModTools 文件夹，再在里面存入命名清晰的容器，方便区别。
 * 
 * 此外，由于 Fabric Wiki 的文档确实过于简洁，这部分确实是需要点编程基础才能理解的。
 * 
 * 如果你理解了本文件里发生的事情，那么就在 src\main\java\top\skynight\tool 里完善彩虹猫大稿子吧。
 * （src\main\java\top\skynight\tool 里放ToolMaterial容器）
 * 
 * 我在下面写了模板
 * 
 */
public enum ModToolsMaterial implements ToolMaterial {
    RB_PICKAXE(971, 6, 0, 3, 26, null);

    /**
     * ModTools 可以使用 ModTools.INSTANCE 引用
     * 这里将 ModTools作为实例存在了 ModTools.INSTANCE 中，需要用的时候调用 ModTools.INSTANCE 即可
     */
    // public static final ModTools INSTANCE = new ModTools();
    // 已弃用，因为下面已经写好构造函数了。上面这条代码是没写好构造函数时使用的。

    // 枚举（enum）
    private final int itemDurability;/// 耐久
    private final float itemMiningSpeedMultiplier;// 挖掘速度
    private final float itemAttackDamage;// 攻击伤害
    private final int itemMiningLevel;// 挖掘等级
    private final int itemEnchantability;// 附魔能力
    private final Ingredient itemRepairIngredient;// 修复原料

    // 上面已经写好变量了，现在来写 构造函数
    ModToolsMaterial(int itemDurability, float itemMiningSpeedMultiplier, float itemAttackDamage, int itemMiningLevel,
            int itemEnchantability, Ingredient itemRepairIngredient) {
        this.itemDurability = itemDurability;
        this.itemMiningSpeedMultiplier = itemMiningSpeedMultiplier;
        this.itemAttackDamage = itemAttackDamage;
        this.itemMiningLevel = itemMiningLevel;
        this.itemEnchantability = itemEnchantability;
        this.itemRepairIngredient = itemRepairIngredient;
    }

    // 下面是对 ToolMaterial 的重写

    /*
     * 耐久
     */
    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    /*
     * 挖掘速度
     */
    @Override
    public float getMiningSpeedMultiplier() {
        return this.itemMiningSpeedMultiplier;
    }

    /*
     * 攻击伤害
     */
    @Override
    public float getAttackDamage() {
        return this.itemAttackDamage;
    }

    /*
     * 挖掘等级
     */
    @Override
    public int getMiningLevel() {
        return this.itemMiningLevel;
    }

    /*
     * 附魔能力
     */
    @Override
    public int getEnchantability() {
        return this.itemEnchantability;
    }

    /*
     * 修复原料
     */
    @Override
    public Ingredient getRepairIngredient() {
        return this.itemRepairIngredient;
    }
}
