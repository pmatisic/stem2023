package org.foi.stem.longschlong.Services;

import org.foi.stem.longschlong.Repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;
}
