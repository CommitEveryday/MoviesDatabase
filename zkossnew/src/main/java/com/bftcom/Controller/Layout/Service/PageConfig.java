package com.bftcom.Controller.Layout.Service;

import java.util.List;

/**
 * Created by Marolok on 08.01.2015.
 */
public interface PageConfig {
    //Получить все страницы, расположенный на SideBar
    public List<Page> getPages();
    //Получиьт страницу по имени
    public Page getPage(String name);
}
