/**
 * 
 */
package com.ginger.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import com.fasterxml.jackson.annotation.JsonView;
import com.ginger.dto.User;
import com.ginger.dto.UserQueryCondition;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @Description: 用户访问控制
 * @author 姜锋
 * @date 2018年4月10日 上午8:28:37 
 * @version V1.0   
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	/**
	 * Browser登录工具
	 */
	@Autowired
	private ProviderSignInUtils providerSignInUtils;
	/**
	 * APP登录工具
	 */
	/*@Autowired
	private AppSignUpUtils AppSignUpUtils;*/
	
	/*@Autowired
	private SecurityProperties securityProperties;*/
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping("/regist")
	public void regist(User user, HttpServletRequest request) {
		//不管是注册用户还是绑定用户,都会拿到一个用户的唯一标示
		String userId = user.getUsername();
		// TODO 具体的用户注册 数据库操作 省略.....
		/**
		 * 用于Browser的注册
		 */
		providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
		/**
		 * 用于App的注册
		 */
		//AppSignUpUtils.doPostSignUp(new ServletWebRequest(request), userId);
	}
	
	/**
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 * @throws SignatureException 
	 * @throws MalformedJwtException 
	 * @throws UnsupportedJwtException 
	 * @throws ExpiredJwtException 
	 * 
	 * @Description: 获取认证信息
	 * @author 姜锋
	 * @date 2018年4月12日 下午5:53:03
	 * @param @return
	 * @return Object
	 * @throws
	 */
	
	@GetMapping("/me")
	public  Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
			return user;
	}
	/**
	 * 
	 * @Description: APP获取用户信息
	 * @author 姜锋
	 * @date 2018年10月14日 上午8:21:33
	 * @param @param condition
	 * @param @param pageable
	 * @param @return
	 * @return List<User>
	 * @throws
	 */
	/*public  Object getCurrentUser(Authentication authentication, HttpServletRequest request) throws Exception {
		
		String header = request.getHeader("Authorization");
		String token = StringUtils.substringAfter(header,"bearer ");
		Claims claims = 
		Jwts
			.parser()
			.setSigningKey(securityProperties.getOauth2().getJwtSigningKey().getBytes("UTF-8"))
			.parseClaimsJws(token).getBody();
		String company = (String) claims.get("company");
		String developer = (String) claims.get("developer");
		
		logger.info("company: "+company);
		logger.info("developer: "+developer);
		return authentication;
	}
	*/
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	@ApiOperation(value = "条件查询用户")
	public List<User> query(UserQueryCondition condition, @PageableDefault(size = 20)Pageable pageable){
		
		logger.info(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		logger.info(String.valueOf(pageable.getPageSize()));
		logger.info(String.valueOf(pageable.getPageNumber()));
		logger.info(String.valueOf(pageable.getSort()));
		
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	@GetMapping(value ="/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	@ApiOperation(value = "获取用户详情")
	public User getInfo(@ApiParam(value = "用户编号") @PathVariable(name = "id") String id){
		logger.info("进入getInfo服务");
		User user = new User();
		user.setUsername("ginger");
		return user;
		//throw new UserNotExistExcetion(id);
		
	}
	
	@PostMapping
	@JsonView(User.UserDetailView.class)
	@ApiOperation(value = "创建用户")
	public User create(@Valid @RequestBody User user){
	//public User create(@Valid @RequestBody User user, BindingResult errors){
		/*if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}*/
		logger.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		user.setId("1");
		return user;
	}
	
	@PutMapping("/{id:\\d+}")
	@ApiOperation(value = "更新用户信息")
	public User update(@Valid @RequestBody User user, BindingResult errors){
		if(errors.hasErrors()) {
			errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		/*  可打印出所对应的字段
		  		errors.getAllErrors().stream().forEach(error -> {
				FieldError fieldError =(FieldError) error;
				String message = fieldError.getField()+error.getDefaultMessage();
				System.out.println(message);
			});
		 */
		}
		logger.info(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
		user.setId("1");
		return user;
	}
	
	@DeleteMapping("/{id:\\d+}")
	@ApiOperation(value = "删除用户")
	public void update(@PathVariable String id){
		logger.info("删除ID为"+id);
	}
}
