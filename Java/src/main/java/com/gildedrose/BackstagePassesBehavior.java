package com.gildedrose;

public class BackstagePassesBehavior implements ItemStateBehavior {
	private Item item;
	
	public BackstagePassesBehavior(Item item) {
		this.item = item;
	}
	
	/**
	 * Backstage passes increases in Quality the older it gets
	 * Quality increases by 2 when there are 10 days or less
	 * by 3 when there are 5 days or less
	 * Quality drops to 0 after the concert
	 * The Quality of an item is never more than 50
	 */
	@Override
	public void maintainState() {
		this.item.quality += this.getNumberOfQualityToUpdate();
		
		if (this.item.sellIn < 11) {
			this.item.quality += this.getNumberOfQualityToUpdate();
        }

        if (this.item.sellIn < 6) {
        	this.item.quality += this.getNumberOfQualityToUpdate();
        }
        
        this.item.sellIn -= 1;
        
        if(this.item.sellIn < 0) {
        	this.item.quality = 0;
        }
	}

	private int getNumberOfQualityToUpdate() {
		return this.item.quality < 50 ? 1 : 0;
	}
	
}
