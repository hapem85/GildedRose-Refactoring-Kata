package com.gildedrose;

public class NormalBehavior implements ItemStateBehavior {

	private Item item;
	
	public NormalBehavior(Item item) {
		this.item = item;
	}
	
	/**
	 * At the end of each day our system lowers both values (sellIn and quality)
	 * Once the sell by date has passed, Quality degrades twice as fast
	 * The Quality of an item is never negative
	 */
	@Override
	public void maintainState() {
		this.item.sellIn -= 1;
		this.item.quality -= 1;
		
        if (item.sellIn < 0) {
        	item.quality -= 1;
        }
        if(item.quality < 0) {
        	item.quality = 0;
        }
	}
}
