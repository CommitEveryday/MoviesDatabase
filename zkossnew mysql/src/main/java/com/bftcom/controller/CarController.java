package com.bftcom.controller;

import com.bftcom.model.Car;
import com.bftcom.service.CarService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.List;

/**
 * Created by 1121Len on 12.11.2014.
 */
public class CarController extends SelectorComposer<Component> {
    @Wire
    private Textbox keywordBox;
    @Wire
    private Listbox carListbox;
    @Wire
    private Label modelLabel;
    @Wire
    private Label priceLabel;

    @Listen("onClick = #searchButton")
    public void search(){
        String keyword = keywordBox.getValue();
        List<Car> result = (new CarService()).find(keyword);
        carListbox.setModel(new ListModelList<Car>(result));
    }

    @Listen("onSelect = #carListbox")
    public void showDetail(){
        Car selected = carListbox.getSelectedItem().getValue();
        modelLabel.setValue(selected.getModel());
        priceLabel.setValue(selected.getPrice().toString());
    }
}
