package com.bftcom.Controller;

import com.project.Model.Service.HibernateFactory;
import com.project.Model.entity.User_acount;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;
import org.zkoss.zul.Textbox;

public class addUser extends SelectorComposer<Component> {
    @Wire
    private Textbox login;
    @Wire
    private Textbox password;

    @Listen("onCreate = #addUser")
    public void load()    {
        getPage().getDesktop().setBookmark("p_addUser");
    }

    @Listen("onClick = #saveUser")
    public void save()    {
        if(login.getValue().isEmpty()){
            Clients.showNotification("Поле не может быть пустым", login);
            return;
        }
        if(password.getValue().isEmpty()){
            Clients.showNotification("Поле не может быть пустым", password);
            return;
        }

        User_acount user = new User_acount();
        user.setLogin(login.getValue());
        user.setPassword(password.getValue());
        try {
            HibernateFactory.user_acountHiber.add(user);
        } catch (Exception ex)
        {
            Clients.showNotification(ex.getMessage());
        }

        Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
        include.setSrc("Table/users.zul");
    }

    @Listen("onClick = #cancelAddUser")
    public void cancel()    {
        Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
        include.setSrc("Table/users.zul");
    }
}
