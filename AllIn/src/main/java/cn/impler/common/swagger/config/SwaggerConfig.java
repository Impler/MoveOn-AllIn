package cn.impler.common.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns(".*?");
	}

	private ExtensionApiInfo apiInfo() {
		ExtensionApiInfo apiInfo = new ExtensionApiInfo("AllIn APIS", "AllIn APIS",
				"My Apps API terms of service", "704090860@qq.com",
				"My Apps API Licence Type", "My Apps API License URL", 
				".do");
		return apiInfo;
	}
	
	/**
	 * Extension of ApiInfo that add a urlSuffix parameter to fit specific request url pattern
	 * @author impler
	 * @date 2016-12-14
	 */
	class ExtensionApiInfo extends ApiInfo{

		private String urlSuffix = "";
		public ExtensionApiInfo(String title, String description,
				String termsOfServiceUrl, String contact, String license,
				String licenseUrl) {
			super(title, description, termsOfServiceUrl, contact, license, licenseUrl);
		}
		
		public ExtensionApiInfo(String title, String description,
				String termsOfServiceUrl, String contact, String license,
				String licenseUrl, String urlSuffix) {
			super(title, description, termsOfServiceUrl, contact, license,
					licenseUrl);
			this.urlSuffix = urlSuffix;
		}

		public String getUrlSuffix() {
			return urlSuffix;
		}

		public void setUrlSuffix(String urlSuffix) {
			this.urlSuffix = urlSuffix;
		}
	}

}