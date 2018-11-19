/**
 * 
 */
package com.ginger.security.core.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.ginger.security.core.validate.code.ValidateCode;

/**
 * @Description: 图形验证码 
 * @author 姜锋
 * @date 2018年4月12日 下午11:08:11 
 * @version V1.0   
 *
 */
public class ImageCode extends ValidateCode{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7326673592705706678L;
	//图片
	private BufferedImage image;
	public ImageCode(BufferedImage image, String code, int expireIn) {
		super(code,expireIn);
		this.image = image;
	}

	/**
	 * @param image
	 * @param code
	 * @param expireTime
	 */
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code,expireTime);
		this.image = image;
	}
	/**
	 * @return image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image 要设置的 image
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
