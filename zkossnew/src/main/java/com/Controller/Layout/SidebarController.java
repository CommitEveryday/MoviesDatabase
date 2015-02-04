package com.Controller.Layout;

import com.Controller.Layout.Service.PageConfig;
import com.Controller.Layout.Service.Page;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class SidebarController extends SelectorComposer<Component> {
    @Wire
    Grid fnList;

    PageConfig pageConfig = new PageConfigImpl();

    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);
        //Инициализация SideBar
        Rows rows = fnList.getRows();
        for(Page page:pageConfig.getPages()){
            if (page.getLocation().equals("Sidebar")) {
                Row row = constructSidebarRow(page.getName(), page.getLabel(), page.getUri());
                rows.appendChild(row);
            }
        }
    }

    private Row constructSidebarRow(final String name,String label, final String locationUri) {
        Row row = new Row();
        Label lab = new Label(label);
        row.appendChild(lab);
        row.setStyle("cursor:hand;cursor:pointer");
        //При нажатии на строку вызовем событие
        EventListener<Event> onActionListener = new SerializableEventListener<Event>(){
            private static final long serialVersionUID = 1L;

            public void onEvent(Event event) throws Exception {
            if(locationUri.startsWith("http")){
                Executions.getCurrent().sendRedirect(locationUri);
            }else{
                Include include = (Include) Selectors.iterable(fnList.getPage(), "#mainInclude")
                        .iterator().next();
                include.setSrc(locationUri);
                //Добавим в историю страницу
                if(name!=null){
                    getPage().getDesktop().setBookmark("p_"+name);
                }
            }
            }
        };
        row.addEventListener(Events.ON_CLICK, onActionListener);
        return row;
    }
}
