package com.murtiart.appkaremote;

import java.util.List;

public interface AppKaRemoteService {

	AppKaRemoteDto createAppKaRemote(AppKaRemoteDto dto);

	AppKaRemoteDto updateAppKaRemote(AppKaRemoteDto dto, Integer appKaRemoteId);
	
	AppKaRemoteDto getAppKaRemote(Integer appKaRemoteId);	
	
	List<AppKaRemoteDto> getAll();	
	
}
