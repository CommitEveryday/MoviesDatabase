package com.Controller.Layout;

import com.Controller.Layout.Service.Page;
import com.Controller.Layout.Service.PageConfig;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class PageConfigImpl implements PageConfig {
    //Список страниц приложения, которые будут на Sidebar
    private HashMap<String,Page> pageMap = new LinkedHashMap<String,Page>();

    public PageConfigImpl(){
        pageMap.put("homePage",new Page("homePage","На главную","home.zul","Sidebar"));
        pageMap.put("users",new Page("users","Пользователи","/Table/users.zul","Sidebar"));
        pageMap.put("addUser",new Page("addUser","Добавление нового пользователя","/Table/addUser.zul","Sidebar"));
        pageMap.put("movies",new Page("movies","Фильмы","/Table/movies.zul","Sidebar"));
    }

    public List<Page> getPages(){
        return new ArrayList<Page>(pageMap.values());
    }

    public Page getPage(String name){
        return pageMap.get(name);
    }

}