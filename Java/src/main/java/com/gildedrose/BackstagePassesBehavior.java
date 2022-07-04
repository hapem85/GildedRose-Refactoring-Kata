package com.gildedrose;

public class BackstagePassesBehavior implements ItemStateBehavior {
	private Item item;
	
	public BackstagePassesBehavior(Item item) {
		this.item = item;
	}
	
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
