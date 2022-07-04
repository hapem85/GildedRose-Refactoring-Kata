package com.gildedrose;

public abstract class ItemStateBehavior {
	
	public final Item item;
	
	public ItemStateBehavior(Item item) {
		this.item = item;
	}
	
	public void changeState() {
        item.quality = changedItemQuality();
        item.sellIn = changedItemSellIn(); 
        
        if(item.sellIn < 0) {
        	item.quality = changedItemQualityIfSellInLessThanZero();        	
        }
	}
	
	abstract int changedItemSellIn();
	
	abstract int changedItemQuality();
	
	abstract int changedItemQualityIfSellInLessThanZero();
}
