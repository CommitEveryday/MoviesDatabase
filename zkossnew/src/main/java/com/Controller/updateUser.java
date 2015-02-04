package com.Controller;

import com.project.Model.Service.HibernateFactory;
import com.project.Model.entity.User_acount;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;
import org.zkoss.zul.Textbox;

public class updateUser extends SelectorComposer<Component> {
    @Wire
    private Textbox login;
    @Wire
    private Textbox password;

    private User_acount user;

    @Listen("onCreate = #updateUser")
    public void load() {
        getPage().getDesktop().setBookmark("p_updateUser");
        user = (User_acount) Sessions.getCurrent().getAttribute("selectUser");

        if (user == null){
            Clients.showNotification("Не задан пользователь для обновления");
        }
        else {
            login.setValue(user.getLogin());
            password.setValue(user.getPassword());
        }
    }

    @Listen("onClick = #saveUpUser")
    public void save()    {
        if(user==null)
            return;
        if(login.getValue().isEmpty()){
            Clients.showNotification("Поле не может быть пустым", login);
            return;
        }
        if(password.getValue().isEmpty()){
            Clients.showNotification("Поле не может быть пустым", password);
            return;
        }
        user.setLogin(login.getValue());
        user.setPassword(password.getValue());
        HibernateFactory.user_acountHiber.update(user);

        Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
        include.setSrc("Table/users.zul");
    }

    @Listen("onClick = #cancelUpdateUser")
    public void cancel()    {
        Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
        include.setSrc("Table/users.zul");
    }
}
