/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.india;

import java.awt.Component;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Bhupendra
 */
public class ManufacturerRenderer extends BasicComboBoxRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
        if (value != null) {
            Manufacturer m = (Manufacturer) value;
            setText(m.getName().toUpperCase());
        }
        if (index == -1) {
            Manufacturer m = (Manufacturer) value;
            setText("" + m.getId());
        }
        return this;
    }

}
