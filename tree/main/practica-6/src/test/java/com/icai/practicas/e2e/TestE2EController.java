package com.icai.practicas.e2e;

import com.icai.practicas.controller.ProcessController;
import com.icai.practicas.controller.ResponseHTMLGenerator;

import com.icai.practicas.controller.ProcessController.DataRequest;
import com.icai.practicas.controller.ProcessController.DataResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestE2EController {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    
    @Test
    public void testing_processController_step1_then_ok(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
		DataRequest dataRequest = new DataRequest("Calamardo", "38937498Q", "666666666");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

		//When
		ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

		//Then
		DataResponse expectedResponse = new DataResponse("OK");

		then(result.getBody().result()).isEqualTo("OK");
		then(result.getBody()).isEqualTo(expectedResponse);

    }

    @Test
    public void testing_processController_step1_then_ko(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";
		DataRequest dataRequest = new DataRequest("Rafael Palacios", "0383EE69E", "78e83877777777");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(dataRequest, headers);

        //When
		ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);


		//Then
		DataResponse expectedResponse = new DataResponse("KO");

		then(result.getBody().result()).isEqualTo("KO");
		then(result.getBody()).isEqualTo(expectedResponse);

    }

    @Test
    public void testing_processController_step1__legacy_then_ok(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
		MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add("fullName", "Benito Camela");
        data.add("dni", "39075520S");
        data.add("telefono", "612345678");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        //When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

		//Then
        then(result.getBody()).isEqualTo(ResponseHTMLGenerator.message1);
        
    }

    @Test
    public void testing_processController_step1__legacy_then_ko(){
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
		MultiValueMap<String, String> data = new LinkedMultiValueMap<String, String>();
        data.add("fullName", "Tomas Turbado");
        data.add("dni", "777373737");
        data.add("telefono", "801358jeje");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        //When
		ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

		//Then
        then(result.getBody()).isEqualTo(ResponseHTMLGenerator.message2);
        
    }
    
}
