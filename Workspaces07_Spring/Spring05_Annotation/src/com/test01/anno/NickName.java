package com.test01.anno;

import org.springframework.stereotype.Component;

// NickName nickName = new NickName();
// <bean id="nickName" class="com.test01.anno.NickName">
@Component
public class NickName {
	
	@Override
	public String toString() {
		return "씨네";
	}

}
