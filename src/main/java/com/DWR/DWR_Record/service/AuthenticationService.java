package com.DWR.DWR_Record.service;

import com.DWR.DWR_Record.response.AuthenticationResponse;

public interface AuthenticationService {

	AuthenticationResponse login(String loginId, String password);

}
