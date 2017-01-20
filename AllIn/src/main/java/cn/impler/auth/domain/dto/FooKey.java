package cn.impler.auth.domain.dto;

import javax.validation.constraints.NotNull;

/**
 * In Spring validation framework, there is no way to validate @PathVariable variables.
 * @PathVariable variables in RESTFUL URL always include the identifier information.
 * So I create the compromised class.
 * Add an extra FooKey parameter in Controller method, which needs @pathVariable variables validation.
 * For example:
 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
 * @ResponseBody
 * public JSONObject deleteById(@PathVariable K id, @Valid FooKey key, BindingResult validateRt){
 * 		if(validateRt.hasErrors()){
 *			// validation failure
 *		}else{
 *			// validation success
 *		}
 *	}
 *  
 * @author impler
 * @date 2017-01-20
 */
public class FooKey{
	// id
	@NotNull(message="{id}")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
