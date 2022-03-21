/**
 * 
 */
package com.lt.restController;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author user218
 *
 */
public class CRSApplication extends ResourceConfig {

	public CRSApplication() {

		register(CRSStudentAPI.class);
		//register(UserRestAPI.class);
		//register(ProfessorRestAPI.class);
		//register(AdminRestAPI.class);

		}
}
