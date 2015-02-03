package com.bftcom.Controller;

import com.project.Model.Service.HibernateFactory;
import com.project.Model.entity.User_acount;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class UsersController extends SelectorComposer<Component> {
    @Wire
    private Listbox userTable;
    @Wire
    private Button addBt;
    @Wire
    private Button updateBt;
    @Wire
    private Button deleteBt;

    @Listen("onCreate = #userTable")
    public void load(){
        getPage().getDesktop().setBookmark("p_Users");
        userTable.setModel(new ListModelList<User_acount>(HibernateFactory.user_acountHiber.getAll(User_acount.class)));
    }

    @Listen("onClick = #addBt")
    public void add(){
        Sessions.getCurrent().setAttribute("selectUser", null);
        Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
        include.setSrc("Table/addUser.zul");
    }

    @Listen("onClick = #updateBt")
    public void update(){
        if(userTable.getSelectedItem() == null){
            Clients.showNotification("Выберите пользователя.", userTable);
            return;
        }
        else {
            Sessions.getCurrent().setAttribute("selectUser", userTable.getSelectedItem().getValue());
            Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
            include.setSrc("Table/updateUser.zul");
        }
    }

    @Listen("onClick = #deleteBt")
    public void delete(){
        if(userTable.getSelectedItem() == null){
            Clients.showNotification("Выберите пользователя.", userTable);
            return;
        }
        else {
            User_acount curUser = userTable.getSelectedItem().getValue();
            userTable.getItems().remove(userTable.getSelectedIndex());
            HibernateFactory.user_acountHiber.remove(curUser);
            userTable.setModel(new ListModelList<User_acount>(HibernateFactory.user_acountHiber.getAll(User_acount.class)));
        }
    }
}

