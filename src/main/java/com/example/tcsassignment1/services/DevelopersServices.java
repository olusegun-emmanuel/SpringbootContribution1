package com.example.tcsassignment1.services;

import com.example.tcsassignment1.entity.DevelopersEntity;
import com.example.tcsassignment1.model.DevelopersModel;
import com.example.tcsassignment1.repository.DevelopersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DevelopersServices {

    @Autowired
    DevelopersRepository developersRepository;

    public List<DevelopersModel> getAllDevelopers() {
        List<DevelopersModel> allDevelopers = new ArrayList<>();
        List<DevelopersEntity> developersEntity = developersRepository.findAll();
        for(DevelopersEntity singleDeveloper: developersEntity ) {
            DevelopersModel developer =  mapEntityToModel(singleDeveloper);
            allDevelopers.add(developer);
        }
        return allDevelopers;
    }


    public boolean createNewDeveloper(DevelopersModel developersModel){
        DevelopersEntity entityToMap = new DevelopersEntity();
        DevelopersEntity tradeEntity = developersRepository.save((mapModelToEntity(entityToMap, developersModel)));
        if(null != tradeEntity.toString())
            return true;

        return false;
    }

    public boolean updateDeveloper(DevelopersModel developersModel, Long id){
        DevelopersEntity entityToMap = developersRepository.getOne(id);
        DevelopersEntity developerEntity = developersRepository.save((mapModelAndEntity(entityToMap, developersModel)));
        if(null != developerEntity.toString())
            return true;
        return false;
    }

    public void deleteDeveloper(Long id){
        developersRepository.deleteById(id);
    }



    private DevelopersModel mapEntityToModel(DevelopersEntity developersEntity){
        DevelopersModel developersModel = new DevelopersModel();
        developersModel.setId(developersEntity.getId());
        developersModel.setName(developersEntity.getName());
        developersModel.setSkills(developersEntity.getSkills());
        return developersModel;
    }

    private DevelopersEntity mapModelToEntity(DevelopersEntity entityToMap, DevelopersModel developersmodel){
        DevelopersEntity developersEntity = new DevelopersEntity();
        developersEntity.setId(developersmodel.getId());
        developersEntity.setName(developersmodel.getName());
        developersEntity.setSkills(developersmodel.getSkills());
        return developersEntity;
    }

    private DevelopersEntity mapModelAndEntity(DevelopersEntity entityToMap, DevelopersModel developersmodel){
        DevelopersEntity developersEntity = new DevelopersEntity();
        developersEntity.setId(entityToMap.getId());
        if( (!entityToMap.getName().equals(developersmodel.getName())) & (null!= developersmodel.getName())){
            developersEntity.setName(developersmodel.getName());
        } else {
            developersEntity.setName(entityToMap.getName());
        }
        if( (!entityToMap.getSkills().equals(developersmodel.getSkills())) & (null!= developersmodel.getSkills())){
            developersEntity.setSkills(developersmodel.getSkills());
        } else {
            developersEntity.setSkills(entityToMap.getSkills());
        }
        return developersEntity;
    }
}
