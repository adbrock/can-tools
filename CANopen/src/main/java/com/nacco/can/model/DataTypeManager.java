package com.nacco.can.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DataTypeManager {
	private static final String DEFAULT_PATH = "scripts/data";
	private static DataTypeManager instance;
	private ScriptEngineManager mgr;
	private ScriptEngine pyEngine;

	private ListProperty<DataType> availableDataTypes;

	private DataTypeManager() {
		this.availableDataTypes = new SimpleListProperty<DataType>(this, "availableDataTypes", FXCollections.observableArrayList());

		mgr = new ScriptEngineManager();
		pyEngine = mgr.getEngineByName("python");
	}

	public static DataTypeManager getInstance() {
		if (instance == null) {
			instance = new DataTypeManager();
		}
		return instance;
	}

	public void load() throws FileNotFoundException, ScriptException {
		File defaultDirectory =  Paths.get(DEFAULT_PATH).toFile();
		defaultDirectory = new File(defaultDirectory.getAbsolutePath());
		System.out.println(defaultDirectory.getAbsolutePath());
		File[] scriptFiles = null;
		if (defaultDirectory.exists() && defaultDirectory.isDirectory()) {
			scriptFiles = defaultDirectory.listFiles((dir, name) -> name.endsWith(".py"));
		}

		if (scriptFiles != null) {
			for (File file : scriptFiles) {
				availableDataTypes.add(new DataType(file));
			}
		}
	}

	public ScriptEngine getScriptEngine() {
		return this.pyEngine;
	}

	public ObservableList<DataType> getAvailableDataTypes() {
		return this.availableDataTypes.get();
	}
}
