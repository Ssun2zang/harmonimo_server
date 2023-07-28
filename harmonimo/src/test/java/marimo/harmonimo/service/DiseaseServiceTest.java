package marimo.harmonimo.service;

import marimo.harmonimo.repository.DiseaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class DiseaseServiceTest {

    @Autowired DiseaseService memberService;
    @Autowired
    DiseaseRepository memberRepository;

    @Test
    void 병조회() {}



}