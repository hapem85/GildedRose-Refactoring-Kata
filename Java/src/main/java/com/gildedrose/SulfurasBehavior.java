package com.gildedrose;

/**
 * Never change values for this item.
 */
public class SulfurasBehavior extends ItemStateBehavior {
	public SulfurasBehavior(Item item) {
		super(item);
	}
	
	@Override
	int changedItemSellIn() {
		return this.item.sellIn;
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
		return this.item.quality > 80 ? 80 : this.item.quality;
	}
}
