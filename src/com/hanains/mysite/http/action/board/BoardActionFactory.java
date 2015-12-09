package com.hanains.mysite.http.action.board;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		
		
		if("insert".equals(actionName)){
			action = new InsertAction();
		}else if("write".equals(actionName)){
			action = new WriteAction();
		}else if("view".equals(actionName)){
			action = new ViewAction();
		}else if("modify".equals(actionName)){
			action = new ModifyAction();
		}else{
			action = new ListAction();
		}
		
		return action;
	}

}
