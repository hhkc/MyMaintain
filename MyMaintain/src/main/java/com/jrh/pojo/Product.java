package com.jrh.pojo;

public class Product {

	private String lot_id;

	private String qty1;
	
	private String instance_id;
	
	private String instance_desc;
	
	private String created_timestamp;

	private String lot_status;
	
	public String getLot_id() {
		return lot_id;
	}

	public void setLot_id(String lot_id) {
		this.lot_id = lot_id;
	}

	
	public String getInstance_id() {
		return instance_id;
	}

	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}

	public String getQty1() {
		return qty1;
	}

	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}

	public String getInstance_desc() {
		return instance_desc;
	}

	public void setInstance_desc(String instance_desc) {
		this.instance_desc = instance_desc;
	}

	public String getCreated_timestamp() {
		return created_timestamp;
	}

	public void setCreated_timestamp(String created_timestamp) {
		this.created_timestamp = created_timestamp;
	}

	public String getLot_status() {
		return lot_status;
	}

	public void setLot_status(String lot_status) {
		this.lot_status = lot_status;
	}

	@Override
	public String toString() {
		return "Product [lot_id=" + lot_id + ", qty1=" + qty1 + ", instance_id=" + instance_id + ", instance_desc="
				+ instance_desc + ", created_timestamp=" + created_timestamp + ", lot_status=" + lot_status + "]";
	}

}
