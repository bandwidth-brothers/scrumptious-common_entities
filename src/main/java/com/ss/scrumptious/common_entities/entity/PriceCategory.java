package com.ss.scrumptious.common_entities.entity;

public enum PriceCategory {
	$(1),
	$$(2),
	$$$(3);

	private final Integer priceCategory;

	PriceCategory(Integer priceCategory) {
		this.priceCategory = priceCategory;
	}

	public Integer getPriceLevel() {
		return priceCategory;
	}

	public String getPriceCategory() {
		switch(priceCategory) {
		case 1:
			return "$";
		case 2:
			return "$$";
		case 3:
			return "$$$";
		default:
			return "$";
		}
	}
}
