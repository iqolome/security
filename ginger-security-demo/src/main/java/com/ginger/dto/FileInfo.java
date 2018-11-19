/**
 * 
 */
package com.ginger.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 文件
 * @author 姜锋
 * @date 2018年3月2日 上午11:48:21 
 * @version V1.0   
 *
 */
public class FileInfo {
	
	@ApiModelProperty(value = "文件路径")
	private String path;

	/**
	 * @param path
	 */
	public FileInfo(String path) {
		super();
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
