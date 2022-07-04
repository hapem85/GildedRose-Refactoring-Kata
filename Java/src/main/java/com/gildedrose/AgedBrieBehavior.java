package com.gildedrose;

/**
 * Aged Brie increases in Quality the older it gets
 * The Quality of an item is never more than 50
 */
public class AgedBrieBehavior extends ItemStateBehavior {
	
	public AgedBrieBehavior(Item item) {
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
		int quality = this.item.quality + 1;
		return quality > 50 ? 50 : quality;
	}
}
