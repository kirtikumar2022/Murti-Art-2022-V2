package com.murtiart.appkaremote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murtiart.utils.GenericApiRespons;
import com.murtiart.utils.JsonKeysManageGlobally;


@RestController
@RequestMapping("/api/remotecontrol")
public class AppKaRemoteController {
	
	@Autowired
	AppKaRemoteService appKaRemoteService;
	
	@PostMapping("")
	public GenericApiRespons<AppKaRemoteDto> createAppKaRemote(@RequestBody AppKaRemoteDto dto){
		AppKaRemoteDto data = this.appKaRemoteService.createAppKaRemote(dto);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.CREATED, JsonKeysManageGlobally.OK);
	}
 
	@PutMapping("/{id}")
	public GenericApiRespons<AppKaRemoteDto> updateAppKaRemote(@RequestBody AppKaRemoteDto dto, @PathVariable Integer id) {
		AppKaRemoteDto data = this.appKaRemoteService.updateAppKaRemote(dto, id);
		return JsonKeysManageGlobally.standaredResponseBuilder(data,StringConstants.UPDATED, JsonKeysManageGlobally.OK);
	}
	

	@GetMapping("")
	public GenericApiRespons<List<AppKaRemoteDto>> getAppKaRemotes(){
		List<AppKaRemoteDto> list = this.appKaRemoteService.getAll();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
	
	@GetMapping("/{id}")
	public GenericApiRespons<List<AppKaRemoteDto>> getAppKaRemote(){
		List<AppKaRemoteDto> list = this.appKaRemoteService.getAll();
		return JsonKeysManageGlobally.standaredResponseBuilder(list,StringConstants.FOUND, JsonKeysManageGlobally.OK);
	}
}
