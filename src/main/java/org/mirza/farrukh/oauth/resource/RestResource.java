/*
 * {{{ header & license
 * 
 *    Copyright 2018 Farrukh Mirza
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * }}}
 */

/**
 * @author Farrukh Mirza
 * @date 20 April 2018
 * The class name can never be ResourceServer
 */
package org.mirza.farrukh.oauth.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestResource {
//	@Primary
//	@Bean
//	public RemoteTokenServices tokenService() {
//	    RemoteTokenServices tokenService = new RemoteTokenServices();
//	    tokenService.setCheckTokenEndpointUrl(
//	      "http://localhost:8080/oauth/check_token");
//	    tokenService.setClientId("acme");
//	    tokenService.setClientSecret("acmesecret");
//	    return tokenService;
//	}
	
//	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping("secure")
	public String getAuthorizedData(){
		return "Authorized Data";
	}
	
//	@RequestMapping("unsecure")
//	public String getUnAuthorizedData(){
//		return "Unauthorized Data";
//	}
}
