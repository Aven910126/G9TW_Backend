package com.example.GuideCane.service;

import com.example.GuideCane.dto.EmergencyContactDTO;
import com.example.GuideCane.model.Account;
import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.model.HeartBeat;
import com.example.GuideCane.repository.AccountRepository;
import com.example.GuideCane.repository.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmergencyContactService {
    @Autowired
    private EmergencyContactRepository emergencyContactRepository;
    @Autowired
    private AccountRepository accountRepository;

   public EmergencyContact createEmergencyContact(EmergencyContactDTO emergencyContactDTO){
       String contactPerson=emergencyContactDTO.getContactPerson();
       String contactNo=emergencyContactDTO.getContactNo();
       Optional<Account> deviceCode=accountRepository.findById(emergencyContactDTO.getDeviceCode());
       String relationship=emergencyContactDTO.getRelationship();
       if(emergencyContactRepository.findOneByRelationshipAndDeviceCode(relationship,deviceCode)!=null){
           return null;
       }else{
           if(deviceCode!=null){
               EmergencyContact emergencyContact = emergencyContactRepository.save(new EmergencyContact(deviceCode.get(),contactPerson,contactNo,relationship));
               return emergencyContact;
           }
           else{
               return null;
           }
       }
   }

    public List<EmergencyContact> findAllEmergencyContact(long devicecode){
        Optional<Account> data = accountRepository.findById(devicecode);
        List<EmergencyContact> listdata;
        if(data.isPresent()){
            listdata = emergencyContactRepository.findByDeviceCode(data.get());

        }
        else {
            listdata = new ArrayList<>();
        }
        return listdata;
    }


}
