/**
 * 
 */
package com.conti.enterprise.controller;

import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.conti.enterprise.model.Asset;
import com.conti.enterprise.model.AssetDTO;

/**
 * @author Vikas Siva Ravindran
 *
 */
@Configuration
@RestController
@RequestMapping("/api")
public class AssetController {

	private static final Logger logger = LoggerFactory.getLogger(AssetController.class);

	@Value("${snipeit.application.token}")
	private String API_Token;

	@Value("${snipeit.application.url}")
	private String URL;

	/*
	 * @Autowired private AssetService assetService;
	 */
	private RestTemplate restTemplate = new RestTemplate();

	private HttpHeaders httpheaders = new HttpHeaders();

	@GetMapping(value = "/hardware/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Object getHardwareAsset(@PathVariable int id) {

		httpheaders.setContentType(MediaType.APPLICATION_JSON);
		httpheaders.set("Authorization", "Bearer " + API_Token);
		HttpEntity<Asset> entity = new HttpEntity<>(httpheaders);
		ResponseEntity<Asset> response = restTemplate.exchange(URL + "/hardware/" + id, HttpMethod.GET, entity,
				Asset.class);
		logger.info("The Asset Details are:::{}", response.getBody().getAsset_tag());
		logger.info("The Asset Values are:::{}", response.getBody().getName());
		logger.info("The Status ID:{}", response.getBody().getStatus_label().getId());
		logger.info("The Model ID:{}", response.getBody().getModel().getId());
		logger.info("The Asset HPAM Specific Details are:{},{}",
				response.getBody().getCustomFields().getHPAMReference().getField(),
				response.getBody().getCustomFields().getHPAMReference().getValue());
		return response;
	}

	/*
	 * JPA PERSISTENCE METHOD
	 * 
	 * @GetMapping(value= "/hardware/id/{id}" ,
	 * produces=MediaType.APPLICATION_JSON_UTF8_VALUE) public Object
	 * getHardwareDetailsbyId(@PathVariable int id){ return
	 * assetService.getAssetDetailsbyId(id); }
	 */

	@GetMapping(value = "/hardware/hpam/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void updateHpamReference(@PathVariable int id) {

		httpheaders.setContentType(MediaType.APPLICATION_JSON);
		httpheaders.set("Authorization", "Bearer " + API_Token);
		HttpEntity<Asset> entity = new HttpEntity<>(httpheaders);
		ResponseEntity<Asset> response = restTemplate.exchange(URL + "/hardware/" + id, HttpMethod.GET, entity,
				Asset.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + API_Token);
		headers.set("Accept", "application/json");

		// Code to generate Random HPAM ID
		RandomStringGenerator g = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(Character::isLetterOrDigit).build();

		String hpam_reference_id = g.generate(6).toUpperCase();

		AssetDTO createdAsset = new AssetDTO();
		createdAsset.setId(response.getBody().getId());
		createdAsset.setName(response.getBody().getName());
		createdAsset.setAsset_tag(response.getBody().getAsset_tag());
		createdAsset.setSerial(response.getBody().getSerial());
		createdAsset.set_snipeit_hpam_reference_3(hpam_reference_id);
		createdAsset.setStatus_id(response.getBody().getStatus_label().getId());
		createdAsset.setModel_id(response.getBody().getModel().getId());
		HttpEntity<AssetDTO> assetEntity = new HttpEntity<AssetDTO>(createdAsset, headers);
		ResponseEntity<AssetDTO> details = restTemplate.exchange(URL + "/hardware/" + id, HttpMethod.PUT, assetEntity,
				AssetDTO.class);
	}
}
