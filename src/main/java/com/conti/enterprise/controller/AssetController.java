/**
 * 
 */
package com.conti.enterprise.controller;

import java.io.IOException;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conti.enterprise.model.AssetDTO;
import com.conti.enterprise.model.Message;
import com.conti.enterprise.service.AssetService;

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

	@Autowired
	private AssetService assetService;

	@PutMapping(value = "/hardware/hpam/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void updateHpamReference(@PathVariable int id) {
		logger.info("The Asset ID to be updated is:{}", id);
		assetService.updateReference(id);

	}

	@PostMapping(value = "/hardware", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void createnewAsset(@RequestBody AssetDTO asset) {
		logger.info("The Model ID of Asset is:{}", asset.getModel_id());
		assetService.createAsset(asset);
	}

	@GetMapping(value = "/import/details")
	public String importDetails() throws IOException {
		String text = assetService.importDetailstoCSVFile();
		return text;
	}

}
