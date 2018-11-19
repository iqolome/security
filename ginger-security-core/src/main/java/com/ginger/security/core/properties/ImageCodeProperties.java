/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 图形验证码配置
 * @author 姜锋
 * @date 2018年4月13日 上午11:10:13 
 * @version V1.0   
 *
 */
public class ImageCodeProperties  extends SmsCodeProperties{
	
	
	
	/**
	 * @param width
	 * @param height
	 */
	public ImageCodeProperties() {
		setLength(4);
	}
	/**
	 * 图片宽
	 */
	private int width = 67;
	/**
	 * 图片高
	 */
	private int height = 23;
	/**
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width 要设置的 width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height 要设置的 height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return length
	 */
	
	
}
