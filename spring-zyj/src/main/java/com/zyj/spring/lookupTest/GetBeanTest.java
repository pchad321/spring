package com.zyj.spring.lookupTest;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class GetBeanTest {
	public void show() {
		this.getBean().show();
	}

	@Lookup
	public abstract User getBean();
}
