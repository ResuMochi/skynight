package top.skynight;

import net.fabricmc.api.ModInitializer;

public class Skynight implements ModInitializer {
	/**
	 * 对于我之前说的文件乱，其实是使用 https://fabricmc.net/develop/template/ 时
	 * 模板生成器默认勾选了 Split client and common sources，将其关闭就不乱了（迫真）。
	 * 但是会有问题，解决方法：在 src\main\java\<MOD_ID>\ 下创建一个 <MOD_ID>Client.java文件
	 * 中写入：
	 * <blockquote>
	 * 
	 * <pre>
	 * 
	 * import net.fabricmc.api.ClientModInitializer;
	 * 
	 * public class SkynightClient implements ClientModInitializer {
	 * 
	 * 	@Override
	 * 	public void onInitializeClient() {
	 * 	}
	 * }
	 * </pre>
	 * 
	 * </blockquote>
	 * <p>
	 * 
	 * 然后在 {@code src\main\resources\fabric.mod.json} 的 {@code "entrypoints"} 添加
	 * {@code "client":["top.skynight.SkynightClient"]}
	 * 完成！
	 */
	public static final String MOD_ID = "skynight";

	@Override
	public void onInitialize() {

		// 设置物品组（要在物品注册之前调用）
		top.skynight.registry.ModItemGroups.registerItemGroup();

		// 物品注册
		top.skynight.registry.ModItems.registerModItems();

		// 方块注册
		top.skynight.registry.ModBlocks.registerModBlocks();

	}
}