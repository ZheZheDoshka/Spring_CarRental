package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.Car;
import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.enums.ReviewStatus;
import com.zhe.carrental.repository.RentFormRepository;
import com.zhe.carrental.service.RentFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentFormServiceImpl  implements RentFormService {

    @Autowired
    RentFormRepository rentFormRepository;

    @Override
    public void save(RentForm rentForm, String username, Long ID, String price) {
            rentForm.setStatus(ReviewStatus.INREVIEW);
            rentForm.setCarid(ID);
            rentForm.setUsername(username);
            rentForm.setPrice(price);
            rentFormRepository.save(rentForm);
    }

    @Override
    public List<RentForm> findAllForms() {
        List<RentForm> forms = rentFormRepository.findAll();
        return forms;
    }

    @Override
    public List<RentForm> findFormsByUsername(String Username) {
        List<RentForm> forms = new ArrayList<RentForm>();
        List<RentForm> allforms = findAllForms();
        for (int i = 0; i<allforms.size(); i++)
        {
            if (allforms.get(i).getUsername().equals(Username))
            {
                forms.add(allforms.get(i));
            }
        }
        return forms;
    }

    @Override
    public RentForm findById(Long id) {
        return rentFormRepository.findById(id).get();
    }
}
