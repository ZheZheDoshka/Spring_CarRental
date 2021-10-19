package com.zhe.carrental.service.implementation;

import com.zhe.carrental.model.entity.RentForm;
import com.zhe.carrental.model.enums.ReviewStatus;
import com.zhe.carrental.service.RentFormService;
import org.springframework.stereotype.Service;

@Service
public class RentFormServiceImpl  implements RentFormService {
    @Override
    public void save(RentForm rentForm, String username, Long ID, String price) {
            rentForm.setStatus(ReviewStatus.INREVIEW);
            rentForm.setCarid(ID);
            rentForm.setUsername(username);
            rentForm.setPrice(price);
    }
}
