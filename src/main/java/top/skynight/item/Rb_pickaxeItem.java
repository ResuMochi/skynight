package top.skynight.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class Rb_pickaxeItem extends Item {
    public Rb_pickaxeItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.skynight.rb_pickaxe.tooltip_1"));
        tooltip.add(Text.translatable("item.skynight.rb_pickaxe.tooltip_2"));
        tooltip.add(Text.translatable("item.skynight.rb_pickaxe.tooltip_3").setStyle(Style.EMPTY.withItalic(true)));
    }
}