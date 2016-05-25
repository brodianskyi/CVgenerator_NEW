package com.codecentric.cvgenerator.utils.stringutils;

import java.util.ArrayList;
import java.util.List;

public class StringTokenizer {

	private String CommaTocken = "";

	public String getRightdate(String str, String tocken) {
		CommaTocken = tocken;
		String buf = "";
		List<String> right_date_list = getCommaValues(str);
		for (int j = right_date_list.size() - 1; j > -1; j--) {

			buf += right_date_list.get(j) + ".";
		}
		buf = buf.substring(0, buf.length() - 1);

		return buf;
	}

	private List<String> getCommaValues(String str) {

		List<String> list = new ArrayList<String>();
		if (str.indexOf(CommaTocken) > 0) {
			String result = "";
			do {
				result = str.substring(0, str.indexOf(CommaTocken));
				str = str.substring(str.indexOf(CommaTocken) + 1) + CommaTocken;
				if (result.substring(0, 1).equals(",")) {
					result = result.substring(1);
				}
				list.add(result);
			} while (str.indexOf(CommaTocken) > 0);

		} else
			list.add(str);

		return list;
	}
}
