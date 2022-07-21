package com.murtiart.units;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murtiart.exceptions.ResourceNotFoundException;
import com.murtiart.product.Product;
import com.murtiart.variant.Variant;
import com.murtiart.variant.VariantRepository;

@Service
public class UnitsServiceImpl implements UnitsService {
	
	@Autowired
	private UnitsRepository unitsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
 

	@Override
	public List<UnitsDto> getDatas() {
		return  this.unitsRepository.findAll().stream().map((data) -> this.modelMapper.map(data, UnitsDto.class)).collect(Collectors.toList());
	}

	@Override
	public UnitsDto createData(UnitsDto dto) {
		Units units = this.modelMapper.map(dto, Units.class);
		Units saveUnits  = this.unitsRepository.save(units);
		return this.modelMapper.map(saveUnits, UnitsDto.class);
	}

	@Override
	public UnitsDto updateData(UnitsDto dto, Integer unitId) {
		Units units = this.unitsRepository.findById(unitId).orElseThrow(() -> new ResourceNotFoundException("Untis", "id",unitId));
		units.setValue(dto.getValue());
		units.setRemove(dto.getRemove());
		Units saveUnits = this.unitsRepository.save(units);
		return modelMapper.map(saveUnits, UnitsDto.class);
	}

	@Override
	public UnitsDto deleteData(Integer unitId, Integer remove) {
		Units units = this.unitsRepository.findById(unitId).orElseThrow(() -> new ResourceNotFoundException("Units","id",unitId));
		units.setRemove(remove==1);
		Units saveUnits = this.unitsRepository.save(units);
		return modelMapper.map(saveUnits, UnitsDto.class);
	}

	@Override
	public UnitsDto getData(Integer unitId) {
		Units units = this.unitsRepository.findById(unitId).orElseThrow(() -> new ResourceNotFoundException("Units","id",unitId));
		return this.modelMapper.map(units, UnitsDto.class);
	}

}
