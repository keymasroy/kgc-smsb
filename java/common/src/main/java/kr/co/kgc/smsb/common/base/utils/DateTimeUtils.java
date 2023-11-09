package kr.co.kgc.smsb.common.base.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public enum Pattern {
		yyyyMMdd("yyyyMMdd"),
		yyyyMMddHHmmss("yyyyMMddHHmmss");

		private String PatternString;
		Pattern(String PatternString) {
			this.PatternString = PatternString;
		}

		public String get() {
			return this.PatternString;
		}
	}

	/***
	 * �⺻������ yyyyMMddHHmmss ���� ������ ��¥ ��ȯ
	 * @return
	 */
	public static String NowDateTime() {
		return NowDateTime("yyyyMMddHHmmss");
	}

	/***
	 * DateTime Formatter�� �´� ��¥ ���� ��ȯ
	 * @param dtPattern ex) yyyyMMddHHmmss
	 * @return String ���ڿ�
	 */
	public static String NowDateTime(String dtPattern) {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dtPattern);
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		return now.format(dtFormat);
	}
}
