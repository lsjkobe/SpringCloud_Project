package com.leoli.md_server.dao.repositoryImpl;

import com.leoli.md_server.dao.Do.MdFileDo;
import com.leoli.md_server.model.repository.MdRepository;
import com.leoli.md_server.model.serviceImpl.dto.MdFileDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MdDbRepository implements MdRepository<MdFileDto> {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void save(MdFileDto mdFileDto) {
        MdFileDo mdFileDo = new MdFileDo();
        BeanUtils.copyProperties(mdFileDto, mdFileDo);
        mongoTemplate.save(mdFileDo);
    }

    @Override
    public MdFileDto findById(String id) {
        MdFileDo mdFileDo =  mongoTemplate.findById(id, MdFileDo.class);
        MdFileDto mdFileDto = null;
        if(mdFileDo != null){
            mdFileDto = new MdFileDto();
            BeanUtils.copyProperties(mdFileDo, mdFileDto);
        }
        return mdFileDto;
    }
}
