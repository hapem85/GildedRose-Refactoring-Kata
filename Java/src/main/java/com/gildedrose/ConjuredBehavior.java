package com.gildedrose;

/**
 * At the end of each day our system lowers both values (sellIn and quality)
 * Item degrades in Quality twice as fast as normal items (even when sellIn < 0, right??)
 * The Quality of an item is never negative
 */
public class ConjuredBehavior extends ItemStateBehavior {

	public ConjuredBehavior(Item item) {
		super(item);
	}
	
	@Override
	int changedItemSellIn() {
		return item.sellIn - 1;
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
		int quality = item.quality - 2;
		return quality < 0 ? 0 : quality;
	}
}
