package com.gildedrose;

/**
 * At the end of each day our system lowers both values (sellIn and quality)
 * Once the sell by date has passed, Quality degrades twice as fast
 * The Quality of an item is never negative
 */
public class NormalBehavior extends ItemStateBehavior {
	
	public NormalBehavior(Item item) {
		super(item);
	}
	
	@Override
	int changedItemSellIn() {
		return this.item.sellIn - 1;
	}

	@Override
	int changedItemQuality() {
		return getUpdatedQuality();
	}

	@Override
	int changedItemQualityIfSellInLessThanZero() {
		return getUpdatedQuality();
	}
	
	private int getUpdatedQuality() {
		int quality = this.item.quality - 1;
		return quality < 0 ? 0 : quality;
	}
}
