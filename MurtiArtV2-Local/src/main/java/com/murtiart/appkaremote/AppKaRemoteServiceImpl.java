package com.murtiart.appkaremote;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;

@Service
public class AppKaRemoteServiceImpl implements AppKaRemoteService{

	@Autowired
	private AppKaRemoteRepository appKaRemoteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public AppKaRemoteDto createAppKaRemote(AppKaRemoteDto dto) {
		AppKaRemote appKaRemote = this.modelMapper.map(dto, AppKaRemote.class);
		AppKaRemote addedAppKaRemote = this.appKaRemoteRepository.save(appKaRemote);
		return this.modelMapper.map(addedAppKaRemote, AppKaRemoteDto.class);
	}

	@Override
	public AppKaRemoteDto updateAppKaRemote(AppKaRemoteDto dto, Integer appKaRemoteId) {
 
		AppKaRemote appKaRemote = this.appKaRemoteRepository.findById(appKaRemoteId).orElseThrow(() -> new ResourceNotFoundException("AppkaRemote", "id",appKaRemoteId));

		appKaRemote.setMessage(dto.getMessage());
		appKaRemote.setFroceUpdate(dto.getFroceUpdate());
		appKaRemote.setFreez(dto.getFreez());
		appKaRemote.setUrlMaker(dto.getUrlMaker()); 
		appKaRemote.setNoDataPlaceHolder(dto.getNoDataPlaceHolder()); 
		appKaRemote.setCurrency(dto.getCurrency()); 
		appKaRemote.setSupport(dto.getSupport());
		
		AppKaRemote saveAppKaRemote = this.appKaRemoteRepository.save(appKaRemote);
		return this.modelMapper.map(saveAppKaRemote, AppKaRemoteDto.class);
	}

	@Override
	public AppKaRemoteDto getAppKaRemote(Integer appKaRemoteId) {
		AppKaRemote appKaRemote = this.appKaRemoteRepository.findById(appKaRemoteId).orElseThrow(() -> new ResourceNotFoundException("AppkaRemote","id",appKaRemoteId));
		return this.modelMapper.map(appKaRemote, AppKaRemoteDto.class);
	}

	@Override
	public List<AppKaRemoteDto> getAll() {
		 return this.appKaRemoteRepository.findAll().stream().map((category) -> this.modelMapper.map(category, AppKaRemoteDto.class)).collect(Collectors.toList());
	}
}
