package com.gildedrose;

/**
 * Backstage passes increases in Quality the older it gets
 * Quality increases by 2 when there are 10 days or less
 * by 3 when there are 5 days or less
 * Quality drops to 0 after the concert
 * The Quality of an item is never more than 50
 */
public class BackstagePassesBehavior extends ItemStateBehavior {
	
	public BackstagePassesBehavior(Item item) {
		super(item);
	}
	
	@Override
	int changedItemSellIn() {
		return this.item.sellIn - 1;
	}

	@Override
	int changedItemQuality() {
		int quality = this.item.quality; 
		quality += this.getUpdatedQualityNumber(quality);
		
		if (this.item.sellIn < 11) {
			quality += this.getUpdatedQualityNumber(quality);
        }

        if (this.item.sellIn < 6) {
        	quality += this.getUpdatedQualityNumber(quality);
        }
        return quality;
	}

	@Override
	int changedItemQualityIfSellInLessThanZero() {
		return 0;
	}
	
	private int getUpdatedQualityNumber(int quality) {
		return quality < 50 ? 1 : 0;
	}
	
}
