/**
 * 
 */
package com.ginger.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ginger.dto.FileInfo;

/**
 * @Description: 文件服务
 * @author 姜锋
 * @date 2018年3月2日 上午11:46:02
 * @version V1.0
 */
@RestController
@RequestMapping("/file")
public class FileController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private String folder = "D:\\Download";

	@PostMapping
	public FileInfo upload(MultipartFile file) throws Exception {
		logger.info("输出文件名" + file.getName());
		logger.info("输出原始文件名" + file.getOriginalFilename());
		logger.info("输出文件大小" + file.getSize());
		// 存放地址
		File localFile = new File(folder, new Date().getTime() + ".txt");
		file.transferTo(localFile);
		// 可讲文件输出
		// file.getInputStream();
		return new FileInfo(localFile.getAbsolutePath());
	}
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try (InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
				OutputStream onputStream = response.getOutputStream();) {
			
			response.setContentType("application/x-download");
			//定义下载时的名称
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");
			IOUtils.copy(inputStream, onputStream);
			onputStream.flush();
		}
		
	}
}
