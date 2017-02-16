package cn.impler.auth.domain;

import cn.impler.auth.dto.ResourceTypeEnum;
import cn.impler.auth.dto.RequestMethodTypeEnum;

public class Resource extends BaseDomain {

	// resource name
	private String name;
	// resource description
	private String description;
	// resource url
	private String url;
	// resource type
	private ResourceTypeEnum type;
	// resource level
	private String level;
	// resource order
	private int order;
	// resource request type
	private RequestMethodTypeEnum method = RequestMethodTypeEnum.ALL;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RequestMethodTypeEnum getMethod() {
		return method;
	}

	public void setMethod(RequestMethodTypeEnum method) {
		this.method = method;
	}

	public ResourceTypeEnum getType() {
		return type;
	}

	public void setType(ResourceTypeEnum type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
