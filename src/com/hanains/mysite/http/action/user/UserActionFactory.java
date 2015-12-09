package com.hanains.mysite.http.action.user;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;
import com.hanains.mysite.http.action.main.IndexAction;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		
		//action 이 null 인 경우가 있을 수 있고,
		//사용자가 다른 값을 넣어버리면..? 어디로 돌리지.?
		
		// 회원 정보에 링크를 걸어 둬야 겠지?...
		if("joinform".equals(actionName)){
			action = new JoinFormAction();
		}else if("join".equals(actionName)){
			action = new JoinAction();
			
		}else if("joinsuccess".equals(actionName)){
			action = new JoinSuccessAction();
			
		}else if("loginform".equals(actionName)){
			action = new LoginFormAction();
			
		}else if("login".equals(actionName)){
			action = new LoginAction();
			
		}else if("logout".equals(actionName)){
			action = new LogoutAction();
			
		}else{
			action = new IndexAction();
			// 관련된게 없으면 어디로 보낼까. 
			//일단은 main 으로 가긴 하는데.
		}
		
		return action;
	}

}
