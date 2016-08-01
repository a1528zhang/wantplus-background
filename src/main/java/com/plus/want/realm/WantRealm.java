package com.plus.want.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.plus.want.entity.user.User;
import com.plus.want.service.UserService;
import com.plus.want.util.CommonUtil;

public class WantRealm extends AuthorizingRealm{
	@Resource
	private UserService userService;
	
	/**
	 * 登录成功后自动调用，为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(userService.getRoles(username));
		authorizationInfo.setStringPermissions(userService.getPermissions(username));
		return authorizationInfo;
	}

	/**
	 * 调用login()后自动调用，验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String)token.getPrincipal();
		User user = new User();
		user=userService.getByUserName(username);
		if(user!=null){
			//usernaem(email)当做登录凭证
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"userAccount");
			return authcInfo;
		}else{
			return null;				
		}
	}
}
