package cn.impler.auth.domain;

import cn.impler.auth.dto.RequestMethodTypeEnum;
import cn.impler.auth.dto.ResourceTypeEnum;
import cn.impler.auth.dto.ResourceUrlStyleEnum;

public class Resource extends BaseDomain {

	// resource name
	private String name;
	// resource description
	private String description;
	// resource type: menu/link
	private ResourceTypeEnum type;
	// actual url
	private String url;
	// url type: literal/ant
	private ResourceUrlStyleEnum style = ResourceUrlStyleEnum.LITERAL;
	// resource level
	private String level;
	// resource seq
	private int seq;
	// resource request type: post/get/delete/put...
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

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ResourceUrlStyleEnum getStyle() {
		return style;
	}

	public void setStyle(ResourceUrlStyleEnum style) {
		this.style = style;
	}

	public String getPermissionString() {
		StringBuffer sb = new StringBuffer(this.url);
		if (null == this.method) {
			this.method = RequestMethodTypeEnum.ALL;
		}
		sb.append(this.method.getAction());
		return sb.toString();
	}
}
