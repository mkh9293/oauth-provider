package com.mkh.oauthdevelopers.service;

import com.mkh.oauthdevelopers.domain.App;
import com.mkh.oauthdevelopers.repository.AppRepository;
import com.mkh.oauthdevelopers.service.dto.AppDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private final Logger log = LoggerFactory.getLogger(AppService.class);

    @Autowired
    private AppRepository appRepository;

    public App createApp(AppDTO appDTO) {
        App app = new App();
        app.setClientId(appDTO.getClientId());
        app.setClientSecret(appDTO.getClientSecret());
        app.setAdditionalInformation(appDTO.getAdditionalInformation());
        appRepository.save(app);

        log.debug("Created Information for App: {}", app);
        return app;
    }
}
