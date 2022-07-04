package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemBehaviorFactory {
	
	private final static Map<String, ItemStateBehavior> ITEM_TYPES = new HashMap<>();
    public final static String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
    public final static String AGED_BRIE_ITEM = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_ITEM = "Conjured Mana Cake";
	
	public ItemBehaviorFactory(Item item) {
		ITEM_TYPES.put(SULFURAS_ITEM, new SulfurasBehavior(item));
		ITEM_TYPES.put(AGED_BRIE_ITEM, new AgedBrieBehavior(item));
		ITEM_TYPES.put(BACKSTAGE_PASSES_ITEM, new BackstagePassesBehavior(item));
		ITEM_TYPES.put(CONJURED_ITEM, new ConjuredBehavior(item));
	}
	
	/**
	 * Basing on the type of item to get the appropriate behaviors.
	 * @param item {@link Item}
	 * @return {@link ItemStateBehavior}
	 */
	public ItemStateBehavior getItemBehavior(Item item) {
		return ITEM_TYPES.containsKey(item.name) ? ITEM_TYPES.get(item.name) : new NormalBehavior(item);
	}
}