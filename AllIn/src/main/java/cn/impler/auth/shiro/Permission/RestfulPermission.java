package cn.impler.auth.shiro.Permission;

import java.io.Serializable;

import org.apache.shiro.authz.Permission;

import cn.impler.auth.domain.Resource;

public class RestfulPermission implements Permission, Serializable{

	private static final long serialVersionUID = 5695137306899909695L;
	
	private final Resource resource;

	public RestfulPermission(Resource r) {
		this.resource = r;
	}

	@Override
	public boolean implies(Permission p) {
		
		return false; 
	}

}
