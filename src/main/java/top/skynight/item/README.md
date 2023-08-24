## 如何使用tooltip？Wiki上的是什么意思？为何一直没有成功？

https://fabricmc.net/wiki/zh_cn:tutorial:tooltip
这是官方wiki的教学方式，不得不说，这也太简洁了，简洁到令人沮丧。

回顾一下wiki内容：


### 什么叫做“在您的物品类中，像这样重写 appendTooltip”？

最初我也没看懂。但是我是怎么解决的呢？

我直接新建了一个java子类。以本文件夹里的 FabricItem.java 为例：

我们先新建一个Item的子类，写入构造函数。

```java
// FabricItem.java
public class FabricItem extends Item {
    public FabricItem(Settings settings) {
        super(settings);
    }
}
```

好了，然后再去wiki那里copy对应的源码下来，自己修改，最终应该是这样的（在我的视角下）：

```java
// FabricItem.java
package top.skynight.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class FabricItem extends Item {
    public FabricItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        // 默认为白色文本
        tooltip.add(Text.translatable("item.skynight.fabric.tooltip"));
    }
}
```

这时候回到你注册物品的地方，（不出意外的话）应该会看到如下字样：

`new Item(new FabricItemSettings())`

没看到再仔细找找。将父类 `Item` 修改为刚刚写好的子类 `FabricItem`

最后，到 `src/main/resources/assets/[MOD_ID]/lang` 下修改语言文件即可，示例如下：

```json
{
    "item.skynight.fabric.tooltip":"Hello Fabric World!"
}
```

最终的工具提示就是显示 `Hello Fabric World!`

