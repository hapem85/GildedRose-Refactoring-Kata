package com.gildedrose;

public class ConjuredBehavior implements ItemStateBehavior {

	private Item item;
	
	public ConjuredBehavior(Item item) {
		this.item = item;
	}
	
	/**
	 * At the end of each day our system lowers both values (sellIn and quality)
	 * Item degrades in Quality twice as fast as normal items (even when sellIn < 0 ??)
	 * The Quality of an item is never negative
	 */
	@Override
	public void maintainState() {
		this.item.quality -= 2;
		this.item.sellIn -= 1;
		
        if (item.sellIn < 0) {
        	item.quality -= 2;
        }
        if(item.quality < 0) {
        	item.quality = 0;
        }
	}
}
