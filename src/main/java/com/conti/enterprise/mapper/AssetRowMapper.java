/**
 * 
 */
package com.conti.enterprise.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.conti.enterprise.model.AssetDTO;

/**
 * @author Vikas Siva Ravindran
 *
 */
public class AssetRowMapper implements RowMapper<AssetDTO>, Serializable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public AssetDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AssetDTO asset = new AssetDTO();
		asset.setId(rs.getInt(1));
		return asset;
	}

}
