/**
 * 
 */
package com.ginger.cim.spring.jdbc;

/**
 * @Description: SQL返回集
 * @author 姜锋
 * @date 2018年9月26日 下午1:50:26 
 * @version V1.0   
 *
 */
public class CimSQLResult {
	private String name;
	private Double lng;
	private Double lat;
	private String address;
	private String type_;
	private String type2;
	private String type3;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return lng
	 */
	public Double getLng() {
		return lng;
	}
	/**
	 * @param lng 要设置的 lng
	 */
	public void setLng(Double lng) {
		this.lng = lng;
	}
	/**
	 * @return lat
	 */
	public Double getLat() {
		return lat;
	}
	/**
	 * @param lat 要设置的 lat
	 */
	public void setLat(Double lat) {
		this.lat = lat;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return type_
	 */
	public String getType_() {
		return type_;
	}
	/**
	 * @param type_ 要设置的 type_
	 */
	public void setType_(String type_) {
		this.type_ = type_;
	}
	/**
	 * @return type2
	 */
	public String getType2() {
		return type2;
	}
	/**
	 * @param type2 要设置的 type2
	 */
	public void setType2(String type2) {
		this.type2 = type2;
	}
	/**
	 * @return type3
	 */
	public String getType3() {
		return type3;
	}
	/**
	 * @param type3 要设置的 type3
	 */
	public void setType3(String type3) {
		this.type3 = type3;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CimSQLResult [name=" + name + ", lng=" + lng + ", lat=" + lat + ", address=" + address + ", type_="
				+ type_ + ", type2=" + type2 + ", type3=" + type3 + ", getName()=" + getName() + ", getLng()="
				+ getLng() + ", getLat()=" + getLat() + ", getAddress()=" + getAddress() + ", getType_()=" + getType_()
				+ ", getType2()=" + getType2() + ", getType3()=" + getType3() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
