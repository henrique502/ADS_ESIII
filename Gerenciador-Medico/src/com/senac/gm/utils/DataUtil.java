package com.senac.gm.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DataUtil {

	public static final DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static final DateFormat timeView = new SimpleDateFormat("HH:mm");
	public static final DateFormat dateView = new SimpleDateFormat("dd/MM/yyyy");
	public static final DateFormat dateTimeView = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	
}
