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
 * 
 * Help 1: http://www.baeldung.com/rest-api-spring-oauth2-angularjs
 * Help 2: https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html
 * 
 * Spring Profiles
 * 	1. https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html
 * 	2. https://stackoverflow.com/questions/31038250/setting-active-profile-and-config-location-from-command-line-in-spring-boot?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
 * 	3. Activate profile from terminal <code>java -jar -Dspring.profiles.active={profile name} target\oauth-server.jar</code> e.g., <code>java -jar -Dspring.profiles.active=PRODUCTION target\oauth-server.jar</code>
 * 	4. Via docker container: <code>$ docker run -e "SPRING_PROFILES_ACTIVE=PRODUCTION" -p 8080:8080 -t clientsolutions/oauth-server</code>
 */

package org.mirza.farrukh.oauth;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
