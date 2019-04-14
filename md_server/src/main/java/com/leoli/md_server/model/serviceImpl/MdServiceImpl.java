package com.leoli.md_server.model.serviceImpl;

import com.leoli.md_server.controller.vo.MdFileVo;
import com.leoli.md_server.model.repository.MdRepository;
import com.leoli.md_server.model.service.MdService;
import com.leoli.md_server.model.serviceImpl.dto.MdFileDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
public class MdServiceImpl implements MdService<MdFileVo> {

    @Autowired
    MdRepository<MdFileDto> mdRepository;

    @Override
    public void save(MdFileVo mdFileVo) {
        MdFileDto mdFileDto = new MdFileDto();
        BeanUtils.copyProperties(mdFileVo, mdFileDto);
        if(StringUtils.isEmpty(mdFileDto.getId())){
            mdFileDto.setId(UUID.randomUUID().toString());
        }
        mdRepository.save(mdFileDto);
    }

    @Override
    public MdFileVo findbyId(String id) {
        MdFileDto mdFileDto = mdRepository.findById(id);
        MdFileVo mdFileVo = new MdFileVo();
        BeanUtils.copyProperties(mdFileDto, mdFileVo);
        return mdFileVo;
    }
}
