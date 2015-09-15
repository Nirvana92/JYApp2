package com.hf.energy.event;

import android.support.v4.app.Fragment;



public class CustomerQueryButtonClickEvent {

	private Fragment target;

	public CustomerQueryButtonClickEvent(Fragment target) {
		this.target = target;
	}

	/**
	 * @return the target
	 */
	public Fragment getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Fragment target) {
		this.target = target;
	}
	
	
	
}
