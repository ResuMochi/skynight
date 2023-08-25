package top.skynight.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class Rb_pickaxeItem extends MiningToolItem {
    public Rb_pickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings) {
        super((float) attackDamage, attackSpeed, material, BlockTags.PICKAXE_MINEABLE, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.skynight.rb_pickaxe.tooltip_1"));
        tooltip.add(Text.translatable("item.skynight.rb_pickaxe.tooltip_2"));
        tooltip.add(Text.translatable("item.skynight.rb_pickaxe.tooltip_3")
                /*
                 * 这里设置了字体样式当前设置的是斜体
                 */.setStyle(Style.EMPTY.withItalic(true)));
    }
}