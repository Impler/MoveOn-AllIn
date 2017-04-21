package cn.impler.auth.domain.dto;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;

import cn.impler.auth.dto.ResourceUrlTypeEnum;

public class Url {

	// actual url
	private String url;
	// url type
	private ResourceUrlTypeEnum type;
	// matching string
	private String matching;

	public Url() {
		super();
	}

	public Url(String url, ResourceUrlTypeEnum type) {
		super();
		this.url = url;
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ResourceUrlTypeEnum getType() {
		return type;
	}

	public void setType(ResourceUrlTypeEnum type) {
		this.type = type;
	}

	public String getMatching() {
		return matching;
	}

	public void setMatching(String matching) {
		this.matching = matching;
	}

	public boolean match(String requestURI) {
		
		if (StringUtils.isBlank(this.url)
				|| ResourceUrlTypeEnum.ANT != this.type) {
			return false;
		}

		AntPathMatcher matcher = new AntPathMatcher();
		return matcher.match(this.url, requestURI);
	}

}
