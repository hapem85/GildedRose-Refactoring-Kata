package com.gildedrose;

public class AgedBrieBehavior implements ItemStateBehavior {
	private Item item;
	
	public AgedBrieBehavior(Item item) {
		this.item = item;
	}
	
	/**
	 * Aged Brie increases in Quality the older it gets
	 * The Quality of an item is never more than 50
	 */
	@Override
	public void maintainState() {
		this.item.sellIn -= 1;
		this.item.quality += this.item.quality < 50 ? 1 : 0;
	}
}
