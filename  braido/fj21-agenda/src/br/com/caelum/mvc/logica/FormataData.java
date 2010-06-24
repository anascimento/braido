package br.com.caelum.mvc.logica;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.taglibs.display.test.ListObject;
import org.displaytag.decorator.TableDecorator;

public class FormataData extends TableDecorator {

	public String getDate() {
		ListObject lObject = (ListObject) getCurrentRowObject();
		Date date = lObject.getDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy");
		return dateFormat.format(date).toString();
	}
}
