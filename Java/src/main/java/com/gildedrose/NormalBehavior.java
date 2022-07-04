package com.gildedrose;

public class NormalBehavior implements ItemStateBehavior {

	private Item item;
	
	public NormalBehavior(Item item) {
		this.item = item;
	}
	
	@Override
	public void maintainState() {
		//TODO implement the behaviors of this item
	}

}
