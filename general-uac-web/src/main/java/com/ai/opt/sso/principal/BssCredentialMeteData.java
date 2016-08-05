package com.ai.opt.sso.principal;

import org.jasig.cas.authentication.BasicCredentialMetaData;
import org.jasig.cas.authentication.Credential;

public class BssCredentialMeteData extends BasicCredentialMetaData {

	private final String id ;
	private static final long serialVersionUID = -3138330953787887464L;
	
	public BssCredentialMeteData(Credential credential) {
		super(credential);
		BssCredentials credentials = (BssCredentials) credential;
		this.id = credentials.getUsername();
	}

	@Override
	public String getId() {
		return this.id;
	}
}
