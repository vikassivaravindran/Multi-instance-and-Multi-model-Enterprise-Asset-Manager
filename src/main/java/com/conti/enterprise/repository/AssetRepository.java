/**
 * 
 */
package com.conti.enterprise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conti.enterprise.model.AssetDTO;

/**
 * @author Vikas Siva Ravindran
 *
 */
public interface AssetRepository extends JpaRepository<AssetDTO, Integer>{

}
