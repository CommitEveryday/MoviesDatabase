package com.Controller.Layout;

import com.Controller.Layout.Service.PageConfig;
import com.Controller.Layout.Service.Page;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.BookmarkEvent;
import org.zkoss.zk.ui.event.SerializableEventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Include;

public class BookmarkChangeController extends SelectorComposer<Component> {
    private PageConfig pageConfig = new PageConfigImpl();
    //private MainPageConfig

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        if (comp.getParent() != null) {
            throw new RuntimeException("A bookmark change listener can only apply on the root comp");
        }
        //Записываем в историю главную страницу
        getPage().getDesktop().setBookmark("p_homePage");
        comp.addEventListener("onBookmarkChange", new SerializableEventListener<BookmarkEvent>() {
            public void onEvent(BookmarkEvent event) throws Exception {
                String bookmark = event.getBookmark();
                if(bookmark.startsWith("p_")){
                    String p = bookmark.substring("p_".length());
                    Page page = pageConfig.getPage(p);
                    if(page!=null){
                        Include include = (Include) Selectors.iterable(getPage(), "#mainInclude").iterator().next();
                        include.setSrc(page.getUri());
                    }
                }
            }
        });
    }
}
