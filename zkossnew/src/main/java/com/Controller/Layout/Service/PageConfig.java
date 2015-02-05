package com.Controller.Layout.Service;

import java.util.List;

public interface PageConfig {
    //Получить все страницы, расположенный на SideBar
    public List<Page> getPages();
    //Получиьт страницу по имени
    public Page getPage(String name);
}
