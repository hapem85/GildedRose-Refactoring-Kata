package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemBehaviorFactory {
	
	private final static Map<String, ItemStateBehavior> ITEM_TYPES = new HashMap<>();
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	
	public ItemBehaviorFactory(Item item) {
		ITEM_TYPES.put(SULFURAS, new SulfurasBehavior());
		ITEM_TYPES.put(BRIE, new AgedBrieBehavior(item));
		ITEM_TYPES.put(BACKSTAGE_PASSES_ITEM, new BackstagePassesBehavior(item));
	}
	
	/**
	 * Basing on the type of item, it will get the appropriate behaviors.
	 * @param item {@link Item}
	 * @return {@link ItemStateBehavior}
	 */
	public ItemStateBehavior getItemBehavior(Item item) {
		return ITEM_TYPES.containsKey(item.name) ? ITEM_TYPES.get(item.name) : new NormalBehavior(item);
	}
}