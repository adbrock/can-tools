package com.nacco.fxtensions;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;

import com.nacco.can.model.CANObject;

public class DataPropertyValueFactory implements Callback<CellDataFeatures<CANObject, String>, ObservableValue<String>> {

	@Override
	public ObservableValue<String> call(CellDataFeatures<CANObject, String> param) {
		CANObject object = param.getValue().getValue();
		StringProperty retValue = new SimpleStringProperty();
		
		byte[] dataBytes = new byte[object.getData().]

		switch (object.getDataType()) {

		case UNSIGNED:
			retValue.set(new String());
		case SIGNED:
		case REAL:
		case ASCII:
		case UNICODE:
			
		}

		return null;
	}

}
