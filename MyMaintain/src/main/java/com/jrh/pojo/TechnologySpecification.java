package com.jrh.pojo;

public class TechnologySpecification {

	private String instance_id;
	
	private String EPILAYER_TEXTURE;
	
	private String EPI_CARRIER;

	public String getInstance_id() {
		return instance_id;
	}

	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}

	public String getEPILAYER_TEXTURE() {
		return EPILAYER_TEXTURE;
	}

	public void setEPILAYER_TEXTURE(String ePILAYER_TEXTURE) {
		EPILAYER_TEXTURE = ePILAYER_TEXTURE;
	}

	public String getEPI_CARRIER() {
		return EPI_CARRIER;
	}

	public void setEPI_CARRIER(String ePI_CARRIER) {
		EPI_CARRIER = ePI_CARRIER;
	}

	@Override
	public String toString() {
		return "TechnologySpecification [instance_id=" + instance_id + ", EPILAYER_TEXTURE=" + EPILAYER_TEXTURE
				+ ", EPI_CARRIER=" + EPI_CARRIER + "]";
	}

	
	
	
	
	
}
