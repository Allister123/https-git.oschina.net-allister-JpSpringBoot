/**
 * 
 */

package com.ic2c.bean;

import java.util.Date;

/**
 * 
 * 
 * User 
 * 创建人:刘继鹏 
 * 时间：2016年1月7日-下午10:20:47
 * 
 * @version 1.0.0
 * 
 */
public class User implements java.io.Serializable{

	/**
	 * serialVersionUID:TODO
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	// 主键ID
	private Integer id;
	// 用户名
	private String username;
	// 密码
	private String password;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 1允许登录 0禁止登陆
	private Integer forbiden;
	// 删除状态 0未删除 1删除
	private Integer isDelete;
	// 邮箱
	private String email;
	// 电话
	private String telephone;
	// 年龄
	private Integer age;
	// 地址
	private String address;
	// 性别 1男 0女
	private Integer male;
	// 生日
	private Date birthday;
	// 头像
	private String headerPic;
	//问题一
	private Integer questionOne;
	//问题二
	private Integer questionTwo;
	//问题一答案
	private String answerOne;
	//问题二答案
	private String answerTwo;
	
	/**
	 * 临时字段（用户导出Excel）
	 */
	private String deleteName = "未删除";//删除状态
	private String forbidenName = "允许";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getForbiden() {
		return forbiden;
	}

	public void setForbiden(Integer forbiden) {
		this.forbiden = forbiden;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}

	public Integer getQuestionOne() {
		return questionOne;
	}

	public void setQuestionOne(Integer questionOne) {
		this.questionOne = questionOne;
	}

	public Integer getQuestionTwo() {
		return questionTwo;
	}

	public void setQuestionTwo(Integer questionTwo) {
		this.questionTwo = questionTwo;
	}

	public String getAnswerOne() {
		return answerOne;
	}

	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}

	public String getAnswerTwo() {
		return answerTwo;
	}

	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}

	public String getDeleteName() {
		return deleteName;
	}

	public void setDeleteName(String deleteName) {
		this.deleteName = deleteName;
	}

	public String getForbidenName() {
		return forbidenName;
	}

	public void setForbidenName(String forbidenName) {
		this.forbidenName = forbidenName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
